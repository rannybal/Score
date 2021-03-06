import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CcList, CcListRequest} from '../cc-list/domain/cc-list';
import {SelectionModel} from '@angular/cdk/collections';
import {CcListService} from '../cc-list/domain/cc-list.service';
import {AccountListService} from '../../account-management/domain/account-list.service';
import {CcNodeService} from '../domain/core-component-node.service';
import {Router} from '@angular/router';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';
import {PageRequest} from '../../basis/basis';

@Component({
  selector: 'score-bccp-create',
  templateUrl: './bccp-create.component.html',
  styleUrls: ['./bccp-create.component.css']
})
export class BccpCreateComponent implements OnInit {
  title = 'BCCP';
  displayedColumns: string[] = [
    'select', 'state', 'den', 'lastUpdateTimestamp'
  ];
  dataSource = new MatTableDataSource<CcList>();
  selection = new SelectionModel<number>(false, []);
  loading = false;

  bccpId: number;
  loginIdList: string[] = [];
  request: CcListRequest;

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private ccListService: CcListService,
              private accountService: AccountListService,
              private service: CcNodeService,
              private snackBar: MatSnackBar,
              private router: Router) {
  }

  ngOnInit() {
    this.request = new CcListRequest();
    this.request.releaseId = 1;
    this.request.types = ['BDT'];
    this.request.states = ['Published', 'Editing'];

    this.paginator.pageIndex = 0;
    this.paginator.pageSize = 10;
    this.paginator.length = 0;

    this.sort.active = 'den';
    this.sort.direction = 'asc';
    this.sort.sortChange.subscribe(() => {
      this.paginator.pageIndex = 0;
      this.onChange();
    });

    this.accountService.getAccountNames().subscribe(loginIds => this.loginIdList.push(...loginIds));
    this.onChange();
    this.service.getLastBccp().subscribe(lastId => {
      this.bccpId = +lastId + 1;
    });
  }

  onPageChange(event: PageEvent) {
    this.onChange();
  }

  onDateEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    switch (type) {
      case 'startDate':
        this.request.updatedDate.start = new Date(event.value);
        break;
      case 'endDate':
        this.request.updatedDate.end = new Date(event.value);
        break;
    }
  }

  reset(type: string) {
    switch (type) {
      case 'startDate':
        this.request.updatedDate.start = null;
        break;
      case 'endDate':
        this.request.updatedDate.end = null;
        break;
    }
  }

  onChange() {
    this.loading = true;

    this.request.page = new PageRequest(
      this.sort.active, this.sort.direction,
      this.paginator.pageIndex, this.paginator.pageSize);

    this.ccListService.getCcList(this.request).subscribe(resp => {
      this.paginator.length = resp.length;

      const list = resp.list.map((elm: CcList) => {
        elm.lastUpdateTimestamp = new Date(elm.lastUpdateTimestamp);
        if (this.request.filters.module.length > 0) {
          elm.module = elm.module.replace(
            new RegExp(this.request.filters.module, 'ig'),
            '<b>$&</b>');
        }
        if (this.request.filters.definition.length > 0) {
          elm.definition = elm.definition.replace(
            new RegExp(this.request.filters.definition, 'ig'),
            '<b>$&</b>');
        }
        return elm;
      });

      this.dataSource.data = list;
      this.loading = false;
    });
  }

  select(row: CcList) {
    this.selection.select(row.id);
  }

  toggle(row: CcList) {
    if (this.isSelected(row)) {
      this.selection.deselect(row.id);
    } else {
      this.select(row);
    }
  }

  isSelected(row: CcList) {
    return this.selection.isSelected(row.id);
  }

  next() {
    const bccpId = this.bccpId;
    const seqKey = 1;
    const accId: number = this.selection.selected[0];

    this.service.createAsccp(bccpId, accId, seqKey).subscribe(_ => {
      this.snackBar.open('Created', '', {
        duration: 3000,
      });

      this.router.navigateByUrl('/core_component/bccp/' + bccpId);
    });
  }

}
