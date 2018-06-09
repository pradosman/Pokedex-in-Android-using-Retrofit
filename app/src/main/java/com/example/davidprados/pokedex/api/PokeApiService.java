package com.example.davidprados.pokedex.api;

import com.example.davidprados.pokedex.pojo.BayaRespuesta;
import com.example.davidprados.pokedex.pojo.ItemRespuesta;
import com.example.davidprados.pokedex.pojo.MovimientoRespuesta;
import com.example.davidprados.pokedex.pojo.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by David Prados on 26/11/2017.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("move")
    Call<MovimientoRespuesta> obtenerListaMovimientos(@Query("limit") int limit, @Query("offset") int offset);

    @GET("berry")
    Call<BayaRespuesta> obtenerListaBayas(@Query("limit") int limit, @Query("offset") int offset);

    @GET("item")
    Call<ItemRespuesta> obtenerListaItems(@Query("limit") int limit, @Query("offset") int offset);
}
