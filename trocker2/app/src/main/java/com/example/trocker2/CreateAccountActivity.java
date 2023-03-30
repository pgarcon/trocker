package com.example.trocker2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.trocker.model.Compte;
import com.example.trocker2.model.Bdd;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {
    private Compte compte;
    private MainActivity main;

    public void setMain(MainActivity main) {
        this.main = main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createCompte(View v){

        Compte c = recupererInfos();

        boolean mail = false;

        for(Compte test : Bdd.getListeCompte()){
            if(c.getAdresse_mail().equals(test.getAdresse_mail())) mail = true;
        }

        if(mail) {
            AlertDialog.Builder mailExiste = new AlertDialog.Builder(this);
            mailExiste.setMessage("Email déjà pris");
            mailExiste.setCancelable(true);

            mailExiste.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            mailExiste.show();
        }
        else {
            Bdd.addCompte(c);
        }
    }

    public void retourMainPage(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private com.example.trocker.model.Compte recupererInfos(){
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