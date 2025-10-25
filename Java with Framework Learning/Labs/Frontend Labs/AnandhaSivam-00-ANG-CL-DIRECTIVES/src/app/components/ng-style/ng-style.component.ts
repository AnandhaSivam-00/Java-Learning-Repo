import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-style',
  templateUrl: './ng-style.component.html',
  styleUrls: ['./ng-style.component.css']
})
export class NgStyleComponent implements OnInit {
  /**
   * The CSS styling for font size follows the format #px
   */
  fontSize : String = "5px";
  /**
   * actual, numeric value
   */
  fontSizeActual : number = 5;
  /**
   * every time the button is clicked, increase the font size by 1
   */
  increaseFontSize() {
    this.fontSizeActual = this.fontSizeActual+1;
    this.fontSize = this.fontSizeActual+"px";
    console.log(this.fontSize)
  }
  constructor() { }

  ngOnInit(): void {
  }


}
