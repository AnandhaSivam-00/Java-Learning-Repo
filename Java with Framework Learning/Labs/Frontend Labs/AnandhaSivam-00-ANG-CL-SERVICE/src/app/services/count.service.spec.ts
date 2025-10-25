import { TestBed } from '@angular/core/testing';

import { CountService } from './count.service';

describe('CountService', () => {
  let service: CountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should increment when incrementNum is called', () => {
    service.num = 5;
    service.incrementNum();
    expect(service.num).toEqual(6);
  });

  it('should decrement when decrementNum is called', () => {
    service.num = 5;
    service.decrementNum();
    expect(service.num).toEqual(4);
  })

  it('should decrement when decrementNum is called, negative numbers', () => {
    service.num = -10;
    service.decrementNum();
    expect(service.num).toEqual(-11);
  })

  it('should decrement when decrementNum is called, large numbers', () => {
    service.num = 500;
    service.decrementNum();
    expect(service.num).toEqual(499);
  })
});
