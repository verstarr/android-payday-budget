package net.verstarr.paydaybudget;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.verstarr.paydaybudget.util.Budget;

import java.util.ArrayList;
import java.util.Collections;


public class BudgetListFragment extends Fragment {

    //private static final String BUDGETS = "budgets";
    private SharedPreferences savedBudgets;
    private ListView budgetLV;
    private ArrayList<Budget> budgets; // list of budgets for saved searches
    private ArrayList<String> budgetTitles;
    private ArrayAdapter adapter; // binds budgets to ListView

    // configures the BudgetListFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_budget_list, container, false);

        // A Saved list of the user's budgets
        //savedBudgets = this.getActivity().getSharedPreferences(BUDGETS, Context.MODE_PRIVATE);
        //budgets = new ArrayList<>(savedBudgets.getAll().keySet());


        //Collections.sort(budgetTitles, String.CASE_INSENSITIVE_ORDER);

        // create ArrayAdapter and use it to bind tags to the ListView
        //adapter = new ArrayAdapter<>(getActivity(), R.id.budget_list, R.layout.list_item, budgetTitles);
        //budgetLV = (ListView) view.findViewById(R.id.budget_list);
        //budgetLV.setAdapter(adapter);

        Button newBudgetItemButton = (Button) view.findViewById(R.id.newBudgetItemButton);
        newBudgetItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CreateBudget", "Creating new budget item");
                //TODO: Bring up a dialog to make a new budget
                Intent intent = new Intent(getActivity().getApplicationContext(), NewBudgetActivity.class);

                startActivity(intent);
            }
        });




        return view;
    }
}
