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

    private boolean customTabOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            openTleSchedule();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*
         * Saat Activity pertama kali dibuka:
         * customTabOpened masih false.
         *
         * Setelah pengguna menutup Custom Tab,
         * Activity kembali ke onResume dan aplikasi ditutup
         * secara rapi.
         */
        if (customTabOpened) {
            finish();
        }
    }

    private void openTleSchedule() {

        Uri uri = Uri.parse(WEB_URL);

        int tleBlue = Color.rgb(7, 52, 95);

        CustomTabColorSchemeParams colors =
                new CustomTabColorSchemeParams.Builder()
                        .setToolbarColor(tleBlue)
                        .setNavigationBarColor(tleBlue)
                        .setSecondaryToolbarColor(tleBlue)
                        .build();

        CustomTabsIntent customTabsIntent =
                new CustomTabsIntent.Builder()

                        // Jangan tampilkan judul halaman.
                        .setShowTitle(false)

                        // Toolbar dapat menghilang ketika halaman di-scroll.
                        .setUrlBarHidingEnabled(true)

                        // Warna mengikuti identitas TLE.
                        .setDefaultColorSchemeParams(colors)

                        // Animasi lebih terasa seperti membuka aplikasi.
                        .setStartAnimations(
                                this,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )

                        .setExitAnimations(
                                this,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )

                        .build();

        try {

            customTabOpened = true;

            customTabsIntent.launchUrl(
                    this,
                    uri
            );

        } catch (ActivityNotFoundException ex) {

            customTabOpened = false;

            Intent browserIntent =
                    new Intent(
                            Intent.ACTION_VIEW,
                            uri
                    );

            startActivity(browserIntent);

            finish();
        }
    }
}
