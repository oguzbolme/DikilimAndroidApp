package com.ozibolme.dikilim.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import com.ozibolme.dikilim.R;

import com.squareup.picasso.Picasso;

public class BusDetailActivity extends AppCompatActivity {

    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_detail);

        photoView=findViewById(R.id.image_view_bus);

        Intent i=getIntent();
        String imageUrl=i.getStringExtra("imageUrl");

        Picasso.get().load(imageUrl).fit().centerCrop().into(photoView);

        PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(photoView);
        photoViewAttacher.update();
    }
}
