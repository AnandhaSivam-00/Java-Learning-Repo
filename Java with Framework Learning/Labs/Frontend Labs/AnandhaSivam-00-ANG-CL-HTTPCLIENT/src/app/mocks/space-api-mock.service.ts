import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SpaceApiMockService {


  /**
   * return an observable which produces a response from a request to GET /v3/reports/{id} from the spaceflight api.
   */
  getReportsByIdAPI(id : number) : Observable<any>{
    return of ({"id":1,"title":"ISS Daily Summary Report – 11/29/2018","url":"https://blogs.nasa.gov/stationreport/2018/11/29/iss-daily-summary-report-11292018/","imageUrl":"https://upload.wikimedia.org/wikipedia/commons/8/8a/ISS_after_completion_%28as_of_June_2006%29.jpg","newsSite":"NASA","summary":"","publishedAt":"2018-11-29T16:00:29.000Z","updatedAt":"2021-05-18T13:54:49.144Z"})
  }
}
