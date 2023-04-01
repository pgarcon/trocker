package com.example.trocker2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.example.trocker2.model.BddCompte;
import com.example.trocker2.model.Compte;
import com.example.trocker2.model.Bdd;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bdd.initCompte();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void creerCompte(View view){
        // Créer une Intent pour lancer l'activité souhaitée
        Intent intent = new Intent(this, CreateAccountActivity.class);

        // Lancer l'activité
        startActivity(intent);
    }

    public void connexion(View v){
        //Récupérer l'email et le mdp saisi
        EditText EdEmail = (EditText) findViewById(R.id.inputMail);
        EditText EdMdp = (EditText) findViewById(R.id.inputMdp);

        String email = EdEmail.getText().toString();
        String mdp = EdMdp.getText().toString();

        //Pour check la connexion
        boolean connect = false;

        //On vérifie l'id et le mdp
        for(Compte c : Bdd.getListeCompte()){
            if(c.getAdresse_mail().equals(email)){
                if(c.getMot_de_passe().equals(mdp)){
                    System.out.println("Trouvé");
                    Bdd.setActif(c);
                    connect = true;
                }
            }
        }

        //On change de page et on charge le reste de l'appli
        if(connect){
            Intent intent = new Intent(this, Application.class);
            startActivity(intent);
        }
        //On envoie une boite de dialogue
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Mauvais email ou mot de passe");
            alert.setCancelable(true);

            alert.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            alert.show();
        }
    }

    public void contact(View v){
        AlertDialog.Builder contact = new AlertDialog.Builder(this);
        contact.setMessage("Nos email : \nnicolas.lemoult@outlook.fr\npierre.garcon@outlook.fr");
        contact.setCancelable(true);

        contact.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        contact.show();
    }
}