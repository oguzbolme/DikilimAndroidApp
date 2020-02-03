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

import com.ozibolme.dikilim.Classes.Cafe;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Cafe> cafes;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;

    public CafeAdapter(Context context,ArrayList<Cafe> cafes){
        this.context=context;
        this.cafes=cafes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_cafe,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cafe cafe=cafes.get(position);

        String shopName=cafe.getName();
        String description=cafe.getDescription();
        String workingHours=cafe.getWorkingHours();
        String imageUrl1=cafe.getImageUrl1();
        String imageUrl2=cafe.getImageUrl2();
        String imageUrl3=cafe.getImageUrl3();
        String imageUrl4=cafe.getImageUrl4();

        holder.textView_name.setText(shopName);
        holder.textView_description.setText(HelpFunctions.textviewColor1("Açıklama: ",description));
        holder.textView_working_hours.setText(HelpFunctions.textviewColor1("Çalışma Saatleri: ",workingHours));

        String[] imageUrls=new String[]{imageUrl1,imageUrl2,imageUrl3,imageUrl4};

        ViewPagerAdapter adapter=new ViewPagerAdapter(context,imageUrls);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public int getItemCount() {
        return cafes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_name,textView_description,textView_working_hours;
        private LinearLayout imageView_location;

        private void showLocation(){
            Cafe clickedCafe=cafes.get(getAdapterPosition());
            double latitude=Double.valueOf(clickedCafe.getLatitude()),longitude=Double.parseDouble(clickedCafe.getLongitude());
            String locationName=clickedCafe.getName();
            Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + locationName + ")"));
            context.startActivity(locationIntent);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_name=itemView.findViewById(R.id.textview_cafe_name);
            textView_description=itemView.findViewById(R.id.textview_cafe_description);
            textView_working_hours=itemView.findViewById(R.id.textview_cafe_working_hours);

            viewPager=itemView.findViewById(R.id.image_view_cafe_photo);
            circleIndicator=itemView.findViewById(R.id.circle_indicator_cafe);
            imageView_location=itemView.findViewById(R.id.image_view_cafe_location);

            imageView_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLocation();
                }
            });
        }
    }

}
