import { Component, OnInit } from '@angular/core';
import {Report} from "../../models/report";
import {SpaceApiService} from "../../services/space-api.service";

@Component({
  selector: 'app-report-by-id',
  templateUrl: './report-by-id.component.html',
  styleUrls: ['./report-by-id.component.css']
})
export class ReportByIdComponent implements OnInit {
  input : number = 0;
  report: Report = {id:0, url:"", imageUrl: "", publishedAt: "", summary: "", title: ""};

  constructor(private spaceAPI : SpaceApiService) { }

  /**
   * TODO: Fill out the subscription to the Observable to load the report into this component.
   */
  loadReport () : void{
    this.spaceAPI.getReportsByIdAPI(this.input).subscribe(json => this.report = json);
  }


  ngOnInit(): void {

  }

}
