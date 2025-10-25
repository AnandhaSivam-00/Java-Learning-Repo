import { Component, OnInit } from '@angular/core';
import {Article} from "../../models/article";
import {SpaceApiService} from "../../services/space-api.service";

@Component({
  selector: 'app-all-articles',
  templateUrl: './all-articles.component.html',
  styleUrls: ['./all-articles.component.css']
})
export class AllArticlesComponent implements OnInit {
  articles: Article[] = [];

  constructor(private spaceAPI : SpaceApiService) { }

  ngOnInit(): void {
    this.spaceAPI.getArticlesAPI().subscribe(json => this.articles = json);
  }

}
