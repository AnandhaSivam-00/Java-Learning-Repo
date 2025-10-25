import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CountService} from "../../services/count.service";

@Component({
  selector: 'app-incrementor',
  templateUrl: './incrementor.component.html',
  styleUrls: ['./incrementor.component.css']
})
export class IncrementorComponent implements OnInit {
  @Output()
  incrementEvent : EventEmitter<void> = new EventEmitter<void>();

  /**
   * The CountService has been injected into this component's Constructor, making the Service
   * singleton countService available throughout the component, as you can see in emitIncrementEvent().
   * @param countService
   */
  constructor(private countService : CountService) { }

  ngOnInit(): void {
  }

  emitIncrementEvent() {
    this.countService.incrementNum();
    this.incrementEvent.emit();
  }
}
