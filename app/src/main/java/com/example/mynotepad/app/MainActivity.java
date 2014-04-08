package com.example.mynotepad.app;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    ArrayList<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);

        NotepadApplication notepadApplication = (NotepadApplication)getApplication();
        notesList = notepadApplication.notesList;

        NoteAdapter adapter = new NoteAdapter(this, R.layout.title_row,notesList);
        this.setListAdapter(adapter);

        ListView notesListView = getListView();
        notesListView.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String subject = notesList.get(i).getSubject();
        String content = notesList.get(i).getContent();
        Toast.makeText(this, String.format("Subject: %s, Content: %s", subject,content), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        intent.putExtra("index", i);
        startActivity(intent);

    }
}
