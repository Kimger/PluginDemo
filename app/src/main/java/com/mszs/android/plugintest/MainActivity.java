package com.mszs.android.plugintest;

import android.content.Intent;
import android.os.Bundle;

import com.mszs.android.plugin_lib.IPlugin;
import com.mszs.android.plugin_lib.PluginManager;
import com.mszs.android.plugin_lib.ProxyActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManager.getInstance().init(this);
        findViewById(R.id.btn_load).setOnClickListener(v -> {
            String apkPath = Helper.copyAssetAndWrite(MainActivity.this, "plugin_app.apk");
            PluginManager.getInstance().loadApk(apkPath);
        });

        findViewById(R.id.btn_to).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
            intent.putExtra("className", "com.mszs.android.plugin_app.PluginAppActivity");
            Bundle bundle = new Bundle();
            bundle.putInt("FROM", IPlugin.FROM_EXTERNAL);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        });
    }
}
