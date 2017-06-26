package ricindigus.com.appnotepad.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ricindigus.com.appnotepad.R;

/**
 * Created by apoyo03-ui on 4/04/2017.
 */

public class VacacionesFragment extends Fragment {

    public VacacionesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_vacaciones,container,false);
        return rootView;
    }
}
