package com.example.mynotepad.app;

import java.io.Serializable;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class Note implements Serializable {
    private String mSubject;
    private String mContent;

    public Note(String subject, String content) {
        this.mSubject = subject;
        this.mContent = content;
    }

    public String getSubject() { return mSubject; }

    public void setSubject(String Subject) {
        this.mSubject = Subject;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        this.mContent = content;
    }
}
