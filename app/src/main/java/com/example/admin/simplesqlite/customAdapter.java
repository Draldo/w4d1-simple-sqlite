package com.example.admin.simplesqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by admin on 8/9/2016.
 */
public class CustomAdapter extends CursorAdapter {

    public CustomAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.textview_item);

        String name = cursor.getString(cursor.getColumnIndex(StudentsHelper.KEY_USER_NAME));
        String age = cursor.getString(cursor.getColumnIndex(StudentsHelper.KEY_AGE));

        textView.setText("Name: " + name + " Age: " + age);
    }
}
