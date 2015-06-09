package net.verstarr.days2payday;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


/**
 * Created by VerStarr22 on 6/6/15.
 */
public class BudgetListFragment extends Fragment {
    // budgetList logic

    private static final String BUDGETS = "budgets";

    private SharedPreferences savedBudgets; // user's favorite searches
    private ArrayList<String> tags; // list of tags for saved searches
    private ArrayAdapter<String> adapter; // binds tags to ListView

    // configures the QuizFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_budget_list, container, false);

        return view;
    }

}
