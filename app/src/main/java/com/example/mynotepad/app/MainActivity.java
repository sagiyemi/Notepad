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
    private final int EXISTING_NOTE = 1;
    private final int NEW_NOTE = 2;

    private ArrayList<Note> mNotesList;
    private NoteAdapter mAdapter;
    private Note mCurrentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotesList = new ArrayList<Note>();
        initArrayWithSomething();

        ListView notesListView = getListView();
        notesListView.setOnItemClickListener(this);

        Button addNewNoteButton = (Button) findViewById(R.id.activity_main_plus);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
                intent.putExtra(EditNoteActivity.IS_NEW_NOTE, true);
                startActivityForResult(intent, NEW_NOTE);
            }
        });

        mAdapter = new NoteAdapter(this, R.layout.item_list_note, mNotesList);
        setListAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        intent.putExtra(EditNoteActivity.IS_NEW_NOTE, false);

        mCurrentNote = mNotesList.get(i);
        intent.putExtra(EditNoteActivity.NOTE, mCurrentNote);

        startActivityForResult(intent, EXISTING_NOTE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // Make sure the data was received ok
            if (data != null && data.getExtras() != null && data.getExtras().containsKey(EditNoteActivity.NOTE)) {

                // If we are coming back on an existing note
                switch (requestCode) {
                    case EXISTING_NOTE:
                        Note returnedNote = (Note) data.getExtras().getSerializable(EditNoteActivity.NOTE);
                        if (returnedNote != null) {
                            mCurrentNote.setSubject(returnedNote.getSubject());
                            mCurrentNote.setContent(returnedNote.getContent());
                            mAdapter.notifyDataSetChanged();
                        }
                        break;
                    case NEW_NOTE:
                        mAdapter.add((Note) data.getExtras().getSerializable(EditNoteActivity.NOTE));
                        break;
                }
            } else {
                throw new IllegalArgumentException("The activity didn't return the expected intent arguments, did you forget to 'setResult'?");
            }
        }
    }

    private void initArrayWithSomething() {
        mNotesList.add(new Note("first Title", "first Content"));
        mNotesList.add(new Note("second Title", "second Content"));
        mNotesList.add(new Note("third Title", "third Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("third Title", "third Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("third Title", "third Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
//        mNotesList.add(new Note("first Title", "first Content"));
//        mNotesList.add(new Note("second Title", "second Content"));
        mNotesList.add(new Note("first Title", "first Content"));
        mNotesList.add(new Note("second Title", "second Content"));
        mNotesList.add(new Note("third Title", "third Content"));
    }
}
