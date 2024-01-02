import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BugformComponent } from './bugform.component';

describe('BugformComponent', () => {
  let component: BugformComponent;
  let fixture: ComponentFixture<BugformComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BugformComponent]
    });
    fixture = TestBed.createComponent(BugformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
