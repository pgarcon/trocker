package com.example.trocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MainAdapter extends ArrayAdapter {
    List<String> numberWord;
    List<Integer> numberImage;
    int itemLayout;
    Context c;

    // constructor is called to initialize the objects
    public MainAdapter(List<String> word, List<Integer> image, int resource, Application context) {
        super(context, resource, word);
        numberWord = word;
        numberImage = image;
        itemLayout = resource;
        c = context;
    }

    // getCount() is called to return
    // the total number of words to be used
    @Override
    public int getCount() {
        return numberWord.size();
    }

    // getView() is called to get position,
    // parent and view of the images.
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        }

        String word = numberWord.get(position);
        Integer image = numberImage.get(position);

        TextView textView = convertView.findViewById(R.id.text_view);
        ImageView imageView = convertView.findViewById(R.id.image_view);
        textView.setText(word);
        imageView.setImageResource(image);
        return convertView;
    }
}
