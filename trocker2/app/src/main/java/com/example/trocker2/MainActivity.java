package com.example.trocker2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.example.trocker.model.BddCompte;
import com.example.trocker.model.Compte;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private List<Compte> listeCompte = new ArrayList<>();
    private Compte actif = null;

    public Compte getActif(){
        return this.actif;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initCompte();
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

        //On vérifie les ids et mdp
        for(Compte c : listeCompte){
            System.out.println("C'est "+ c.getNom());

            if(c.getAdresse_mail().equals(email)){
                if(c.getMot_de_passe().equals(mdp)){
                    System.out.println("Trouvé");
                    this.actif = c;
                    connect = true;
                }
            }
        }

        System.out.println(connect);

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

    private void initCompte(){
        listeCompte.add(new Compte("Lemoult", "Nicolas", "", "nicolas.lemoult@gmail.com", "a12345", "France","Le Mans", "10 rue nationale", "", "72100"));
        listeCompte.add(new Compte("Garcon", "Pierre", "", "pierre.garcon@gmail.com", "a12345", "France","Le Mans", "10 rue nationale", "", "72100"));
    }
}