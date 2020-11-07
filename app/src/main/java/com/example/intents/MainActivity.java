package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.File;

public class MainActivity extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {
    ChipNavigationBar nav;
    FragmentManager fg;
    private Uri mImageCaptureUri;
    private ImageView mImageView;
    private boolean isTakenFromCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.bottom_nav);
        nav.setOnItemSelectedListener(this);


    }



    @Override
    public void onItemSelected(int i) {
        Fragment ff = null;

        switch (i) {

            case R.id.SMS:
                ff = new SMSFragment();
                break;
            case R.id.E_mail:
                ff = new EmailFragment();
                break;

            case R.id.Map:
                ff = new MapFragment();
                break;

            case R.id.pic:
                ff = new CameraFragment();
                break;

        }
        if (ff != null) {
            fg = getSupportFragmentManager();
            fg.beginTransaction()
                    .replace(R.id.frag_contaner, ff)
                    .commit();
        } else {
            System.out.println("Error in creating the fregment");


        }


    }
}


