package ca.ualberta.cs.kaleidoscope;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by timotei on 17-Mar-2016.
 */
public class StreamAdapter extends ArrayAdapter<Stream> {

    public StreamAdapter(Context context, ArrayList<Stream> streams) {
        super(context, 0, streams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Stream stream = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_stream, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvLocation);

        // Populate the data into the template view using the data object
        tvName.setText(stream.getName());
        tvHome.setText(stream.getLocation());
        // Return the completed view to render on screen
        return convertView;
    }
}
