package rocks.ecox.GreaterPewee.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rocks.ecox.GreaterPewee.R;
import rocks.ecox.GreaterPewee.fragments.TweetsListFragment;

public class TimelineActivity extends AppCompatActivity {

    private TweetsListFragment fragmentTweetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

    }
}
