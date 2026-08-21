package com.trilautanemas.tleschedule;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends Activity {

    private static final String WEB_URL =
            "https://script.google.com/macros/s/AKfycbxzlIS5-PrPukc5DuIVRPoBtg0nT9rDfjF-27E50IC5qfveW6skVZ9eAUgZ0VS9ReA8/exec";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openTleSchedule();
    }

    private void openTleSchedule() {
        Uri uri = Uri.parse(WEB_URL);

        CustomTabColorSchemeParams colors = new CustomTabColorSchemeParams.Builder()
                .setToolbarColor(Color.rgb(7, 52, 95))
                .setNavigationBarColor(Color.rgb(7, 52, 95))
                .build();

        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setDefaultColorSchemeParams(colors)
                .build();

        try {
            customTabsIntent.launchUrl(this, uri);
        } catch (ActivityNotFoundException ex) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(browserIntent);
        }

        finish();
    }
}
