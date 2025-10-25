import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {
  posts : String[] = ["Sample post", "Did you hear about the new Angular update?", "plz debug my site"]
  constructor() { }

  ngOnInit(): void {
  }

}
