package com.example.mynotepad.app;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class NotepadApplication extends Application{
    ArrayList<Note> notesList;

    @Override
    public void onCreate() {
        super.onCreate();
        notesList = new ArrayList<Note>();
        notesList.add(new Note("first Title", "first Content"));
        notesList.add(new Note("second Title", "second Content"));
        notesList.add(new Note("third Title", "third Content"));
    }
}
