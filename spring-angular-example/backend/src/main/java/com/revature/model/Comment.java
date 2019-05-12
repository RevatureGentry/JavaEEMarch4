package com.revature.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.model.json.CommentSerializer;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author William Gentry
 */
@Entity
@Table(name = "tweet_comment")
@JsonSerialize(using = CommentSerializer.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;

    private long timestamp;

    @ManyToOne
    @JoinColumn(name = "tweetId")
    private Tweet tweet;

    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                timestamp == comment.timestamp &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, timestamp);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Comment.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("content='" + content + "'")
                .add("timestamp=" + timestamp)
                .toString();
    }
}
