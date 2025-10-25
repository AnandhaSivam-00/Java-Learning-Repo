import { Component, OnInit } from '@angular/core';
import {CounterService} from "../../services/counter.service";

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  seconds: number = 0;
  milliseconds: number = 0;

  constructor(private countService : CounterService) { }

  /**
   * TODO: within the ngOnInit, you should subscribe to the countService.getCounterMilliseconds, using the observable
   * to set the 'milliseconds' field of this component. This should look very similar to the provided subscription.
   */
  ngOnInit(): void {
    this.countService.getCounterSeconds().subscribe(updatedValue => this.seconds = updatedValue);
    this.countService.getCounterMilliseconds().subscribe(updatedValue => this.milliseconds = updatedValue);
  }

}
