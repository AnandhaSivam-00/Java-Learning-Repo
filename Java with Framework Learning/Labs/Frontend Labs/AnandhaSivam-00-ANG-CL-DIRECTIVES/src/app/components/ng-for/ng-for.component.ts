import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ng-for',
  templateUrl: './ng-for.component.html',
  styleUrls: ['./ng-for.component.css']
})
export class NgForComponent implements OnInit {
  numbers: Number[] = [1, 2, 3, 4, 5];
  names: String[] = ['Hank', 'Bobby', 'Peggy', 'Luanne', 'Dale', 'Bill', 'Boomhauer']

  constructor() { }

  ngOnInit(): void {
  }

}
