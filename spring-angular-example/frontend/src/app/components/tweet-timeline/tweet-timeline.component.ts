import { Component, OnInit } from '@angular/core';
import { TweetService } from 'src/app/services/tweet.service';
import { Tweet } from 'src/app/model/tweets.model';
import { Comment } from 'src/app/model/comment.model';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-tweet-timeline',
  templateUrl: './tweet-timeline.component.html',
  styleUrls: ['./tweet-timeline.component.css']
})
export class TweetTimelineComponent implements OnInit {

  tweets: Tweet[] = [];
  comment: Comment = {
    content: '',
    tweetId: ''
  }
  constructor(private tweetService: TweetService, private commentService: CommentService) { }

  ngOnInit() {
    this.tweetService.getAllTweets().subscribe(
      success => this.tweets = success
    )
  }

  postComment() {
    console.log(this.comment);
  }
}
