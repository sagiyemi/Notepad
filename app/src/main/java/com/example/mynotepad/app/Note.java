package com.example.mynotepad.app;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class Note {
    private String subject;
    private String content;

    public Note(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
