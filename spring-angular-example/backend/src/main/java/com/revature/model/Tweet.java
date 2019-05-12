package com.revature.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.model.json.TweetSerializer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author William Gentry
 */
@Entity
@Table(name = "tweets")
@JsonSerialize(using = TweetSerializer.class)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tweetId;

    private String content;

    private long timestamp;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    // mappedBy refers to the name of the Tweet field on the Comment object
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tweet")
    private List<Comment> comments;

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return tweetId == tweet.tweetId &&
                timestamp == tweet.timestamp &&
                Objects.equals(content, tweet.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tweetId, content, timestamp);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tweet.class.getSimpleName() + "[", "]")
                .add("tweetId=" + tweetId)
                .add("content='" + content + "'")
                .add("timestamp=" + timestamp)
                .toString();
    }
}
