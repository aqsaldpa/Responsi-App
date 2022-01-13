package com.paymu.app.Fragment;

import android.app.Activity;
import android.graphics.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.paymu.app.R;

public class FragmentPayment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int DEBUG_TAG = 101 ;

    // TODO: Rename and change types of parameters
    static Camera camera = null;
    private String mParam1;
    private String mParam2;
    private CodeScanner mCodeScan;
    public FragmentPayment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPayment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPayment newInstance(String param1, String param2) {
        FragmentPayment fragment = new FragmentPayment();
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
        // Inflate the layout for this fragment
        final Activity activity = getActivity();
        View root = inflater.inflate(R.layout.fragment_payment,container,false);
        CodeScannerView scannerView = root.findViewById(R.id.scanner_view);
        mCodeScan = new CodeScanner(activity,scannerView);
        mCodeScan.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCodeScan.startPreview();

            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScan.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScan.releaseResources();
        super.onPause();

    }

}