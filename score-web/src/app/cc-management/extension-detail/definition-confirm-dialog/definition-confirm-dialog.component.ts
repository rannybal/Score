import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

@Component({
  selector: 'srt-confirm-dialog',
  templateUrl: './definition-confirm-dialog.component.html',
  styleUrls: ['./definition-confirm-dialog.component.css']
})
export class DefinitionConfirmDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DefinitionConfirmDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit() {
  }

}