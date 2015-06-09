package net.verstarr.days2payday;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import example.com.quickapp.R;


public class BudgetListFragment extends Fragment {
    private ListView budgetLV;
    private ArrayList<String> budgets; // list of budgets for saved searches
    private ArrayAdapter<String> adapter; // binds budgets to ListView

    // configures the BudgetListFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_budget_list, container, false);


        budgetLV = (ListView) view.findViewById(R.id.budget_list);

        // store the saved budgets in an ArrayList then sort them
        budgets = new ArrayList<String>();
        budgets.add("Hello");
        budgets.add("my");
        budgets.add("name");
        budgets.add("is");
        budgets.add("ver");
        Collections.sort(budgets, String.CASE_INSENSITIVE_ORDER);

        // create ArrayAdapter and use it to bind tags to the ListView
        //adapter = new ArrayAdapter<String>(getActivity(), R.id.list_item, budgets);


        return view;
    }
}
