package com.ozibolme.dikilim;

import android.content.Context;
import android.content.Intent;

import android.graphics.Color;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class HelpFunctions {

    public static SpannableString textviewColor1(String s1, String s2){
        SpannableString ss=new SpannableString(s1+s2);

        ForegroundColorSpan fcsBlack=new ForegroundColorSpan(Color.BLACK);

        ss.setSpan(fcsBlack,ss.length()-(s2.length()+1),ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ss;
    }

    public static SpannableString textviewColor2(String s1, String s2, String s3){
        SpannableString ss=new SpannableString(s1+s2+" "+s3);

        ForegroundColorSpan fcsBlack=new ForegroundColorSpan(Color.BLACK);

        ss.setSpan(fcsBlack,ss.length()-(s2.length()+s3.length()+1),ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ss;
    }

    public static void shareButton(Context context){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.ozibolme.dikilim");
        shareIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(shareIntent,"Uygulamayı Paylaş"));
    }

    // gerçek id ca-app-pub-5280061664335476/8900828853
    public static void addBannerAdvert(AdView adView){
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    // gerçek id ca-app-pub-5280061664335476/7751398711
    public static void addInterAdvert(final InterstitialAd interstitialAd){
        /*
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        });

         */
    }
}
