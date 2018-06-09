package com.example.davidprados.pokedex.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.davidprados.pokedex.R;
import com.example.davidprados.pokedex.adaptadores.BayaAdapter;
import com.example.davidprados.pokedex.api.PokeApiService;
import com.example.davidprados.pokedex.pojo.Baya;
import com.example.davidprados.pokedex.pojo.BayaRespuesta;
import com.example.davidprados.pokedex.pojo.Movimiento;
import com.example.davidprados.pokedex.pojo.MovimientoRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBaya.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBaya#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBaya extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recycler;
    private BayaAdapter adapter;

    public FragmentBaya() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBaya.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBaya newInstance(String param1, String param2) {
        FragmentBaya fragment = new FragmentBaya();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fragment_baya, container,false);

        recycler = vista.findViewById(R.id.recView);
        adapter = new BayaAdapter(getContext());
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        //final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        obtenerBayas();

        return vista;
    }

    private void obtenerBayas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<BayaRespuesta> call = service.obtenerListaBayas(64,0);

        call.enqueue(new Callback<BayaRespuesta>() {
            @Override
            public void onResponse(Call<BayaRespuesta> call, Response<BayaRespuesta> response) {
                if(response.isSuccessful()){
                    BayaRespuesta p = response.body();
                    ArrayList<Baya> listaBaya = p.getResults();

                    adapter.addListaBayas(listaBaya);
                }
            }

            @Override
            public void onFailure(Call<BayaRespuesta> call, Throwable t) {
                Toast toast1 =
                        Toast.makeText(getContext(),
                                "Error", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
