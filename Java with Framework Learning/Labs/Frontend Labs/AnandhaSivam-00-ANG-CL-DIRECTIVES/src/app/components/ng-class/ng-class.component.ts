import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-class',
  templateUrl: './ng-class.component.html',
  styleUrls: ['./ng-class.component.css']
})
export class NgClassComponent implements OnInit {
  /**
   * This variable will contain the names of classes that may be used in CSS styling.
   */
  componentClass: String = "RedElement";

  /**
   * Swap the component classes between RedElement and BlueElement.
   */
  switchComponentClass() {
      if(this.componentClass == "RedElement"){
        this.componentClass = "BlueElement";
      }else{
        this.componentClass = "RedElement"
      }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
