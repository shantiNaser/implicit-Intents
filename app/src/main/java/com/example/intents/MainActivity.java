package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {
    ChipNavigationBar nav;

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

       switch (i){

           case R.id.SMS:
               Intent i1 = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:0597087763"));
               i1.putExtra("sms_body","This is a Test Message");
               startActivity(i1);
               break;
           case R.id.E_mail:
               System.out.println("Hello Wolrd 2");
               break;

           case R.id.Map:
               Intent i3 = new Intent(Intent.ACTION_VIEW);
               i3.setData(Uri.parse("geo:32.2227,53.2621"));
               Intent Choose = Intent.createChooser(i3,"Open Map");
               startActivity(i3);
               break;

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