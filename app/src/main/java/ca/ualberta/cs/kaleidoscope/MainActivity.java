package ca.ualberta.cs.kaleidoscope;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.majorkernelpanic.streaming.Session;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Session.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        populateStreamList();
    }

    /*
        Method that populates the the list of streams
        TODO: Right now the stream list is hard coded
     */
    private void populateStreamList() {
        // Construct the data source
        ArrayList<Stream> arrayOfStreams = Stream.getStreams();
        // Create the adapter to convert the array to views
        StreamAdapter adapter = new StreamAdapter(this, arrayOfStreams);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvStreams);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    final View view, int position, long id) {
                Stream item = (Stream) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, StreamActivity.class);
                startActivity(intent);

                Log.d("ListView", "Selected item : " + item);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options_settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSessionStarted() {

    }

    @Override
    public void onSessionConfigured() {

    }

    @Override
    public void onSessionStopped() {

    }

    @Override
    public void onSessionError(int message, int streamType, Exception e) {

    }

    @Override
    public void onBitrateUpdate(long bitrate) {

    }

    @Override
    public void onPreviewStarted() {

    }

}
