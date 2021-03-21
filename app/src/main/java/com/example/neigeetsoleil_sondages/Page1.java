package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgService, rgSejour;
    private Button btSuivant;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.rgService = (RadioGroup) findViewById(R.id.idService);
        this.rgSejour = (RadioGroup) findViewById(R.id.idSejour);
        this.btSuivant = (Button) findViewById(R.id.idSuivant1);
        this.nom = this.getIntent().getStringExtra("nom").toString();

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idSuivant1){
            //Calculer le score des reponses
            int score = 0;
            switch (this.rgService.getCheckedRadioButtonId()){
                case R.id.idService1 : score = 16;break;
                case R.id.idService2 : score = 12;break;
                case R.id.idService3 : score = 8;break;
            }
            Enquete.getCandidat(this.nom).ajouterReponse("ponctualite", score);

            score = 0;
            switch (this.rgSejour.getCheckedRadioButtonId()){
                case R.id.idSejour1 : score = 16;break;
                case R.id.idSejour2 : score = 12;break;
                case R.id.idSejour3 : score = 8;break;
            }
            Enquete.getCandidat(this.nom).ajouterReponse("proprete", score);
            //Aller a la page 2
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}