package com.ozibolme.dikilim.Fragments;

import android.app.Dialog;

import android.graphics.Bitmap;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdView;

import com.ozibolme.dikilim.Activities.FragmentActivity;
import com.ozibolme.dikilim.HelpFunctions;
import com.ozibolme.dikilim.R;

public class PharmacyFragment extends Fragment implements FragmentActivity.IOnBackPressed {

    private WebView webView;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pharmacy,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView=view.findViewById(R.id.web_view_pharmacy);

        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_load);
        dialog.show();

        webView.setWebViewClient(new Bulurum());
        webView.loadUrl("https://www.bulurum.com/nobetci-eczane/dikili/");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        AdView adView;
        adView=view.findViewById(R.id.adView_pharmacy);
        HelpFunctions.addBannerAdvert(adView);
    }

    @Override
    public boolean onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            return false;
        }
    }

    public class Bulurum extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            dialog.dismiss();
        }
    }
}
