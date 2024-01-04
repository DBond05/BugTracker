import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BugdetailsComponent } from './bugdetails.component';

describe('BugdetailsComponent', () => {
  let component: BugdetailsComponent;
  let fixture: ComponentFixture<BugdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BugdetailsComponent]
    });
    fixture = TestBed.createComponent(BugdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
