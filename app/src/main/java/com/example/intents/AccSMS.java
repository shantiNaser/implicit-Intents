package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccSMS extends AppCompatActivity {

    public EditText Ed1,Ed2;
    public Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_s_m_s);

        Ed1 = findViewById(R.id.Ed1);
        Ed2 = findViewById(R.id.Ed2);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNum = Ed1.getText().toString();
                String body = Ed2.getText().toString();
                Intent i1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+phoneNum));
                i1.putExtra("sms_body",body);
                startActivity(i1);



            }
        });
    }
}