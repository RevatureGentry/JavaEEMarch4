package com.revature.model.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.revature.model.Comment;
import com.revature.model.Tweet;

import java.io.IOException;

/**
 * @author William Gentry
 */
public class TweetSerializer extends StdSerializer<Tweet> {

    public TweetSerializer() {
        this(null);
    }

    public TweetSerializer(Class<Tweet> t) {
        super(t);
    }

    @Override
    public void serialize(Tweet value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("tweetId", value.getTweetId());
        gen.writeStringField("content", value.getContent());
        gen.writeNumberField("timestamp", value.getTimestamp());
        gen.writeStringField("username", value.getUser().getUsername());

        // Begin writing JSON Array of comments
        gen.writeArrayFieldStart("comments");
        for (Comment comment : value.getComments())
            gen.writeObject(comment);
        gen.writeEndArray();
        gen.writeEndObject();
    }
}
