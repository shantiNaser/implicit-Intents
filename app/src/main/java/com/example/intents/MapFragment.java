package com.example.intents;

import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    public EditText nameee,lot,llt;
    public Button button;
    public Switch s1,s2;
    public TextView inf,inf1;
    public int flag;
    private View view;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
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

        view = inflater.inflate(R.layout.fragment_map,container,false);
        nameee = (EditText) view.findViewById(R.id.nameee);
        lot = (EditText) view.findViewById(R.id.longt);
        llt = (EditText) view.findViewById(R.id.latt);
        inf = (TextView) view.findViewById(R.id.inf);
        inf1 = (TextView) view.findViewById(R.id.inf1);
        button = (Button) view.findViewById(R.id.button);
        s1 = (Switch) view.findViewById(R.id.s1);
        s2 = (Switch) view.findViewById(R.id.s2);

        s1.setOnCheckedChangeListener(this);
        s2.setOnCheckedChangeListener(this);

        button.setOnClickListener(this);

//
//       s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//               if(s1.isChecked()&&!s2.isChecked())
//               {
//                   inf.setVisibility(View.VISIBLE);
//                   lot.setVisibility(View.VISIBLE);
//                   llt.setVisibility(View.VISIBLE);
//
//                   button.setOnClickListener(new View.OnClickListener() {
//                       @Override
//                       public void onClick(View view) {
//
//                           String l1 = llt.getText().toString();
//                           String l2 = lot.getText().toString();
//                           if(!l1.isEmpty()&&!l2.isEmpty())
//                           {
//                               Intent i3 = new Intent(Intent.ACTION_VIEW);
//                               i3.setData(Uri.parse("geo:"+l1+","+l2));
//                               Intent Choose = Intent.createChooser(i3,"Open Map");
//                               startActivity(i3);
//                           }
//                           else
//                           {
//                               Toast.makeText(getActivity(),"an requred filed was missing ",Toast.LENGTH_LONG).show();
//                           }
//
//                       }
//                   });
//
//
//               }
//
//               else if(s2.isChecked())
//               {
//                   System.out.println("S2 is checked");
//               }
//
//
//              else if(!s1.isChecked()&&!s2.isChecked())
//               {
//                   inf.setVisibility(View.INVISIBLE);
//                   lot.setVisibility(View.INVISIBLE);
//                   llt.setVisibility(View.INVISIBLE);
//                   inf1.setVisibility(View.INVISIBLE);
//                   nameee.setVisibility(View.INVISIBLE);
//               }
//
//             else if(s1.isChecked()&&s2.isChecked())
//               {
//
//               }
//
//
//
//
//
//
//           }
//
//
//
//       });
//




        return view;
    }

    @Override
    public void onClick(View view) {

        if(s1.isChecked())
        {
            String l1 = llt.getText().toString();
            String l2 = lot.getText().toString();
            Intent i3 = new Intent(Intent.ACTION_VIEW);
            i3.setData(Uri.parse("geo:"+l1+","+l2));
            Intent Choose = Intent.createChooser(i3,"Open Map");
            startActivity(i3);

        }

        else if(s2.isChecked())
        {
           String nn = nameee.getText().toString();
           Intent i3 = new Intent(Intent.ACTION_VIEW);
           i3.setData(Uri.parse("geo:0,0?q="+nn));
           Intent Choose = Intent.createChooser(i3,"Open Map");
           startActivity(i3);

        }




    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(compoundButton==s1)
        {
            if(b)
            {
                inf.setVisibility(View.VISIBLE);
                lot.setVisibility(View.VISIBLE);
                llt.setVisibility(View.VISIBLE);
                s2.setChecked(false);

            }
            else if(!b)
            {
                inf.setVisibility(View.INVISIBLE);
                lot.setVisibility(View.INVISIBLE);
                llt.setVisibility(View.INVISIBLE);
            }
        }

        else if(compoundButton==s2)
        {
            if(b) {
                inf1.setVisibility(View.VISIBLE);
                nameee.setVisibility(View.VISIBLE);
                s1.setChecked(false);
            }
            else if(!b)
            {
                inf1.setVisibility(View.INVISIBLE);
                nameee.setVisibility(View.INVISIBLE);
            }
        }


    }
}