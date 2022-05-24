package com.pop.practic.ui.todocreation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.practic.R;


public class ToDoCreatorFragment extends Fragment {

    public ToDoCreatorFragment() {
        // Required empty public constructor
    }
    public static ToDoCreatorFragment newInstance(String param1, String param2) {
        ToDoCreatorFragment fragment = new ToDoCreatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.todocreator_fragment, container, false);
    }
}
