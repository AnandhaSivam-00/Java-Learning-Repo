import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  num: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  doIncrement() {
    this.num++;
  }
  /**
   * In the HTML template, this method should be bound to a decrementEvent, which will be a custom event emitted by the
   * button-menu component.
   */
  doDecrement() {
    this.num--;
  }
}
