package net.verstarr.paydaybudget;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


public class BudgetListFragment extends Fragment {

    private static final String BUDGETS = "budgets";
    private SharedPreferences savedBudgets;
    private ListView budgetLV;
    private ArrayList<String> budgets; // list of budgets for saved searches
    private ArrayAdapter<String> adapter; // binds budgets to ListView

    // configures the BudgetListFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_budget_list, container, false);

        // A Saved list of the user's budgets
        savedBudgets = this.getActivity().getSharedPreferences(BUDGETS, Context.MODE_PRIVATE);
        budgets = new ArrayList<>(savedBudgets.getAll().keySet());
        Collections.sort(budgets, String.CASE_INSENSITIVE_ORDER);


        // create ArrayAdapter and use it to bind tags to the ListView
        adapter = new ArrayAdapter<>(getActivity(), R.id.budget_list, R.layout.list_item, budgets);
        budgetLV = (ListView) view.findViewById(R.id.budget_list);
        budgetLV.setAdapter(adapter);

        return view;
    }
}
