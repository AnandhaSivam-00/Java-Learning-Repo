import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-button-menu',
  templateUrl: './button-menu.component.html',
  styleUrls: ['./button-menu.component.css']
})
export class ButtonMenuComponent implements OnInit {

  /**
   * An event emitter which will be used to produce incrementEvents, which are events that may be sent to the parent
   * component to trigger an increment of the 'num' value.
   */
  @Output()
  incrementEvent : EventEmitter<any> = new EventEmitter<any>();
  /**
   * TODO: provide an EventEmitter intended for decrementing the parent component's count value.
   */
  @Output()
  decrementEvent : EventEmitter<any> = new EventEmitter<any>();

  /**
   * This method will fire when a button is clicked, and will emit an incrementEvent to the parent component.
   */
  increment() {
    this.incrementEvent.emit();
  }

  /**
   * TODO: emit a decrementEvent to the parent component once the decrementEvent EventEmitter has been set up.
   */
  decrement() {
    this.decrementEvent.emit();
  }

  constructor() { }

  ngOnInit(): void {
  }
}
