import { TestBed } from '@angular/core/testing';

import { OrderProductService } from './order-product.service';
import { RouterTestingModule } from '@angular/router/testing'
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('OrderProductService', () => {
  let service: OrderProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule]
    });
    service = TestBed.inject(OrderProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
