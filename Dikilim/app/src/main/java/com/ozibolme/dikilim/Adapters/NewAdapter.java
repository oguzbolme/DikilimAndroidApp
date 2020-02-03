package com.ozibolme.dikilim.Adapters;

import android.app.Dialog;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ozibolme.dikilim.Classes.New;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<New> news;

    public NewAdapter(Context context, ArrayList<New> news){
        this.context=context;
        this.news=news;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_new,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        New NEW=news.get(position);

        String date=NEW.getDate();
        String title=NEW.getTitle();

        holder.textView_date.setText(date);
        holder.textView_title.setText(title);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private TextView textView_date,textView_title;

        private void showNewDetails(){
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_dialog_new);

            TextView date = dialog.findViewById(R.id.textview_new_detail_date);
            TextView title = dialog.findViewById(R.id.textview_new_detail_title);
            TextView content = dialog.findViewById(R.id.textview_new_detail_content);
            TextView author = dialog.findViewById(R.id.textview_new_detail_author);
            Button button = dialog.findViewById(R.id.button_new_detail_back);

            date.setText(news.get(getAdapterPosition()).getDate());
            title.setText(news.get(getAdapterPosition()).getTitle());
            content.setText(news.get(getAdapterPosition()).getContent());
            author.setText(news.get(getAdapterPosition()).getAuthor());

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.linear_layout_new);
            textView_date=itemView.findViewById(R.id.textview_new_date);
            textView_title=itemView.findViewById(R.id.textview_new_title);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showNewDetails();
                }
            });
        }
    }

}
