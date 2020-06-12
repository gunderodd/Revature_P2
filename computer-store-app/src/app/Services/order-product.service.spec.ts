import { TestBed } from '@angular/core/testing';

import { OrderProductService } from './order-product.service';
<<<<<<< Updated upstream
=======
import { RouterTestingModule } from '@angular/router/testing'
import { HttpClientTestingModule } from '@angular/common/http/testing';
>>>>>>> Stashed changes

describe('OrderProductService', () => {
  let service: OrderProductService;

  beforeEach(() => {
<<<<<<< Updated upstream
    TestBed.configureTestingModule({});
=======
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule]
    });
>>>>>>> Stashed changes
    service = TestBed.inject(OrderProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
