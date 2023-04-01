package com.example.trocker2.model;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BddCompte extends AsyncTask<Void, Void, Connection> {
    private String adresse_mail;

    /*passe à 1 quand on souhaite faire l'opération*/
    private int SELECT_COMPTE = 0;
    private int MODIFIER_COMPTE  = 0;
    private int SUPPRIMER_COMPTE = 0;




    @Override
    protected Connection doInBackground(Void... voids) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://10.0.2.2:5434/postgres";
            String user = "pierr";
            String password = "";
            System.out.println("\nConnexion à la base de données......\n");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("\nConnexion reussi\n");


            //creation de la requête
            //Statement stat = conn.createStatement();

            //String sql = "INSERT INTO compte (nom, prenom, date_naissance, adresse_mail, mot_de_passe, note_compte, pays, ville, adresse, complement_adresse, code_postal) VALUES ('Garcon', 'Pierre', '21/10/2000', 'pierre@mail.com', 'zizi', 0, 'France', 'Muel', 'la ville haute', '', 35290)";
            //stat.executeUpdate(sql);

            //fermeture de la connexion
            conn.close();
            System.out.println("\n\nFin insertion");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    protected void onPostExecute(Connection conn) {
        super.onPostExecute(conn);
        // Do something with the connection

        System.out.println("\n\nbdd compte lancé");
    }

}
