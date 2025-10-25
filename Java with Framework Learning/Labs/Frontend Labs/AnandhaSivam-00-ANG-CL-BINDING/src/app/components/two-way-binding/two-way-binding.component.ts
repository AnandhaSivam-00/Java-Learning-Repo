import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-two-way-binding',
  templateUrl: './two-way-binding.component.html',
  styleUrls: ['./two-way-binding.component.css']
})
export class TwoWayBindingComponent implements OnInit {
  /**
   * these are the two TS variables that are bound to the HTML template via two-way binding.
   * As the user types in the input box, the values in TypeScript code and the value inside the input box
   * are updated simultaneously. Check out the html template for this component to see how a two-way binding is created.
   */
  inputText1: String = "";
  inputText2: String = "";

  constructor() { }

  ngOnInit(): void {
  }

}
