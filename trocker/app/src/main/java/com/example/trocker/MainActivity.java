package com.example.trocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.trocker.model.BddCompte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BddCompte model = new BddCompte();
        model.execute();
        setContentView(R.layout.activity_main);
    }
}