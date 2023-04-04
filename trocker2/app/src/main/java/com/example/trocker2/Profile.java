package com.example.trocker2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.trocker2.model.Bdd;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {
    private boolean delete;

    private static final String KEY_POSITION="position";
    private int arg;

    public Profile() {
        // Required empty public constructor
    }

    public static Profile newInstance(int param1) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            arg = getArguments().getInt(KEY_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_profile, container, false);

        RatingBar barre = result.findViewById(R.id.ratingBar);
        barre.setRating(Bdd.getActif().getNote_compte());

        return result;
    }
}