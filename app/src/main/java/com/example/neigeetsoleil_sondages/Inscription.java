package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    public EditText txtNom, txtPrenom;
    public Spinner spFrequence;
    public Button btCommencer;
    public CheckBox chkHote, chkLocataire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);
        this.btCommencer = (Button) findViewById(R.id.idCommencer);
        this.chkHote = (CheckBox) findViewById(R.id.idIsHote);
        this.chkLocataire = (CheckBox) findViewById(R.id.idIsLoc);
        this.btCommencer.setOnClickListener(this);

        ArrayList <String> lesFrequences = new ArrayList<>();

        lesFrequences.add("Mensuel");
        lesFrequences.add("Semestriel");
        lesFrequences.add("Annuelle");

        ArrayAdapter unAdapterFrequence = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesFrequences);

        this.spFrequence.setAdapter(unAdapterFrequence);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idCommencer){
            Boolean isHote = this.chkHote.isChecked();
            Boolean isLocataire = this.chkLocataire.isChecked();
            String nom = this.txtNom.getText().toString();
            String prenom = this.txtPrenom.getText().toString();
            String frequence = this.spFrequence.getSelectedItem().toString();

            //Inscrire le candidat
            Candidat unCandidat = new Candidat(isHote, isLocataire, nom, prenom, frequence);
            Enquete.ajouterCandidat(unCandidat);
            //Demarrer l'enquete
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("nom", nom); // cle primaire des candidats
            this.startActivity(unIntent);

        }
    }
}