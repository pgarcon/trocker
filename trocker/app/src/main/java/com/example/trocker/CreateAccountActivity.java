package com.example.trocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trocker.model.Compte;

public class CreateAccountActivity extends AppCompatActivity {
    private Compte compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }

    public void createCompte(View v){
        this.compte = recupererInfos();
        System.out.println("Compte créer : " + this.compte.getNom());
    }

    public void retourMainPage(){
        this.compte = recupererInfos();
    }

    private Compte recupererInfos(){
        EditText nomRec = (EditText) findViewById (R.id.nomSaisie);
        EditText prenomRec = (EditText) findViewById (R.id.prenomSaisie);
        EditText mailRec = (EditText) findViewById (R.id.emailSaisie);
        EditText dataNaissRec = (EditText) findViewById (R.id.dateNaisSaisie);
        EditText mdpRec = (EditText) findViewById (R.id.mdpSaisie);
        EditText paysRec = (EditText) findViewById (R.id.paysSaisie);
        EditText villeRec = (EditText) findViewById (R.id.villeSaisie);
        EditText adresseRec = (EditText) findViewById (R.id.adresseSaisie);
        EditText codePostalRec = (EditText) findViewById (R.id.codePostalSaisie);
        EditText complementAdresseRec = (EditText) findViewById (R.id.cmpltAdresseSaisie);

        String nom = nomRec.getText().toString();
        String prenom = prenomRec.getText().toString();
        String mail = mailRec.getText().toString();
        String dateNaiss = dataNaissRec.getText().toString();
        String mdp = mdpRec.getText().toString();
        String pays = paysRec.getText().toString();
        String ville = villeRec.getText().toString();
        String adress = adresseRec.getText().toString();
        String cmplAdress = complementAdresseRec.getText().toString();
        String codePostal = codePostalRec.getText().toString();

        return new Compte(nom, prenom, dateNaiss, mail, mdp, pays, ville, adress, cmplAdress, codePostal);
    }
}