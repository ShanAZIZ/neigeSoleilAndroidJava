package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fin extends AppCompatActivity implements View.OnClickListener {

    private Button btResultat;
    private TextView txtScore;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        this.txtScore = (TextView) findViewById(R.id.idScoreText);
        this.btResultat = (Button) findViewById(R.id.idResultat);
        this.nom = this.getIntent().getStringExtra("nom").toString();

        this.btResultat.setOnClickListener(this);

        float moyenne = Enquete.getCandidat(this.nom).moyenne();
        this.txtScore.setText(this.nom+", Merci d'avoir participer a notre enquete. Votre moyenne : "+moyenne);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idResultat){
            Intent unIntent = new Intent(this, Resultats.class);
            this.startActivity(unIntent);
        }
    }
}