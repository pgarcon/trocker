package com.example.trocker.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trocker.MainAdapter;
import com.example.trocker.R;
import com.example.trocker.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements GestureDetector.OnGestureListener {

    private ImageView imageView;
    private GestureDetectorCompat gestureDetector;
    private int currentImageIndex = 0;
    private List<Bitmap> images = new ArrayList<>();


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        imageView = (ImageView) getActivity().findViewById(R.id.swipe);
        //System.out.println(imageView);
        gestureDetector = new GestureDetectorCompat(getActivity(), this);

        // Ajouter des images à la liste des images
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.one));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.two));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.three));

        // Afficher la première image
        if(imageView != null) {
            imageView.setImageBitmap(images.get(currentImageIndex));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return getActivity().onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        if (event2.getX() > event1.getX()) {
            // Swipe de gauche à droite
            if (currentImageIndex > 0) {
                currentImageIndex--;
                imageView.setImageBitmap(images.get(currentImageIndex));
            }
        } else if (event2.getX() < event1.getX()) {
            // Swipe de droite à gauche
            if (currentImageIndex < images.size() - 1) {
                currentImageIndex++;
                imageView.setImageBitmap(images.get(currentImageIndex));
            }
        }
        return true;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        // Méthode vide, pas besoin de l'implémenter
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
        // Méthode vide, pas besoin de l'implément
        return true;
    }
}