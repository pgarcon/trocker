package com.example.trocker.model;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

        System.out.println("\n\nexecution de l'appli");

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
