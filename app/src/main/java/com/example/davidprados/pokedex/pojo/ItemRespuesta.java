package com.example.davidprados.pokedex.pojo;

/**
 * Created by David Prados on 27/11/2017.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemRespuesta {

    @SerializedName("results")
    @Expose
    private ArrayList<Item> results = null;


    public ArrayList<Item> getResults() {
        return results;
    }

}
