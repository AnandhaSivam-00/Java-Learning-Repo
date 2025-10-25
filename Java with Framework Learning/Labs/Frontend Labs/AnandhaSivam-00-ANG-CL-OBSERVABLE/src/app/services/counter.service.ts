import { Injectable } from '@angular/core';
import {interval, Observable, take, timeout, timer} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CounterService {

  constructor() { }

  /**
   * the interval method returns an observable after some time, which is a way to send data asynchronously over our app.
   * we want to do this 10+1 times.
   */
  getCounterSeconds():Observable<number>{
    return interval(1000).pipe(take(10+1));
  }
  
  /**
   * the interval method returns an observable after some time, which is a way to send data asynchronously over our app.
   * we want to do this 1000+1 times.
   */
  getCounterMilliseconds():Observable<number>{
    return interval(1).pipe(take(1000+1));
  }
}
