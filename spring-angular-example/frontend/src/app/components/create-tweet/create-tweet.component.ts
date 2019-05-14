import { Component, OnInit } from '@angular/core';
import { TweetService } from 'src/app/services/tweet.service';
import { Tweet } from 'src/app/model/tweets.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-tweet',
  templateUrl: './create-tweet.component.html',
  styleUrls: ['./create-tweet.component.css']
})
export class CreateTweetComponent implements OnInit {

  tweet: Tweet = {
    content: ""
  }
  constructor(private tweetService: TweetService, private router: Router) { }

  ngOnInit() {
  }

  postTweet() {
    this.tweetService.createTweet(this.tweet).subscribe(
      success => {
        this.router.navigate(["/home"]);
      }
    )
  }
}
