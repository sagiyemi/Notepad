package com.example.mynotepad.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amit_gueta on 4/8/14.
 */
public class NoteAdapter extends ArrayAdapter<Note> {

    private Context context;

    public NoteAdapter(Context context, int textViewResourceId, ArrayList<Note> notesList) {
        super(context, textViewResourceId, notesList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.title_row, null);
        }
        Note note = getItem(position);
        if (note!=null) {
            TextView itemView = (TextView) view.findViewById(R.id.titleText);
            if (itemView != null) {
                itemView.setText(note.getSubject());
            }
        }
        return view;
    }
}
