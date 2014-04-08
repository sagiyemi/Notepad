package com.example.mynotepad.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ArrayList<Note> notesList;
    private Button addNewNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);

        NotepadApplication notepadApplication = (NotepadApplication) getApplication();
        notesList = notepadApplication.getNotesList();

        ListView notesListView = getListView();
        notesListView.setOnItemClickListener(this);

        addNewNoteButton = (Button) findViewById(R.id.addNewNoteButton);
        addNewNoteButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setListAdapter(new NoteAdapter(this, R.layout.title_row, notesList));
    }

    // click on one of the notes
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        intent.putExtra("index", i);
        startActivity(intent);
    }

    // click on add new note button
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        intent.putExtra("index", NotepadApplication.NEWNOTE);
        startActivity(intent);
    }
}
