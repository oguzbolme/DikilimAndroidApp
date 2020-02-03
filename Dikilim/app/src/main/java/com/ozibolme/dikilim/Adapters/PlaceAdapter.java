package com.ozibolme.dikilim.Adapters;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.viewpager.widget.ViewPager;

import com.ozibolme.dikilim.Classes.Place;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Place> places;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;

    public PlaceAdapter(Context context,ArrayList<Place> places){
        this.context=context;
        this.places=places;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_place,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place=places.get(position);

        String placeName=place.getName();
        String description=place.getDescription();
        String imageUrl1=place.getImageUrl1();
        String imageUrl2=place.getImageUrl2();
        String imageUrl3=place.getImageUrl3();
        String imageUrl4=place.getImageUrl4();

        holder.textView_name.setText(placeName);
        holder.textView_description.setText(HelpFunctions.textviewColor1("Açıklama: ",description));

        String[] imageUrls=new String[]{imageUrl1,imageUrl2,imageUrl3,imageUrl4};

        ViewPagerAdapter adapter=new ViewPagerAdapter(context,imageUrls);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name,textView_description;
        private LinearLayout imageView_location;

        private void showLocation(){
            Place clickedPlace=places.get(getAdapterPosition());
            double latitude=Double.valueOf(clickedPlace.getLatitude()),longitude=Double.parseDouble(clickedPlace.getLongitude());
            String locationName=clickedPlace.getName();
            Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + locationName + ")"));
            context.startActivity(locationIntent);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_name=itemView.findViewById(R.id.textview_place_name);
            textView_description=itemView.findViewById(R.id.textview_place_description);

            viewPager=itemView.findViewById(R.id.image_view_place_photo);
            circleIndicator=itemView.findViewById(R.id.circle_indicator_place);
            imageView_location=itemView.findViewById(R.id.image_view_place_location);

            imageView_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLocation();
                }
            });
        }
    }

}
