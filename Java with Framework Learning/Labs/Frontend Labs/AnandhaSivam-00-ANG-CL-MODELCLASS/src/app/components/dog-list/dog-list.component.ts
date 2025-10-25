import { Component, OnInit } from '@angular/core';
import {Dog} from "../../models/dog";
import {DogsService} from "../../services/dogs.service";

@Component({
  selector: 'app-dog-list',
  templateUrl: './dog-list.component.html',
  styleUrls: ['./dog-list.component.css']
})
export class DogListComponent implements OnInit {

  nameInput : string = "";
  breedInput : string = "";
  ageInput : number = 0;
  dogs : Dog[] = this.dogsService.dogs;
  constructor(private dogsService: DogsService) { }

  /**
   * TODO: create a new Dog Object, and use the addDog method provided in the DogsService to add the new dog.
   *
   * Firstly, you need to understand how to create an object based off of an interface. Using an interface instead of a
   * class to model data is accepted and common in Angular development. The general concept of an interface being a
   * 'contractual guarantee of behavior' still applies.
   *
   * the syntax would look a bit like this:
   * let objName : interfaceName = {stringField: "value1", numberField: 123};
   * in your case, you should use the this.nameInput, this.breedInput, this.ageInput fields rather than "value1" and 123
   * to create the new Dog based off the Dog interface. After creating the new Object (let's say it's called newDog),
   * you should call the dogsService.addDog(newDog); method.
   */
  addDog(){
    let newDog: Dog = {
      name: this.nameInput,
      breed: this.breedInput,
      age: this.ageInput
    };

    this.dogsService.addDog(newDog);
  }

  ngOnInit(): void {
  }

}
