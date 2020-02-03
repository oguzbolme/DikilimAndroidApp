package com.ozibolme.dikilim.Adapters;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ozibolme.dikilim.Classes.Teacher;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Teacher> teachers;

    public TeacherAdapter(Context context,ArrayList<Teacher> teachers){
        this.context=context;
        this.teachers=teachers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_teacher,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Teacher teacher=teachers.get(position);

        String name=teacher.getName();
        String surname=teacher.getSurname();
        String lessonName=teacher.getLessonName();
        String lessonDescription=teacher.getLessonDescription();
        String teacherInfos=teacher.getTeacherInfos();
        String fee=teacher.getFee();
        String imageUrl=teacher.getImageUrl();


        holder.textView_lesson_name.setText(lessonName);
        holder.textView_lesson_description.setText(HelpFunctions.textviewColor1("Ders İçeriği ve Açıklaması: ",lessonDescription));
        holder.textView_name_surname.setText(HelpFunctions.textviewColor2("Öğretmen Adı ve Soyadı: ",name,surname));
        holder.textView_teacher_infos.setText(HelpFunctions.textviewColor1("Öğretmen Bilgileri: ",teacherInfos));
        holder.textView_fee.setText(HelpFunctions.textviewColor1("Ders Ücreti: ",fee));

        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageView_photo);
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name_surname,textView_lesson_name,textView_lesson_description,textView_teacher_infos,textView_fee;
        private ImageView imageView_photo,imageView_call;

        private void callTeacher(){
            Teacher clickedTeacher=teachers.get(getAdapterPosition());
            String telNumber=clickedTeacher.getTelNumber();

            Intent callIntent=new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+telNumber));
            context.startActivity(callIntent);
        }

        public ViewHolder(final View itemView) {
            super(itemView);

            textView_name_surname=itemView.findViewById(R.id.textview_teacher_name_surname);
            textView_lesson_name=itemView.findViewById(R.id.textview_lesson_name);
            textView_lesson_description=itemView.findViewById(R.id.textview_lesson_description);
            textView_teacher_infos=itemView.findViewById(R.id.textview_teacher_infos);
            textView_fee=itemView.findViewById(R.id.textview_teacher_fee);

            imageView_photo=itemView.findViewById(R.id.image_view_teacher_photo);
            imageView_call=itemView.findViewById(R.id.image_view_call_teacher);

            imageView_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callTeacher();
                }
            });
        }
    }

}
