package com.example.neigeetsoleil_sondages;

import java.util.HashMap;

public class Enquete {

    private static HashMap<String, Candidat> lesCandidats = new HashMap<>();

    public static void ajouterCandidat(Candidat unCandidat){
        Enquete.lesCandidats.put(unCandidat.getNom(), unCandidat);
    }

    public static Candidat getCandidat(String nom){
        return Enquete.lesCandidats.get(nom);
    }

    public static HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }
}