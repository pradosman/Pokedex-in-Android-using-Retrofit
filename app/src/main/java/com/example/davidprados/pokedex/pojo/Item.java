package com.example.davidprados.pokedex.pojo;

/**
 * Created by David Prados on 27/11/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }



}
