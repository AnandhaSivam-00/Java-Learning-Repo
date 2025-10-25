import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html',
  styleUrls: ['./event-binding.component.css']
})
export class EventBindingComponent implements OnInit {
  /**
   * These two variables are bound to the component via property binding.
   */
  button1ClickedMessage: String = "button 1 not clicked";
  button2ClickedMessage: String = "button 2 not clicked";

  /**
   * This method has been written to handle the button 1 click. When button 1 is clicked, this method will change
   * the value of the button1ClickedMessage, which will be displayed on the page thanks to property binding.
   */
  processClickButton1() {
    this.button1ClickedMessage = "button 1 clicked!";
  }
  /**
   * TODO: write a method to handle the clicking of button 2 which changes the button2ClickedMessage.
   * The method should be bound to the click event of button 2 via event binding.
   */
  processClickButton2() {
    this.button2ClickedMessage = "button 2 clicked!";
  }




  constructor() { }

  ngOnInit(): void {
  }
}
