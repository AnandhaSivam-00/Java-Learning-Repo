import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CountService} from "../../services/count.service";

@Component({
  selector: 'app-decrementor',
  templateUrl: './decrementor.component.html',
  styleUrls: ['./decrementor.component.css']
})
export class DecrementorComponent implements OnInit {
  @Output()
  decrementEvent : EventEmitter<void> = new EventEmitter<void>();

  /**
   * TODO: the CountService should be injected into this component as is done in the incrementor component.
   */
  constructor(private countService : CountService) { }

  ngOnInit(): void {

  }

  /**
   * TODO: after writing a decrementNum() method in the CountService AND the CountService service has been injected
   * into this component, the service's decrementNum method should be called prior to emitting the decrementEvent,
   * just as has been done in the incrementor component.
   */
  emitDecrementEvent() {
    this.countService.decrementNum();
    this.decrementEvent.emit();
  }
}
