package com.ozibolme.dikilim.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.view.Window;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout[] buttons_top;
    private ImageView[] buttons_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons_top=new LinearLayout[8];
        buttons_bottom=new ImageView[3];

        createButtons();
    }

    private void createButtons(){
        for (int i=0;i<buttons_top.length;i++){
            String button_id="button_top_home_"+(i+1);
            int res_id=getResources().getIdentifier(button_id,"id",getPackageName());
            buttons_top[i]=findViewById(res_id);
            buttons_top[i].setOnClickListener(this);
        }

        for (int i=0;i<buttons_bottom.length;i++){
            String button_id="button_bottom_home_"+(i+1);
            int res_id=getResources().getIdentifier(button_id,"id",getPackageName());
            buttons_bottom[i]=findViewById(res_id);
            buttons_bottom[i].setOnClickListener(this);
        }
    }

    private void whichButton(int buttonNumber){
        Intent i=new Intent(MainActivity.this,FragmentActivity.class);
        i.putExtra("buttonNumber",buttonNumber);
        startActivity(i);
    }

    private void busButton(){
        whichButton(1);
    }

    private void pharmacyButton(){
        whichButton(2);
    }

    private void teacherButton(){
        whichButton(3);
    }

    private void plumberButton(){
        whichButton(4);
    }

    private void newButton(){
        whichButton(5);
    }

    private void taxiButton(){
        whichButton(6);
    }

    private void placeButton(){
        whichButton(7);
    }

    private void cafeButton(){
        whichButton(8);
    }

    private void helpButton(){
        whichButton(9);
    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_exit);

        Button button_yes=dialog.findViewById(R.id.button_exit_yes);
        Button button_no = dialog.findViewById(R.id.button_exit_no);

        button_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
                finish();
            }
        });
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_top_home_1:
                busButton();
                break;
            case R.id.button_top_home_2:
                pharmacyButton();
                break;
            case R.id.button_top_home_3:
                teacherButton();
                break;
            case R.id.button_top_home_4:
                plumberButton();
                break;
            case R.id.button_top_home_5:
                newButton();
                break;
            case R.id.button_top_home_6:
                taxiButton();
                break;
            case R.id.button_top_home_7:
                placeButton();
                break;
            case R.id.button_top_home_8:
                cafeButton();
                break;
            case R.id.button_bottom_home_1:
                helpButton();
                break;
            case R.id.button_bottom_home_2:
                // Zaten ana menüdesin.
                break;
            case R.id.button_bottom_home_3:
                HelpFunctions.shareButton(this);
                break;
            default:
                // Bunun olması imkansız.
                break;
        }
    }
}
