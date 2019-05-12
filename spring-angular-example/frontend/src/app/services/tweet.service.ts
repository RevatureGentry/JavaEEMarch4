import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tweet } from '../model/tweets.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TweetService {

  constructor(private http: HttpClient) { }

  getAllTweets(): Observable<Tweet[]> {
    return this.http.get<Tweet[]>(environment.api.tweets);
  }

  createTweet(tweet: Tweet): Observable<any> {
    return this.http.post<any>(environment.api.tweets, tweet);
  }
}
