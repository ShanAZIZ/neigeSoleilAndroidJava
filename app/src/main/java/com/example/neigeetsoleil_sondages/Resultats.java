package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Resultats extends AppCompatActivity implements View.OnClickListener {

    private ListView lvResultats;
    private Button btRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        this.lvResultats = (ListView) findViewById(R.id.idListeResultat);
        this.btRetour = (Button) findViewById(R.id.idRetour);

        this.btRetour.setOnClickListener(this);

        ArrayList<String> lesResultats = new ArrayList<>();
        for (Candidat unCandidat : Enquete.getLesCandidats().values()){
            lesResultats.add(unCandidat.getNom() + " "+ unCandidat.getPrenom() + " " + unCandidat.moyenne());
        }

        ArrayAdapter unAdapterRes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesResultats);

        this.lvResultats.setAdapter(unAdapterRes);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idRetour ){
            Toast.makeText(this, "Merci d'avoir participer à l'enquete SNCF", Toast.LENGTH_LONG).show();
            Intent unIntent = new Intent(this, MainActivity.class);
            this.startActivity(unIntent);
        }
    }
}