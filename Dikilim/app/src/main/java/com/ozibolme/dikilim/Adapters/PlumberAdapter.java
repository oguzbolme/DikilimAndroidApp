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

import com.ozibolme.dikilim.Classes.Plumber;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlumberAdapter extends RecyclerView.Adapter<PlumberAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Plumber> plumbers;

    public PlumberAdapter(Context context,ArrayList<Plumber> plumbers){
        this.context=context;
        this.plumbers=plumbers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_plumber,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Plumber plumber=plumbers.get(position);

        String name=plumber.getName();
        String surname=plumber.getSurname();
        String shopName=plumber.getShopName();
        String description=plumber.getDescription();
        String fee=plumber.getFee();
        String workingHours=plumber.getWorkingHours();
        String imageUrl=plumber.getImageUrl();


        holder.textView_shop_name.setText(shopName);
        holder.textView_name_surname.setText(HelpFunctions.textviewColor2("Dükkan Sahibi: ",name,surname));
        holder.textView_description.setText(HelpFunctions.textviewColor1("İş Açıklaması: ",description));
        holder.textView_fee.setText(HelpFunctions.textviewColor1("İş Ücreti: ",fee));
        holder.textView_working_hours.setText(HelpFunctions.textviewColor1("Çalışma Saatleri: ",workingHours));

        Picasso.get().load(imageUrl).fit().centerCrop().into(holder.imageView_photo);
    }

    @Override
    public int getItemCount() {
        return plumbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name_surname,textView_shop_name,textView_description,textView_fee,textView_working_hours;
        private ImageView imageView_photo;
        private LinearLayout imageView_call,imageView_location;

        private void callPlumber(){
            Plumber clickedPlumber=plumbers.get(getAdapterPosition());
            String telNumber=clickedPlumber.getTelNumber();

            Intent callIntent=new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+telNumber));
            context.startActivity(callIntent);
        }

        private void showLocation(){
            Plumber clickedPlumber=plumbers.get(getAdapterPosition());
            double latitude=Double.valueOf(clickedPlumber.getLatitude()),longitude=Double.parseDouble(clickedPlumber.getLongitude());
            String locationName=clickedPlumber.getName();
            Intent locationIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + locationName + ")"));
            context.startActivity(locationIntent);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_name_surname=itemView.findViewById(R.id.textview_plumber_name_surname);
            textView_shop_name=itemView.findViewById(R.id.textview_plumber_shop_name);
            textView_description=itemView.findViewById(R.id.textview_plumber_description);
            textView_fee=itemView.findViewById(R.id.textview_plumber_fee);
            textView_working_hours=itemView.findViewById(R.id.textview_plumber_working_hours);

            imageView_photo=itemView.findViewById(R.id.image_view_plumber_photo);
            imageView_call=itemView.findViewById(R.id.image_view_call_plumber);
            imageView_location=itemView.findViewById(R.id.image_view_plumber_location);

            imageView_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callPlumber();
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
