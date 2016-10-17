package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by nicolaslacaze on 14/10/2016.
 */

public class PetCursorAdapter extends CursorAdapter {
    /**
     * Constructs a new {@link PetCursorAdapter}.
     *
     * @param context The context
     * @param cursor       The cursor from which to get the data.
     */
    public PetCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView summaryView = (TextView) view.findViewById(R.id.summary);

        //Get the data from two specific columns of our cursor.
        String name = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME));
        String breed = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED));

        //Check if breed was found in the database. If not display a default message on UI.
        if (breed.isEmpty()) {
            breed = "Unknown breed";
        }

        //Set the retrieved data into our empty layout_item .
        nameView.setText(name);
        summaryView.setText(breed);
    }
}
