package com.codepath.apps.GreaterPewee.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.codepath.apps.GreaterPewee.R;
import com.codepath.apps.GreaterPewee.adapters.TweetsArrayAdapter;
import com.codepath.apps.GreaterPewee.TwitterApplication;
import com.codepath.apps.GreaterPewee.TwitterClient;
import com.codepath.apps.GreaterPewee.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        // Find the ListView
        lvTweets = (ListView) findViewById(R.id.lvTweets);
        // Create the ArrayList (data source)
        tweets = new ArrayList<>();
        // Construct the adapter from the data source
        aTweets = new TweetsArrayAdapter(this, tweets);
        // Connect adapter to ListView
        lvTweets.setAdapter(aTweets);
        // Get the client
        client = TwitterApplication.getRestClient(); // singleton client
        // Populate timeline
        populateTimeline();
    }

    // Send an API request to get the timeline json
    // Fill the ListView by creating the tweet object from json
    public void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            // SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
                // JSON HERE
                // DESERIALIZE JSON
                // CREATE MODELS AND ADD THEM TO THE ADAPTER
                // LOAD THE MODEL DATA INTO THE LISTVIEW (needs an adapter)
                aTweets.addAll(Tweet.fromJSONArray(json));
            }

            // FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }
}
