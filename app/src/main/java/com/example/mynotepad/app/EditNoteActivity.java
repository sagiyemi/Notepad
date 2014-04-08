package com.example.mynotepad.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class EditNoteActivity extends ActionBarActivity {
    EditText editSubject;
    EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        NotepadApplication notepadApplication = (NotepadApplication) getApplication();
        int i = getIntent().getExtras().getInt("index");
        Note note = notepadApplication.notesList.get(i);
        editSubject = (EditText) findViewById(R.id.editSubject);
        editContent = (EditText) findViewById(R.id.editContent);
        editSubject.setText(note.getSubject());
        editContent.setText(note.getContent());

        Toast.makeText(this, String.format("Subject: %s, Content: %s",note.getSubject(),note.getContent()), Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
