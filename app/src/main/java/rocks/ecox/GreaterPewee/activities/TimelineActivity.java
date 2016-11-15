package rocks.ecox.GreaterPewee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import rocks.ecox.GreaterPewee.R;
import rocks.ecox.GreaterPewee.fragments.HomeTimelineFragment;
import rocks.ecox.GreaterPewee.fragments.MentionsTimelineFragment;
import rocks.ecox.GreaterPewee.fragments.TweetsListFragment;

public class TimelineActivity extends AppCompatActivity {

    private TweetsListFragment fragmentTweetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Get the ViewPager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        // Set the ViewPager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
        // Find the pager sliding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the pager tabstrip to the ViewPager
        tabStrip.setViewPager(vpPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void onProfileView(MenuItem mi) {
        // Launch the Profile view
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    // Return the order of the Fragments in the ViewPager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2; // Timeline and Mentions
        private String tabTitles[] = {"Home", "Mentions"};

        // Adapter gets the manager insert or remove Fragment from Activity
        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // The order and creation of Fragments within the pager
        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new HomeTimelineFragment();
            } else if(position == 1) {
                return new MentionsTimelineFragment();
            } else {
                return null;
            }
        }

        // Return the tab title
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        // How many Fragments there are to swipe between
        @Override
        public int getCount() {
             return tabTitles.length;
        }
    }
}
