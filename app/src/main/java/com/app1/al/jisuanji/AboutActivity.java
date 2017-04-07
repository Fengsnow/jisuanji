package com.app1.al.jisuanji;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.app1.al.jisuanji.R.layout.activity_about;

public class AboutActivity extends AppCompatActivity {


   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_about);

       PackageManager manager = getPackageManager();
       PackageInfo info = null;

       try {
           info = manager.getPackageInfo(getPackageName(), 0);
       } catch (PackageManager.NameNotFoundException e) {
           e.printStackTrace();
       }

       String version = info == null ? getString(R.string.unknown): info.versionName;
       String msg = String.format(getString(R.string.verion_info), version);

       TextView ver = (TextView) findViewById(R.id.version_info);
       ver.setText(msg);
   }


}
