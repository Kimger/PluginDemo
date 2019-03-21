package com.mszs.android.plugin_app;


import android.os.Bundle;

import com.mszs.android.plugin_lib.PluginActivity;

import androidx.appcompat.app.AppCompatActivity;

public class PluginAppActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
