package com.ozibolme.dikilim.Adapters;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private String[] imageUrls;

    public ViewPagerAdapter(Context context, String[] imageUrls){
        this.context=context;
        this.imageUrls=imageUrls;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        Picasso.get().load(imageUrls[position]).fit().centerCrop().into(imageView);

        container.addView(imageView);

        return imageView;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view==object;
    }
}
