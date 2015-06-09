package net.verstarr.paydaybudget;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.quickapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FillerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FillerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FillerFragment extends Fragment {

    public FillerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filler, container, false);
    }
}
