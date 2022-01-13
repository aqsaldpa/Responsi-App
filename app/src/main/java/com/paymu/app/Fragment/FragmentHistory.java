package com.paymu.app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.paymu.app.Adapter.RVAdapter;
import com.paymu.app.HistoryModelClass;
import com.paymu.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHistory extends Fragment {
    List<HistoryModelClass> historylist;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        // Inflate the layout for this fragment
        mrecyclerview = view.findViewById(R.id.Recyclervieww);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mrecyclerview.setAdapter(adapter);
        initData();
        initRecyclerView();

        return view;

    }

    private void initRecyclerView() {
        RecyclerView mrecyclerview = (RecyclerView) getActivity().findViewById(R.id.Recyclervieww);

        LinearLayoutManager layoutManager = mlayoutManager;
        new LinearLayoutManager(getActivity());
        mrecyclerview.setLayoutManager(layoutManager);
        mlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerview.setLayoutManager(layoutManager);
        RVAdapter adapter = new RVAdapter(historylist);
        mrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {
        historylist = new ArrayList<>();

        historylist.add(new HistoryModelClass(R.drawable.logo, "17 November 2020", "PLN Bill", "Succes", "_______________________________________"));
        historylist.add(new HistoryModelClass(R.drawable.logo, "20 November 2020", "PLN Bill", "Succes", "_______________________________________"));
    }
}