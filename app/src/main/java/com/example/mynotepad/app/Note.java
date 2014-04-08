package com.example.mynotepad.app;

import java.io.Serializable;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class Note implements Serializable{
    private String subject;
    private String content;

    public Note(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
