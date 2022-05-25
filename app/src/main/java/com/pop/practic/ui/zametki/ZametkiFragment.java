package com.pop.practic.ui.zametki;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.practic.R;
import com.pop.practic.app.App;
import com.pop.practic.databinding.FragmentZametkiBinding;
import com.pop.practic.ui.zametki.adapters.GoalsAdapter;
import com.pop.practic.ui.zametki.adapters.MoviesAdapter;

public class ZametkiFragment extends Fragment {
    FragmentZametkiBinding fragmentZametkiBinding;
    GoalsAdapter goalsAdapter = new GoalsAdapter(App.getInstance().getRepository());
    MoviesAdapter moviesAdapter = new MoviesAdapter(App.getInstance().getRepository());

    public static ZametkiFragment newInstance(String param1, String param2) {
        ZametkiFragment fragment = new ZametkiFragment();
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
        fragmentZametkiBinding = FragmentZametkiBinding.inflate(inflater, container, false);
        fragmentZametkiBinding.goalsRecyclerView.setAdapter(goalsAdapter);
        fragmentZametkiBinding.moviesRecyclerView.setAdapter(moviesAdapter);
        return fragmentZametkiBinding.getRoot();
    }
}