import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CountService {

  num:number = 0;
  constructor() { }

  getNum():number {
    return this.num;
  }
  incrementNum():void {
    this.num++;
  }
  /**
   * TODO: write a service method that decrements num for use in the decrementor component.
   */
  decrementNum():void {
    this.num--;
  }
}
