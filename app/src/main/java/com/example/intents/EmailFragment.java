package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public Button bb;
    public RadioButton r1,r2;
    public EditText E1,E2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmailFragment newInstance(String param1, String param2) {
        EmailFragment fragment = new EmailFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_email,container,false);

        r1 = (RadioButton)view.findViewById(R.id.r1);
        r2 = (RadioButton)view.findViewById(R.id.r2);
        E1 = (EditText)view.findViewById(R.id.EM);
        E2 = (EditText)view.findViewById(R.id.EB);

        r1.setOnCheckedChangeListener(this);
        r2.setOnCheckedChangeListener(this);



        return view;
    }

   

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}


//   bb = (Button) view.findViewById(R.id.bb);
//
//        bb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i1 = new Intent(Intent.ACTION_SENDTO);
//                i1.setData(Uri.parse("mailto:naser.shanti@outlook.com"));
//                i1.putExtra(Intent.EXTRA_CC,new String[]{"nasershanti654@gmail.com","naser.shanti@outlook.com"});
//                i1.putExtra(Intent.EXTRA_TEXT,"This is a Test from me");
//                startActivity(i1);
//            }
//        });
//
