package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        candyStoreImageView.setImageResource(R.drawable.store_front);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


        TextView txtPhone = (TextView)findViewById(R.id.text_view_phone);
        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callPhone = new Intent(Intent.ACTION_CALL,Uri.parse("tel:(012)345-6789"));
                startActivity(callPhone);
            }
        });
    }
    public void createMapIntent(View v){
        Intent launchMap = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"));
        launchMap.setPackage("com.google.android.apps.maps");

        if(launchMap.resolveActivity(getPackageManager()) !=null)
            startActivity(launchMap);

    }
}
