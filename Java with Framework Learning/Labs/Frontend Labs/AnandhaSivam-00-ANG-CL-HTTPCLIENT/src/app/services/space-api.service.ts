import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SpaceApiService {

  constructor(private httpClient : HttpClient) { }

  /**
   * return an observable which produces a response from a request to GET /v3/articles from the spaceflight api.
   */
  getArticlesAPI() : Observable<any>{
    return this.httpClient.get("https://api.spaceflightnewsapi.net/v3/articles");
  }

  /**
   * TODO: return an observable which produces a response from a request to GET /v3/reports from the spaceflight api.
   * The full URL would be https://api.spaceflightnewsapi.net/v3/reports.
   */
  getReportsAPI() : Observable<any>{
    return this.httpClient.get("https://api.spaceflightnewsapi.net/v3/reports");
  }

  /**
   * return an observable which produces a response from a request to GET /v3/reports/{id} from the spaceflight api.
   */
  getReportsByIdAPI(id : number) : Observable<any>{
    return this.httpClient.get("https://api.spaceflightnewsapi.net/v3/reports/"+id)
  }
}
