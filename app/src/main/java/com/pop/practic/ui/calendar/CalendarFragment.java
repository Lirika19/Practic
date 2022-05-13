package com.pop.practic.ui.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.practic.databinding.FragmentCalendarBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {

    FragmentCalendarBinding fragmentCalendarBinding;

    public CalendarFragment() {}

    public static CalendarFragment newInstance(String param1, String param2)
    {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fragmentCalendarBinding = FragmentCalendarBinding.inflate(inflater,container,false);
        fragmentCalendarBinding.calendarView.setOnDateChangeListener((calendarView, i, i1, i2) -> {

        });
        return fragmentCalendarBinding.getRoot();
    }
}