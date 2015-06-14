package net.verstarr.paydaybudget;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.Collections;


public class BudgetListFragment extends ListFragment {

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

        Button newBudgetItemButton = (Button) view.findViewById(R.id.newBudgetItemButton);
        newBudgetItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CreateBudget", "Creating new budget item");
                //TODO: Bring up a dialog to make a new budget
            }
        });


        budgetLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // get the tag that the user long touched
                final String budget = ((TextView) view).getText().toString();

                // create a new AlertDialog
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity());

                // set the AlertDialog's title
                builder.setTitle(
                        getString(R.string.editDeleteTitle, budget));

                // set list of items to display in dialog
                builder.setItems(R.array.budget_dialog_items,
                        new DialogInterface.OnClickListener()
                        {
                            // responds to user touch by sharing, editing or
                            // deleting a saved search
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                switch (which)
                                {
                                    case 0: // Delete
                                        // TODO: bring up another dialog to edit the budget_list_item
                                        Log.d("EditBudget", "Editing a budget item");
                                        break;
                                    case 1: // delete
                                        // TODO: bring up another dialog asking if the user is sure to delete budget_list_item
                                        Log.d("DelBudget", "Deleting a budget item");
                                        deleteBudget(budget);
                                        break;
                                }
                            }
                        } // end DialogInterface.OnClickListener
                ); // end call to builder.setItems

                // set the AlertDialog's negative Button
                builder.setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener()
                        {
                            // called when the "Cancel" Button is clicked
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel(); // dismiss the AlertDialog
                            }
                        }
                ); // end call to setNegativeButton

                builder.create().show(); // display the AlertDialog
                return true;
            }

            // deletes a search after the user confirms the delete operation
            private void deleteBudget(final String budget)
            {
                // create a new AlertDialog
                AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(getActivity());

                // set the AlertDialog's message
                confirmBuilder.setMessage(
                        getString(R.string.confirmMessage, budget));

                // set the AlertDialog's negative Button
                confirmBuilder.setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            // called when "Cancel" Button is clicked
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel(); // dismiss dialog
                            }
                        }
                ); // end call to setNegativeButton

                // set the AlertDialog's positive Button
                confirmBuilder.setPositiveButton(getString(R.string.delete),
                        new DialogInterface.OnClickListener() {
                            // called when "Cancel" Button is clicked
                            public void onClick(DialogInterface dialog, int id) {
                                budgets.remove(budget); // remove tag from tags

                                // get SharedPreferences.Editor to remove saved search
                                SharedPreferences.Editor preferencesEditor =
                                        savedBudgets.edit();
                                preferencesEditor.remove(budget); // remove search
                                preferencesEditor.apply(); // saves the changes

                                // rebind tags ArrayList to ListView to show updated list
                                adapter.notifyDataSetChanged();
                            }
                        } // end OnClickListener
                ); // end call to setPositiveButton

                confirmBuilder.create().show(); // display AlertDialog
            } // end method deleteSearch

        });

        return view;
    }
}
