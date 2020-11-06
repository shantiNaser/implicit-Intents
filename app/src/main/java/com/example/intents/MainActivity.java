package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

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

public static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 123;
public static  Uri imageUri;


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                //use imageUri here to access the image

            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(this, "Picture was not taken", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(this, "Picture was not taken", Toast.LENGTH_LONG).show();

            }

        }

    }




    @Override
    public void onItemSelected(int i) {
        Fragment ff = null;

       switch (i){

           case R.id.SMS:
              // Intent i1 = new Intent(this,AccSMS.class);
              // startActivity(i1);
               ff = new SMSFragment();
               break;
           case R.id.E_mail:
               ff = new EmailFragment();
               break;

           case R.id.Map:
               ff = new MapFragment();
//               Intent i3 = new Intent(Intent.ACTION_VIEW);
//               i3.setData(Uri.parse("geo:32.2227,53.2621"));
//               Intent Choose = Intent.createChooser(i3,"Open Map");
//               startActivity(i3);
               break;

           case  R.id.pic:
               String fileName = "new-photo-name.jpg";
               ContentValues values = new ContentValues();
               values.put(MediaStore.Images.Media.TITLE, fileName);
               values.put(MediaStore.Images.Media.DESCRIPTION,"Image capture by camera");
               imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
               intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
               startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
               break;

       }
       if(ff!=null) {
           fg = getSupportFragmentManager();
           fg.beginTransaction()
                   .replace(R.id.frag_contaner, ff)
                   .commit();
       }
       else
       {
           System.out.println("Error in creating the fregment");


       }


    }



//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId()==R.id.SMS)
//        {
//            System.out.println("Im here");
//
//
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}