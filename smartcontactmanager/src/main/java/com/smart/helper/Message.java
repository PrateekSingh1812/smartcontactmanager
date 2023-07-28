package com.smart.helper;

public class Message {

    private String content;

    private String type;

    public Message(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public Message() {
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getType() {
        return type;
    }

    public Message setType(String type) {
        this.type = type;
        return this;
    }
}
