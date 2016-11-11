package com.codepath.apps.GreaterPewee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.GreaterPewee.R;
import com.codepath.apps.GreaterPewee.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

// Taking the Tweet objects and turning them into Views displayed in the list
public class TweetsArrayAdapter  extends ArrayAdapter<Tweet> {

    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
    }

    // Override and setup custom template
    // Implement ViewHolder pattern here

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the tweet
        Tweet tweet = getItem(position);
        // Find or inflate the template
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
        }
        // Find the subviews to fill with data in the template
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUserName= (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody= (TextView) convertView.findViewById(R.id.tvBody);
        // Populate data into the subviews
        ivProfileImage.setImageResource(android.R.color.transparent); // clear out the old image for a recycled view
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);

        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());
        // Return the View to be inserted into the list
        return convertView;
    }
}
