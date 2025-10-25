import { Component, OnInit } from '@angular/core';
import {CountService} from "../../services/count.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  num: number = 0;

  constructor(private countService : CountService) { }

  ngOnInit(): void {
  }
  updateNumFromService() : void{
    this.num = this.countService.getNum();
  }

}
