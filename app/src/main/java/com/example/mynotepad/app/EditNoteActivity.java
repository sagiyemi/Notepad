package com.example.mynotepad.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditNoteActivity extends ActionBarActivity {
    public static final String IS_NEW_NOTE = "isNew";
    public static final String NOTE = "note";

    private EditText mEditSubject;
    private EditText mEditContent;
    private Note mNote;
    private boolean mIsNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        mEditSubject = (EditText) findViewById(R.id.edit_subject);
        mEditContent = (EditText) findViewById(R.id.edit_content);
        Button saveButton = (Button) findViewById(R.id.save_button);
        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        saveButton.setOnClickListener(mOnSubmitClicked);
        cancelButton.setOnClickListener(mOnSubmitClicked);

        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey(IS_NEW_NOTE)) {
            mIsNewNote = getIntent().getExtras().getBoolean(IS_NEW_NOTE);
            if (!mIsNewNote) {
                if (getIntent().getExtras().containsKey(NOTE)) {
                    mNote = (Note) getIntent().getExtras().getSerializable(NOTE);
                    if (mNote != null) {
                        mEditSubject.setText(mNote.getSubject());
                        mEditContent.setText(mNote.getContent());
                    }
                }
            }
        }
    }


    View.OnClickListener mOnSubmitClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent returnIntent = new Intent();
            switch (view.getId()) {
                case R.id.save_button:
                    if (mEditContent.getText() != null && mEditSubject.getText() != null) {
                        if (mIsNewNote) {
                            mNote = new Note(mEditSubject.getText().toString(), mEditContent.getText().toString());
                        } else {
                            mNote.setSubject(mEditSubject.getText().toString());
                            mNote.setContent(mEditContent.getText().toString());
                        }
                    }

                    returnIntent.putExtra(NOTE, mNote);
                    setResult(RESULT_OK, returnIntent);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, returnIntent);
                    break;
                default:
                    break;
            }

            finish();
        }
    };
}
