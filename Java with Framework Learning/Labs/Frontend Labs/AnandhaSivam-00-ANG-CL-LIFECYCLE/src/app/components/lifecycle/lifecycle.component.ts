import { Component, OnInit } from '@angular/core';
import {dateTimestampProvider} from "rxjs/internal/scheduler/dateTimestampProvider";

@Component({
  selector: 'app-lifecycle',
  templateUrl: './lifecycle.component.html',
  styleUrls: ['./lifecycle.component.css']
})
export class LifecycleComponent implements OnInit {
  time: any;

  constructor() { }

  /**
   * TODO: make this ngOnInit() lifecycle hook update this.time to the current time every time the component
   * is mounted
   * Here's a hint. get the current time with dateTimestampProvider.now(). This will be in milliseconds, but that's
   * good enough.
   */
  ngOnInit(): void {
    this.time = dateTimestampProvider.now();
  }

  /**
   * TODO: write a ngOnDestroy() lifecycle hook that creates an alert on the page every time the component is
   * unmounted
   * Here's a hint. You can cause an alert using the method alert("component destroyed!");
   */
  ngOnDestroy() {
    alert("component destroyed!");
  }

}
