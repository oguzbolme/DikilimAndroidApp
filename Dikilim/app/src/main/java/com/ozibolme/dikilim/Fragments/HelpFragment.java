package com.ozibolme.dikilim.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ozibolme.dikilim.R;

public class HelpFragment extends Fragment implements View.OnClickListener {

    private Button[] buttons_top;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttons_top=new Button[3];
        for (int i=0;i<buttons_top.length;i++){
            String button_id="button_top_help_"+(i+1);
            int res_id=getResources().getIdentifier(button_id,"id",getActivity().getPackageName());
            buttons_top[i]=view.findViewById(res_id);
            buttons_top[i].setOnClickListener(this);
        }
    }

    private void whichFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_help,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_top_help_1:
                InformationFragment informationFragment =new InformationFragment();
                whichFragment(informationFragment);
                break;
            case R.id.button_top_help_2:
                ContactFragment contactFragment=new ContactFragment();
                whichFragment(contactFragment);
                break;
            case R.id.button_top_help_3:
                CreditFragment creditFragment=new CreditFragment();
                whichFragment(creditFragment);
                break;
        }
    }

    public static class InformationFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_information,container,false);
        }
    }

    public static class ContactFragment extends Fragment{

        ImageView imageView_instagram,imageView_linkedin;

        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_contact,container,false);
        }

        @Override
        public void onViewCreated(View view,Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            imageView_instagram=view.findViewById(R.id.image_view_instagram);
            imageView_linkedin=view.findViewById(R.id.image_view_linkedin);

            imageView_instagram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("http://instagram.com/_u/ozibuo");
                    Intent instaIntent = new Intent(Intent.ACTION_VIEW, uri);

                    instaIntent.setPackage("com.instagram.android");

                    try {
                        startActivity(instaIntent);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/_u/ozibuo")));
                    }
                }
            });

            imageView_linkedin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri=Uri.parse("https://www.linkedin.com/in/o%C4%9Fuzhan-b%C3%B6lme-842404194/");
                    Intent linkedinIntent=new Intent(Intent.ACTION_VIEW,uri);

                    linkedinIntent.setPackage("com.linkedin.android");

                    try {
                        startActivity(linkedinIntent);
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com/in/o%C4%9Fuzhan-b%C3%B6lme-22b91318a/")));
                    }
                }
            });
        }
    }

    public static class CreditFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_credit,container,false);
        }
    }
}
