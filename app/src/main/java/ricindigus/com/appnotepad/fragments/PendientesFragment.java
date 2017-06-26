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
public class PendientesFragment extends Fragment {


    public PendientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_pendientes,container,false);
        return rootView;
    }

}
