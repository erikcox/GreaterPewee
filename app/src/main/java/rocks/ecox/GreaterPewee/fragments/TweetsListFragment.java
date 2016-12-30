package rocks.ecox.GreaterPewee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rocks.ecox.GreaterPewee.R;
import rocks.ecox.GreaterPewee.adapters.TweetsArrayAdapter;
import rocks.ecox.GreaterPewee.models.Tweet;

public class TweetsListFragment extends Fragment {
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    // Inflation logic
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, parent, false);
        // Find the ListView
        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        // Connect adapter to ListView
        lvTweets.setAdapter(aTweets);
        return v;
    }

    // Creation lifecycle event
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the ArrayList (data source)
        tweets = new ArrayList<>();
        // Construct the adapter from the data source
        aTweets = new TweetsArrayAdapter(getActivity(), tweets);
    }

    public void addAll(List<Tweet> tweets) {
        aTweets.addAll(tweets);
    }
}
