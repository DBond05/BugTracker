import { TestBed } from '@angular/core/testing';

import { BugserviceService } from './bugservice.service';

describe('BugserviceService', () => {
  let service: BugserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BugserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
