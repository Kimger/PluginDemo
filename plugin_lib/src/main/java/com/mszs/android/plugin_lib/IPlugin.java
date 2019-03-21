package com.mszs.android.plugin_lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Kimger
 * @email kimgerxue@gmail.com
 * @date 2019/3/21 10:09
 * @description
 */
public interface IPlugin {

    int FROM_INTERNAL = 0;
    int FROM_EXTERNAL = 1;

    void onAttach(Activity activity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onActivityForResult(int requestCode, int resultCode, Intent data);

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
