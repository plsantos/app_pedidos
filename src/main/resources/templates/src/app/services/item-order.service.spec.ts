import { TestBed } from '@angular/core/testing';

import { ItemOrderService } from './item-order.service';

describe('ItemOrderService', () => {
  let service: ItemOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
