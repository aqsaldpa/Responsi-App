package com.paymu.app.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymu.app.Adapter.RVAdapter;
import com.paymu.app.Data.Model.HistoryModelClass;
import com.paymu.app.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHistory extends Fragment {
    ArrayList<HistoryModelClass> historylist;
    RecyclerView mrecyclerview;
    LinearLayoutManager mlayoutManager;
    RVAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHistory newInstance(String param1, String param2) {
        FragmentHistory fragment = new FragmentHistory();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        mrecyclerview = view.findViewById(R.id.recyclerviewww);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        historylist = new ArrayList<>();

        HistoryModelClass obj1 = (new HistoryModelClass("17 November 2021","PLN Bill","Success"));
        historylist.add(obj1);

        HistoryModelClass obj2 = (new HistoryModelClass("17 Desember 2021","Credit Card Bill","Failed"));
        historylist.add(obj2);

        HistoryModelClass obj3 = (new HistoryModelClass("17 November 2022","PLN Bill","Success"));
        historylist.add(obj3);

        HistoryModelClass obj4 = (new HistoryModelClass("30 Januari 2022","Kartu Halo Bill","Success"));
        historylist.add(obj4);

        HistoryModelClass obj5 = (new HistoryModelClass("21 Februari 2022","PDAM Bill","Failed"));
        historylist.add(obj5);

        HistoryModelClass obj6 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj6);

        HistoryModelClass obj7 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj7);

        HistoryModelClass obj8 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj8);

        HistoryModelClass obj9 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj9);

        HistoryModelClass obj10 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj10);

        HistoryModelClass obj11 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj11);

        HistoryModelClass obj12 = (new HistoryModelClass("17 Desember 2021","PLN Bill","Success"));
        historylist.add(obj12);







        mrecyclerview.setAdapter(new RVAdapter(historylist,this));
        return view;

    }
}