package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class Page2 extends AppCompatActivity implements View.OnClickListener {

    private SeekBar sbServClient;
    private RatingBar rbSiteInternet;
    private Button btSuivant2;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.sbServClient = (SeekBar) findViewById(R.id.idServClient);
        this.rbSiteInternet = (RatingBar) findViewById(R.id.idSiteInternet);

        this.nom = this.getIntent().getStringExtra("nom").toString();

        this.btSuivant2 =(Button) findViewById(R.id.idSuivant2);
        this.btSuivant2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idSuivant2){

            int score = 0;
            int progress = this.sbServClient.getProgress();
            switch (progress){
                case 0 : score = 8;
                case 1 : score = 12;
                case 2 : score = 16;

            }
            System.out.println(progress);
            Enquete.getCandidat(this.nom).ajouterReponse("service_client", score);
            score = 0;
            float stars = this.rbSiteInternet.getRating();
            System.out.println(stars);
            if(stars<=2) score = 8;
            else if(stars>2 && stars<4) score = 12;
            else score = 16;
            Enquete.getCandidat(this.nom).ajouterReponse("site_internet", score);

            Intent unIntent = new Intent(this, Page3.class);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}