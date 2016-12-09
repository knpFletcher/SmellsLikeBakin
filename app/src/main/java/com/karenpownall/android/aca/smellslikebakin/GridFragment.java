package com.karenpownall.android.aca.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.R.attr.numColumns;

public class GridFragment extends Fragment {

    public interface OnRecipeSelectedInterface{
        void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListFragment.OnRecipeSelectedInterface listener = (ListFragment.OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridAdapter gridAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(gridAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}