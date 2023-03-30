package com.example.trocker2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    private static final String KEY_POSITION="position";
    private String arg;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Accueil.
     */
    // TODO: Rename and change types and number of parameters
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
            arg = getArguments().getString(KEY_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_profile, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);

        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);

        textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }
}