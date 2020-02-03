package com.ozibolme.dikilim.Activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;

import com.google.android.gms.ads.InterstitialAd;

import com.ozibolme.dikilim.Fragments.BusFragment;
import com.ozibolme.dikilim.Fragments.CafeFragment;
import com.ozibolme.dikilim.Fragments.HelpFragment;
import com.ozibolme.dikilim.Fragments.NewAndAnnouncementFragment;
import com.ozibolme.dikilim.Fragments.PharmacyFragment;
import com.ozibolme.dikilim.Fragments.PlaceFragment;
import com.ozibolme.dikilim.Fragments.PlumberFragment;
import com.ozibolme.dikilim.Fragments.TaxiFragment;
import com.ozibolme.dikilim.Fragments.TeacherFragment;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView[] buttons_bottom;

    public interface IOnBackPressed {
        boolean onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        final InterstitialAd interstitialAd=new InterstitialAd(this);
        HelpFunctions.addInterAdvert(interstitialAd);

        buttons_bottom=new ImageView[3];
        createButtons();

        Intent i=getIntent();
        int which=i.getIntExtra("buttonNumber",0);

        goThisFragment(which);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    private void createButtons(){
        for (int i=0;i<buttons_bottom.length;i++){
            String button_id="button_bottom_fragment_"+(i+1);
            int res_id=getResources().getIdentifier(button_id,"id",getPackageName());
            buttons_bottom[i]=findViewById(res_id);
            buttons_bottom[i].setOnClickListener(this);
        }
    }

    public void whichFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    private void goThisFragment(int which){
        switch (which){
            case 1:
                BusFragment busFragment=new BusFragment();
                whichFragment(busFragment);
                break;
            case 2:
                PharmacyFragment pharmacyFragment=new PharmacyFragment();
                whichFragment(pharmacyFragment);
                break;
            case 3:
                TeacherFragment teacherFragment=new TeacherFragment();
                whichFragment(teacherFragment);
                break;
            case 4:
                PlumberFragment plumberFragment=new PlumberFragment();
                whichFragment(plumberFragment);
                break;
            case 5:
                NewAndAnnouncementFragment newAndAnnouncementFragment=new NewAndAnnouncementFragment();
                whichFragment(newAndAnnouncementFragment);
                break;
            case 6:
                TaxiFragment taxiFragment=new TaxiFragment();
                whichFragment(taxiFragment);
                break;
            case 7:
                PlaceFragment placeFragment=new PlaceFragment();
                whichFragment(placeFragment);
                break;
            case 8:
                CafeFragment cafeFragment=new CafeFragment();
                whichFragment(cafeFragment);
                break;
            case 9:
                HelpFragment helpFragment=new HelpFragment();
                whichFragment(helpFragment);
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_bottom_fragment_1:
                HelpFragment helpFragment=new HelpFragment();
                whichFragment(helpFragment);
                break;
            case R.id.button_bottom_fragment_2:
                onBackPressed();
                break;
            case R.id.button_bottom_fragment_3:
                HelpFunctions.shareButton(this);
                break;
            default:
                break;
        }
    }
}
