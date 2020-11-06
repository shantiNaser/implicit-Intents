package com.example.intents;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SMSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SMSFragment extends Fragment {
    public EditText Ed1,Ed2;
    public Button b1;
    Activity activity = getActivity();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SMSFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SMSFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SMSFragment newInstance(String param1, String param2) {
        SMSFragment fragment = new SMSFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }
    public static final int SMS_REQUEST_CODE = 123;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==123)
        {
            String phoneNum = Ed1.getText().toString();
            String body = Ed2.getText().toString();
            SmsManager s = SmsManager.getDefault();
            s.sendTextMessage(phoneNum,null,body,null,null);
            System.out.println("OK im send");
           // Toast.makeText(activity,"SMS was sent Successfully",Toast.LENGTH_LONG).show();

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_s_m_s,container,false);

        Ed1 = (EditText) view.findViewById(R.id.Ed1);
        Ed2 = (EditText) view.findViewById(R.id.F);
        b1 = (Button) view.findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.b1) {

                    if (getActivity().checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 123);
                    } else {
                        String phoneNum = Ed1.getText().toString();
                        String body = Ed2.getText().toString();
                        SmsManager s = SmsManager.getDefault();
                        s.sendTextMessage(phoneNum, null, body, null, null);

                    }
                    //Intent i1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+phoneNum));
                    //i1.putExtra("sms_body",body);
                    //startActivity(i1);
                }
            }
        });

        return view;

    }
}