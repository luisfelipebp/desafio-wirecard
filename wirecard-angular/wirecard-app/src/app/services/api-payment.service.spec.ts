import { TestBed } from '@angular/core/testing';

import { ApiPaymentService } from './api-payment.service';

describe('ApiPaymentService', () => {
  let service: ApiPaymentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiPaymentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
