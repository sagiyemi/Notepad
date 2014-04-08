package com.example.mynotepad.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditNoteActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText editSubject;
    private EditText editContent;
    private Note note;
    public static final String ISNEWNOTE = "isNew";
    public static final String NOTE = "note";
    public static final String WASSAVED = "saved";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editSubject = (EditText) findViewById(R.id.editSubject);
        editContent = (EditText) findViewById(R.id.editContent);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        if (!getIntent().getExtras().getBoolean(ISNEWNOTE)) {
            note = (Note) getIntent().getExtras().getSerializable(NOTE);
            editSubject.setText(note.getSubject());
            editContent.setText(note.getContent());
        }

    }


    @Override
    public void onClick(View view) {
        Intent returnIntent = new Intent();
        switch (view.getId()) {
            case R.id.saveButton:
                if (getIntent().getExtras().getBoolean(ISNEWNOTE)) {
                    note = new Note(editSubject.getText().toString(), editContent.getText().toString());
                } else {
                    note.setSubject(editSubject.getText().toString());
                    note.setContent(editContent.getText().toString());
                }
                returnIntent.putExtra(WASSAVED, true);
                returnIntent.putExtra(NOTE, note);
                break;
            case R.id.cancelButton:
                returnIntent.putExtra(WASSAVED, false);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
