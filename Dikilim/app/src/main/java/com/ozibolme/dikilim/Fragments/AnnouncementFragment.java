package com.ozibolme.dikilim.Fragments;

import android.app.Dialog;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.ozibolme.dikilim.Adapters.AnnouncementAdapter;
import com.ozibolme.dikilim.Classes.Announcement;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementFragment extends Fragment {

    private RecyclerView recyclerView;
    private Dialog dialog;

    private AnnouncementAdapter adapter;
    private ArrayList<Announcement> announcements;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_firebase_classes,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =view.findViewById(R.id.recycler_view);

        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_load);
        dialog.show();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        announcements = new ArrayList<>();

        AdView adView;
        adView=view.findViewById(R.id.adView_firebase_classes);
        HelpFunctions.addBannerAdvert(adView);

        getFirebaseData();
    }

    private void getFirebaseData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("announcements");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                announcements.clear();

                List<String> keys = new ArrayList<>();
                for (DataSnapshot key:dataSnapshot.getChildren()) {
                    keys.add(key.getKey());
                    Announcement announcement=key.getValue(Announcement.class);

                    announcements.add(announcement);
                }

                adapter = new AnnouncementAdapter(getContext(), announcements);
                recyclerView.setAdapter(adapter);

                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
