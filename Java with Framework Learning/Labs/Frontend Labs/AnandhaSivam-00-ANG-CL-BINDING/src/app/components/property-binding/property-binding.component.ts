import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  templateUrl: './property-binding.component.html',
  styleUrls: ['./property-binding.component.css']
})
export class PropertyBindingComponent implements OnInit {
  /**
   * This url is being bound to the
   */
  urlLink: String = "https://angular.io/";
  ngLogo: String = "https://angular.io/assets/images/logos/angular/logo-nav@2x.png";

  constructor() { }

  ngOnInit(): void {
  }

}
