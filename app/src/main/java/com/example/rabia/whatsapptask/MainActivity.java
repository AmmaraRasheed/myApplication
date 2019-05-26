package com.example.rabia.whatsapptask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rabia.whatsapptask.recycle.Main2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void whatsapp(View view)
    {
        Intent intent=getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(intent);
    }
    public void facebook(View view)
    {
        Intent intent=getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
        startActivity(intent);
    }
    public void recycle(View view)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
