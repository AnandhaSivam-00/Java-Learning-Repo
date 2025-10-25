import { Injectable } from '@angular/core';
import {Dog} from "../models/dog";

@Injectable({
  providedIn: 'root'
})
export class DogsService {
  
  dogs : Dog[] = [];

  constructor() { }

  addDog(dog: Dog):void {
    this.dogs.push(dog)
  }
}
