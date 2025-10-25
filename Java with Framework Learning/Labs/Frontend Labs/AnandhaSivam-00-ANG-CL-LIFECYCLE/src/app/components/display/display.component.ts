import { Component, OnInit } from '@angular/core';

/**
 * this component is only used to mount & unmount the lifecycle component, where you will be writing code
 * no need to change anything
 */
@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  mounted: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  swapMount() {
    this.mounted = !this.mounted;
  }
}
