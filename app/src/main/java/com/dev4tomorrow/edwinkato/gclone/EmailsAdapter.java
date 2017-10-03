package com.dev4tomorrow.edwinkato.gclone;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

/**
 * Created by edwinkato on 10/3/17.
 */

public class EmailsAdapter extends ArrayAdapter<Email> {
    public EmailsAdapter(Context context, ArrayList<Email> emails) {
        super(context, 0, emails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Email email = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView title = convertView.findViewById(R.id.title);
        TextView description = convertView.findViewById(R.id.description);
        TextView date = convertView.findViewById(R.id.date);
        ImageView image = convertView.findViewById(R.id.icon);
        // Populate the data into the template view using the data object
        title.setText(email.title);
        description.setText(email.description);
        date.setText(email.date);

        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(email.email);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(email.title.substring(0,1),color);


        image.setImageDrawable(drawable);

        // Return the completed view to render on screen
        return convertView;
    }
}