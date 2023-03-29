package com.example.trocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.trocker.model.BddCompte;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        BddCompte model = new BddCompte();
        model.execute();
        setContentView(R.layout.activity_main);
    }

    public void creerCompte(View view){
        // Créer une Intent pour lancer l'activité souhaitée
        Intent intent = new Intent(this, CreateAccountActivity.class);

        // Lancer l'activité
        startActivity(intent);
    }

    public void connexion(View v){
        EditText tp = (EditText) findViewById (R.id.inputMail);
        String chaine = tp.getText().toString();

        Intent intent = new Intent(this, Application.class);
        startActivity(intent);
    }
}