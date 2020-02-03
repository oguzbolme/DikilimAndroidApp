package com.ozibolme.dikilim.Adapters;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ozibolme.dikilim.Classes.Taxi;
import com.ozibolme.dikilim.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TaxiAdapter extends RecyclerView.Adapter<TaxiAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Taxi> taxis;

    public TaxiAdapter(Context context,ArrayList<Taxi> taxis){
        this.context=context;
        this.taxis=taxis;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_taxi,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Taxi taxi=taxis.get(position);

        String shopName=taxi.getName();
        String imageUrl=taxi.getImageUrl();


        holder.textView_name.setText(shopName);

        Picasso.get().load(imageUrl).fit().centerCrop().into(holder.imageView_photo);
    }

    @Override
    public int getItemCount() {
        return taxis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name;
        private ImageView imageView_photo;
        private LinearLayout imageView_call,imageView_location;

        private void callTaxi(){
            Taxi clickedTaxi=taxis.get(getAdapterPosition());
            String telNumber=clickedTaxi.getTelNumber();

            Intent callIntent=new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+telNumber));
            context.startActivity(callIntent);
        }

        private void showLocation(){
            Taxi clickedTaxi=taxis.get(getAdapterPosition());
            double latitude=Double.valueOf(clickedTaxi.getLatitude()),longitude=Double.parseDouble(clickedTaxi.getLongitude());
            String locationName=clickedTaxi.getName();
            Intent locationIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + locationName + ")"));
            context.startActivity(locationIntent);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_name=itemView.findViewById(R.id.textview_taxi_shop_name);
            imageView_photo=itemView.findViewById(R.id.image_view_taxi_photo);
            imageView_call=itemView.findViewById(R.id.image_view_call_taxi);
            imageView_location=itemView.findViewById(R.id.image_view_taxi_location);

            imageView_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callTaxi();
                }
            });

            imageView_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLocation();
                }
            });
        }
    }

}
