package com.example.mynotepad.app;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class NotepadApplication extends Application{
    public static final int NEWNOTE = -1;
    private ArrayList<Note> notesList;

    @Override
    public void onCreate() {
        super.onCreate();
        notesList = new ArrayList<Note>();
        initArrayWithSomething();
    }

    public void updateNote(int index, String subject, String content) {
        Note note = notesList.get(index);
        note.setSubject(subject);
        note.setContent(content);
    }

    public void addNewNote(String subject, String content) {
        Note note = new Note(subject,content);
        notesList.add(note);
    }

    public ArrayList<Note> getNotesList() {
        return this.notesList;
    }

    private void initArrayWithSomething() {
        notesList.add(new Note("first Title", "first Content"));
        notesList.add(new Note("second Title", "second Content"));
        notesList.add(new Note("third Title", "third Content"));
    }
}
