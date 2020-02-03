package com.ozibolme.dikilim.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ozibolme.dikilim.Classes.Announcement;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<Announcement> announcements;

    public AnnouncementAdapter(Context context, ArrayList<Announcement> announcements){
        this.context=context;
        this.announcements=announcements;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_announcement,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Announcement announcement=announcements.get(position);

        String date=announcement.getDate();
        String advert=announcement.getAdvert();
        String contact=announcement.getContact();

        holder.textView_date.setText(date);
        holder.textView_advert.setText(advert);
        holder.textview_announcement_contact.setText(contact);
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_date,textView_advert,textview_announcement_contact;

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_date=itemView.findViewById(R.id.textview_announcement_date);
            textView_advert=itemView.findViewById(R.id.textview_announcement_advert);
            textview_announcement_contact=itemView.findViewById(R.id.textview_announcement_contact);
        }
    }

}
