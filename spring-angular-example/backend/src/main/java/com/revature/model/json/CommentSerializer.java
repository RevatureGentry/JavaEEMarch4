package com.revature.model.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.revature.model.Comment;

import java.io.IOException;

/**
 * @author William Gentry
 */
public class CommentSerializer extends StdSerializer<Comment> {

    public CommentSerializer() {
        this(null);
    }

    public CommentSerializer(Class<Comment> t) {
        super(t);
    }

    @Override
    public void serialize(Comment value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("commentId", value.getId());
        gen.writeStringField("content", value.getContent());
        gen.writeNumberField("timestamp", value.getTimestamp());
        gen.writeStringField("username", value.getUsername());
        gen.writeEndObject();
    }
}
