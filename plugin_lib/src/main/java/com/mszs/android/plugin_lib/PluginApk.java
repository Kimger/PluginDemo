package com.mszs.android.plugin_lib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * @author Kimger
 * @email kimgerxue@gmail.com
 * @date 2019/3/21 9:59
 * @description
 */
public class PluginApk {
    public PackageInfo mPackageInfo;
    public Resources mResources;
    public AssetManager mAssetManager;
    public DexClassLoader mDexClassLoader;

    public PluginApk(PackageInfo packageInfo, Resources resources, AssetManager assetManager,
                     DexClassLoader dexClassLoader) {
        mPackageInfo = packageInfo;
        mResources = resources;
        mAssetManager = assetManager;
        mDexClassLoader = dexClassLoader;
    }
}
