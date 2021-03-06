import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReuseBieDialogComponent } from './reuse-bie-dialog.component';

describe('ReuseBieDialogComponent', () => {
  let component: ReuseBieDialogComponent;
  let fixture: ComponentFixture<ReuseBieDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReuseBieDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReuseBieDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
