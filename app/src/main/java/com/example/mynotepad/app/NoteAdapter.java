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

    private Context mContext;

    public NoteAdapter(Context context, int listItemId, ArrayList<Note> notesList) {
        super(context, listItemId, notesList);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        // TODO- http://www.piwai.info/android-adapter-good-practices/#ViewHolder-Pattern
        // TODO- http://www.piwai.info/android-adapter-good-practices/#Tag-with-id

        // If it's a new row, never been created so far
        if (view == null) {

            // Inflate the new row
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list_note, null);
        }

        Note note = getItem(position);

        TextView itemView = (TextView) view.findViewById(R.id.row_subject);
        itemView.setText(note.getSubject());

        return view;
    }
}
