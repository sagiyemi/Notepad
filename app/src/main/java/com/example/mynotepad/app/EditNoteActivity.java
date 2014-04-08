package com.example.mynotepad.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditNoteActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText editSubject;
    private EditText editContent;
    private int noteIndex;
    private boolean isNewNote = false;
    private Button saveButton;
    private Button cancelButton;
    private NotepadApplication notepadApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editSubject = (EditText) findViewById(R.id.editSubject);
        editContent = (EditText) findViewById(R.id.editContent);
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        notepadApplication = (NotepadApplication) getApplication();
        noteIndex = getIntent().getExtras().getInt("index");

        if (noteIndex == NotepadApplication.NEWNOTE) {
            isNewNote = true;
        } else {
            Note note = notepadApplication.getNotesList().get(noteIndex);
            editSubject.setText(note.getSubject());
            editContent.setText(note.getContent());
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:
                if (isNewNote) {
                    notepadApplication.addNewNote(editSubject.getText().toString(), editContent.getText().toString());
                } else {
                    notepadApplication.updateNote(noteIndex, editSubject.getText().toString(), editContent.getText().toString());
                }
                break;
            case R.id.cancelButton:
                // do nothing, simply go back
                break;
            default:
                break;
        }
        finish();
    }
}
