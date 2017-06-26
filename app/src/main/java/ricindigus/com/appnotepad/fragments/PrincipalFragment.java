package ricindigus.com.appnotepad.fragments;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ricindigus.com.appnotepad.R;
import ricindigus.com.appnotepad.activities.MainActivity;
import ricindigus.com.appnotepad.adapters.NotasAdapter;
import ricindigus.com.appnotepad.pojos.Nota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Nota> notas;
    private NotasAdapter notasAdapter;
    private FloatingActionButton fab;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_principal,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        inicializarDatos();
        notasAdapter = new NotasAdapter(getActivity().getApplicationContext(),notas);
        recyclerView.setAdapter(notasAdapter);

        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final EditText editText = new EditText(getActivity());
                editText.setBackgroundColor(Color.WHITE);
                alert.setMessage("Agregar Nota");
                alert.setTitle("Titulo de la nota");
                alert.setView(editText);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notas.add(new Nota(200,"Nota",editText.getText().toString()));
                        notasAdapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //-------
                    }
                });
                alert.show();
            }
        });
    }

    private void inicializarDatos() {
        notas = new ArrayList<Nota>();
        notas.add(new Nota(1,"Nota1","Texto de la nota 1"));
        notas.add(new Nota(2,"Nota2","Texto de la nota 2"));
        notas.add(new Nota(3,"Nota3","Texto de la nota 3"));
        notas.add(new Nota(4,"Nota4","Texto de la nota 4"));
        notas.add(new Nota(5,"Nota5","Texto de la nota 5"));
        notas.add(new Nota(6,"Nota6","Texto de la nota 6"));
        notas.add(new Nota(7,"Nota7","Texto de la nota 7"));
        notas.add(new Nota(8,"Nota8","Texto de la nota 8"));
        notas.add(new Nota(9,"Nota9","Texto de la nota 9"));
        notas.add(new Nota(10,"Nota10","Texto de la nota 10"));
        notas.add(new Nota(11,"Nota11","Texto de la nota 11"));
        notas.add(new Nota(12,"Nota12","Texto de la nota 12"));
        notas.add(new Nota(13,"Nota13","Texto de la nota 13"));
        notas.add(new Nota(14,"Nota14","Texto de la nota 14"));
        notas.add(new Nota(15,"Nota15","Texto de la nota 15"));
        notas.add(new Nota(16,"Nota16","Texto de la nota 16"));
        notas.add(new Nota(17,"Nota17","Texto de la nota 17"));
        notas.add(new Nota(18,"Nota18","Texto de la nota 18"));
        notas.add(new Nota(19,"Nota19","Texto de la nota 19"));
    }
}
