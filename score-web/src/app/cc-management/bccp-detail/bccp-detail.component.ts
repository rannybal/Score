import {Component, Injectable, OnInit} from '@angular/core';
import {CollectionViewer, SelectionChange, SelectionModel} from '@angular/cdk/collections';
import {FlatTreeControl} from '@angular/cdk/tree';
import {BehaviorSubject, merge, Observable} from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ReleaseService} from '../../release-management/domain/release.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CcNodeService} from '../domain/core-component-node.service';
import {
  CcAccNode,
  CcAccNodeDetail,
  CcAsccpNodeDetail,
  CcBccpNode,
  CcBccpNodeDetail,
  CcBdtScNodeDetail,
  CcNode,
  CcNodeDetail,
  DynamicCcFlatNode,
  EntityType,
  EntityTypes,
  OagisComponentType,
  OagisComponentTypes
} from '../domain/core-component-node';

@Injectable()
export class DynamicCcDataSource {

  dataChange = new BehaviorSubject<DynamicCcFlatNode[]>([]);

  constructor(private component: BccpDetailComponent,
              private treeControl: FlatTreeControl<DynamicCcFlatNode>,
              private service: CcNodeService) {
  }

  get data(): DynamicCcFlatNode[] {
    return this.dataChange.value;
  }

  set data(value: DynamicCcFlatNode[]) {
    this.treeControl.dataNodes = value;
    this.dataChange.next(value);
  }

  connect(collectionViewer: CollectionViewer): Observable<DynamicCcFlatNode[]> {
    this.treeControl.expansionModel.changed.subscribe(change => {
      if ((change as SelectionChange<DynamicCcFlatNode>).added ||
        (change as SelectionChange<DynamicCcFlatNode>).removed) {
        this.handleTreeControl(change as SelectionChange<DynamicCcFlatNode>);
      }
    });

    return merge(collectionViewer.viewChange, this.dataChange).pipe(map(() => this.data));
  }

  /** Handle expand/collapse behaviors */
  handleTreeControl(change: SelectionChange<DynamicCcFlatNode>) {
    if (change.added) {
      change.added.forEach(node => this.toggleNode(node, true));
    }
    if (change.removed) {
      change.removed.slice().reverse().forEach(node => this.toggleNode(node, false));
    }
  }

  /**
   * Toggle the node, remove from display list
   */
  toggleNode(node: DynamicCcFlatNode, expand: boolean) {
    const index = this.data.indexOf(node);
    // If it cannot find the node, no op
    if (index < 0) {
      return;
    }

    if (expand) {
      node.isLoading = true;
      this.service.getChildren(node.item, this.component.releaseId).subscribe(children => {
        if (!children) { // If no children, no op
          return;
        }

        const nodes = children.map(item =>
          new DynamicCcFlatNode(item, node.level + 1));
        this.data.splice(index + 1, 0, ...nodes);

        // notify the change
        this.dataChange.next(this.data);
        node.isLoading = false;
      }, err => {
        node.isLoading = false;
      });

    } else {
      this.treeControl.getDescendants(node).forEach((e: DynamicCcFlatNode) => {
        if (this.treeControl.isExpanded(e)) {
          this.treeControl.collapse(e);
        }
      });

      let count = 0;
      for (let i = index + 1; i < this.data.length && this.data[i].level > node.level; i++, count++) {
      }
      this.data.splice(index + 1, count);

      // notify the change
      this.dataChange.next(this.data);
    }
  }

  loadDetail(node: DynamicCcFlatNode, callbackFn?) {
    this.service.getDetail(node.item, this.component.releaseId).subscribe(detail => {
      return callbackFn && callbackFn(detail);
    });
  }

  onSelect(...nodes: DynamicCcFlatNode[]) {

  }

  onDeselect(...nodes: DynamicCcFlatNode[]) {

  }
}

export class CustomTreeControl<T> extends FlatTreeControl<T> {
  getParent(node: T) {
    const currentLevel = this.getLevel(node);

    if (currentLevel <= 0) {
      return undefined;
    }

    const startIndex = this.dataNodes.indexOf(node) - 1;

    for (let i = startIndex; i >= 0; i--) {
      const currentNode = this.dataNodes[i];

      if (this.getLevel(currentNode) < currentLevel) {
        return currentNode;
      }
    }
  }
}

@Component({
  selector: 'score-bccp-detail',
  templateUrl: './bccp-detail.component.html',
  styleUrls: ['./bccp-detail.component.css']
})
export class BccpDetailComponent implements OnInit {

  title: string;
  _innerHeight: number = window.innerHeight;
  paddingPixel = 15;
  releaseId: number;
  isUpdating: boolean;
  componentTypes: OagisComponentType[] = OagisComponentTypes;
  entityTypes: EntityType[] = EntityTypes;

  rootNode: DynamicCcFlatNode;
  treeControl: CustomTreeControl<DynamicCcFlatNode>;
  dataSource: DynamicCcDataSource;

  detail: CcNodeDetail;
  selectedNode: DynamicCcFlatNode;

  checklistSelection = new SelectionModel<DynamicCcFlatNode>(true /* multiple */);

  constructor(private service: CcNodeService,
              private releaseService: ReleaseService,
              private route: ActivatedRoute,
              private snackBar: MatSnackBar) {

  }

  ngOnInit() {
    this.treeControl = new CustomTreeControl<DynamicCcFlatNode>(this.getLevel, this.isExpandable);
    this.dataSource = new DynamicCcDataSource(this, this.treeControl, this.service);

    this.route.paramMap.pipe(
      switchMap((params: ParamMap) => {
        this.releaseId = parseInt(params.get('releaseId'), 10);
        return this.service.getBccpNode(params.get('bccpId'), this.releaseId);
      })).subscribe(resp => {
      this.title = 'Structure of ' + resp.name + ' BCCP';
      this.rootNode = new DynamicCcFlatNode(resp);
      this.dataSource.data = [this.rootNode];
      this.onClick(this.rootNode);
    });

    this.isUpdating = false;
  }

  getLevel = (node: DynamicCcFlatNode) => node.level;
  isExpandable = (node: DynamicCcFlatNode) => node.expandable;
  hasChild = (_: number, _nodeData: DynamicCcFlatNode) => _nodeData.expandable;

  onResize(event) {
    this._innerHeight = window.innerHeight;
  }

  get innerHeight(): number {
    return this._innerHeight - 160;
  }

  type(node: DynamicCcFlatNode) {
    const nodeItem: CcNode = node.item;
    let typeStr = nodeItem.type;
    if (typeStr === 'acc') {
      const accNode: CcAccNode = nodeItem as CcAccNode;
      if (accNode.group) {
        typeStr = typeStr + '-group';
      }
    } else if (typeStr === 'bccp') {
      const bccpNode: CcBccpNode = nodeItem as CcBccpNode;
      if (bccpNode.attribute) {
        typeStr = typeStr + '-attribute';
      }
    }
    return typeStr;
  }

  get state() {
    return this.rootNode.item.state;
  }

  itemSelectionToggle(node: DynamicCcFlatNode) {
    this.checklistSelection.toggle(node);

    const selected: boolean = this.checklistSelection.isSelected(node);
    if (selected) {
      this.dataSource.onSelect(node);
    } else {
      this.dataSource.onDeselect(node);
    }

    let parent = this.treeControl.getParent(node);
    while (parent !== undefined) {

      if (selected) {

        this.checklistSelection.select(parent);
        this.dataSource.onSelect(parent);

      } else {

        if (this.treeControl.getDescendants(parent).length === 0) {
          this.checklistSelection.deselect(parent);
          this.dataSource.onDeselect(parent);
        }

      }

      parent = this.treeControl.getParent(parent);
    }

    if (!selected) {
      const descendants = this.treeControl.getDescendants(node);
      this.checklistSelection.deselect(...descendants);
      this.dataSource.onDeselect(...descendants);
    }
  }

  onClick(node: DynamicCcFlatNode) {
    this.dataSource.loadDetail(node, (detail: CcNodeDetail) => {
      this.selectedNode = node;
      this.detail = detail;
    });
  }

  /* For type casting of detail property */
  isAccDetail(detail?: CcNodeDetail): boolean {
    if (!detail) {
      detail = this.detail;
    }
    return (detail !== undefined) && (detail.type === 'acc');
  }

  asAccDetail(detail?: CcNodeDetail): CcAccNodeDetail {
    if (!detail) {
      detail = this.detail;
    }
    return detail as CcAccNodeDetail;
  }

  isAsccpDetail(detail?: CcNodeDetail): boolean {
    if (!detail) {
      detail = this.detail;
    }
    return (detail !== undefined) && (detail.type === 'asccp');
  }

  asAsccpDetail(detail?: CcNodeDetail): CcAsccpNodeDetail {
    if (!detail) {
      detail = this.detail;
    }
    return detail as CcAsccpNodeDetail;
  }

  isBccpDetail(detail?: CcNodeDetail): boolean {
    if (!detail) {
      detail = this.detail;
    }
    return (detail !== undefined) && (detail.type === 'bccp');
  }

  asBccpDetail(detail?: CcNodeDetail): CcBccpNodeDetail {
    if (!detail) {
      detail = this.detail;
    }
    return detail as CcBccpNodeDetail;
  }

  isBdtScDetail(detail?: CcNodeDetail): boolean {
    if (!detail) {
      detail = this.detail;
    }
    return (detail !== undefined) && (detail.type === 'bdt_sc');
  }

  asBdtScDetail(detail?: CcNodeDetail): CcBdtScNodeDetail {
    if (!detail) {
      detail = this.detail;
    }
    return detail as CcBdtScNodeDetail;
  }

}
