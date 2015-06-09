package net.verstarr.days2payday;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by VerStarr22 on 6/8/15.
 */
public class PaydayBannerFragment extends Fragment {


    // configures the QuizFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_payday_banner, container, false);

        return view;
    }
}
