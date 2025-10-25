import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input()
  dataFromParent : String = "";
  /**
   * TODO: After todoData has been property bound from
   * the parent component's HTML template, you should mark
   * this variable with the @Input decorator so that this
   * component will know to receive the value via property
   * binding.
   */
  @Input()
  todoData: String = "";

  constructor() { }

  ngOnInit(): void {
  }

}
