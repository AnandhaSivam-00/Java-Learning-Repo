import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-if',
  templateUrl: './ng-if.component.html',
  styleUrls: ['./ng-if.component.css']
})
export class NgIfComponent implements OnInit {
  /**
   * This variable is bound to the HTML template.
   */
  displayed: Boolean = false;
  num: Number = 0;

  /**
   * When the button is clicked, swap 'displayed' between true/false.
   */
  switchDisplay() {
    this.displayed = !this.displayed;
  }
  constructor() { }

  ngOnInit(): void {
  }


}
