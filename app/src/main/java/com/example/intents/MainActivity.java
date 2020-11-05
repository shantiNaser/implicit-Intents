package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {
    ChipNavigationBar nav;
    FragmentManager fg;

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
              // Intent i1 = new Intent(this,AccSMS.class);
              // startActivity(i1);
               ff = new SMSFragment();
               break;
           case R.id.E_mail:
               ff = new EmailFragment();
               break;

           case R.id.Map:
               Intent i3 = new Intent(Intent.ACTION_VIEW);
               i3.setData(Uri.parse("geo:32.2227,53.2621"));
               Intent Choose = Intent.createChooser(i3,"Open Map");
               startActivity(i3);
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