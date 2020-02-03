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
import com.ozibolme.dikilim.Adapters.PlumberAdapter;
import com.ozibolme.dikilim.Classes.Plumber;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

import java.util.ArrayList;
import java.util.List;

public class PlumberFragment extends Fragment {

    private RecyclerView recyclerView;
    private Dialog dialog;

    private PlumberAdapter adapter;
    private ArrayList<Plumber> plumbers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        plumbers = new ArrayList<>();

        AdView adView;
        adView=view.findViewById(R.id.adView_firebase_classes);
        HelpFunctions.addBannerAdvert(adView);

        getFirebaseData();
    }

    private void getFirebaseData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("plumbers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                plumbers.clear();

                List<String> keys = new ArrayList<>();
                for (DataSnapshot key:dataSnapshot.getChildren()) {
                    keys.add(key.getKey());
                    Plumber plumber=key.getValue(Plumber.class);

                    plumbers.add(plumber);
                }

                adapter = new PlumberAdapter(getContext(), plumbers);
                recyclerView.setAdapter(adapter);

                dialog.cancel();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
