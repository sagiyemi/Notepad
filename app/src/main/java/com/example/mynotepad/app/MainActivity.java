package com.example.mynotepad.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private ArrayList<Note> notesList;
    private final int EXISTINGNOTE = 1;
    private final int NEWNOTE = 2;
    private NoteAdapter adapter;
    private Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);

        notesList = new ArrayList<Note>();
        initArrayWithSomething();

        ListView notesListView = getListView();
        notesListView.setOnItemClickListener(this);

        Button addNewNoteButton = (Button) findViewById(R.id.addNewNoteButton);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
                intent.putExtra(EditNoteActivity.ISNEWNOTE, true);
                startActivityForResult(intent, NEWNOTE);
            }
        });
        adapter = new NoteAdapter(this, R.layout.title_row, notesList);
        setListAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        intent.putExtra(EditNoteActivity.ISNEWNOTE, false);
        currentNote = notesList.get(i);
        intent.putExtra(EditNoteActivity.NOTE, currentNote);
        startActivityForResult(intent, EXISTINGNOTE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && (data.getExtras().getBoolean(EditNoteActivity.WASSAVED))) {
            if (requestCode == EXISTINGNOTE) {
                Note returnedNote = (Note)data.getExtras().getSerializable(EditNoteActivity.NOTE);
                currentNote.setSubject(returnedNote.getSubject());
                currentNote.setContent(returnedNote.getContent());
            } else if (requestCode == NEWNOTE) {
                notesList.add((Note)data.getExtras().getSerializable(EditNoteActivity.NOTE));
            }
        adapter.notifyDataSetChanged();
        }
    }

    private void initArrayWithSomething() {
        notesList.add(new Note("first Title", "first Content"));
        notesList.add(new Note("second Title", "second Content"));
        notesList.add(new Note("third Title", "third Content"));
    }

}
