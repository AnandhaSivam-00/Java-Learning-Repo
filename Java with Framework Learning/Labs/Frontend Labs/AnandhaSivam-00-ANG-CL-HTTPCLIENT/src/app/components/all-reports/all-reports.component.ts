import { Component, OnInit } from '@angular/core';
import {Report} from "../../models/report";
import {SpaceApiService} from "../../services/space-api.service";

@Component({
  selector: 'app-all-reports',
  templateUrl: './all-reports.component.html',
  styleUrls: ['./all-reports.component.css']
})
export class AllReportsComponent implements OnInit {
  reports: Report[] = [];

  constructor(private spaceAPI : SpaceApiService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.spaceAPI.getReportsAPI().subscribe(json => this.reports = json);
  }

}
