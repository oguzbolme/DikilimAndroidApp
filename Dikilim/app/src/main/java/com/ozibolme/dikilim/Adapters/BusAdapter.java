package com.ozibolme.dikilim.Adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ozibolme.dikilim.Activities.BusDetailActivity;
import com.ozibolme.dikilim.Classes.Bus;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Bus> buses;

    public BusAdapter(Context context,ArrayList<Bus> buses){
        this.context=context;
        this.buses=buses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_bus,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bus bus=buses.get(position);

        String name=bus.getName();

        holder.textView_name.setText(name);
    }

    @Override
    public int getItemCount() {
        return buses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView textView_name;

        private void showImage(){
            Bus bus=buses.get(getAdapterPosition());
            String imageUrl=bus.getImageUrl();

            Intent i=new Intent(context, BusDetailActivity.class);
            i.putExtra("imageUrl",imageUrl);
            context.startActivity(i);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.linear_layout_bus);
            textView_name=itemView.findViewById(R.id.textview_bus_name);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showImage();
                }
            });
        }
    }
}
