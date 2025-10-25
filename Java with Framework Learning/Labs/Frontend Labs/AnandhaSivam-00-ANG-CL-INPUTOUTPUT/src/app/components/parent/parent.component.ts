import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  /**
   * These two variables are passed to child components
   * from this component's HTML template
   */
  var1: String = "";
  var2: String = "";
  /**
   * this variable should be passed into the child component from
   * this component's HTML template
   */
  todoData: String = "";

  constructor() { }

  ngOnInit(): void {
  }

}
