package com.example.neigeetsoleil_sondages;

import java.util.HashMap;

public class NeigeEtSoleil {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser(){
    }

    public static Enquete getEnquete(String rer){
        return lesEnquetes.get(rer);
    }


}
