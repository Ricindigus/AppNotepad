package ricindigus.com.appnotepad.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ricindigus.com.appnotepad.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuperMercadoFragment extends Fragment {


    public SuperMercadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_super_mercado,container,false);
        return rootView;
    }

}
