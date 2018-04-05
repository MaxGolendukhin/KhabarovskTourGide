package com.golendukhin.khabarovsktourgide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.image_view) ImageView imageView;
    @BindView(R.id.title_text_view) TextView titleTextView;
    @BindView(R.id.description_text_view) TextView descriptionTextView;
    @BindView(R.id.address_text_view) TextView addressTextView;
    @BindView(R.id.site_linear_layout) LinearLayout siteLinearLayout;
    @BindView(R.id.site_text_view) TextView siteTextView;
    @BindView(R.id.phone_linear_layout) LinearLayout phoneLinearLayout;
    @BindView(R.id.phone_text_view) TextView phoneTextView;

    /**
     * Populates detailsActivity with data for particular sight
     * If there is no site or phone, respective views are gone
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_linear_layout);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        Sight sight = (Sight) bundle.getSerializable("sight");

        imageView.setImageResource(sight.getImageResourceId());
        titleTextView.setText(sight.getName());
        descriptionTextView.setText(sight.getDescription());
        addressTextView.setText(sight.getAddress());

        if (!sight.getSite().equals("empty")) {
            siteTextView.setText(sight.getSite());
        } else {
            siteLinearLayout.setVisibility(View.GONE);
        }

        if (!sight.getPhone().equals("empty")) {
            phoneTextView.setText(sight.getPhone());
        } else {
            phoneLinearLayout.setVisibility(View.GONE);
        }
    }
}