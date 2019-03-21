package com.mszs.android.plugin_lib;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.IpPrefix;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @author Kimger
 * @email kimgerxue@gmail.com
 * @date 2019/3/21 10:20
 * @description
 */
public class ProxyActivity extends Activity {

    private String mClassName;
    private PluginApk mPluginApk;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassName = getIntent().getStringExtra("className");
        mPluginApk = PluginManager.getInstance().getPluginApk();
        luanchPluginActivity(savedInstanceState);
    }

    private void luanchPluginActivity(Bundle bundle) {
        if (mPluginApk == null) {
            throw new RuntimeException("插件APK不存在");
        }
        try {
            Class<?> clazz = mPluginApk.mDexClassLoader.loadClass(mClassName);
            Object object = clazz.newInstance();
            if (object instanceof IPlugin) {
                mIPlugin = (IPlugin) object;
                mIPlugin.onAttach(this);
                mIPlugin.onCreate(getIntent().getBundleExtra("bundle"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.mResources : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.mAssetManager : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.mDexClassLoader : super.getClassLoader();
    }

}
