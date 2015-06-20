package net.verstarr.paydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.verstarr.paydaybudget.util.Budget;

/**
 * Created by VerStarr22 on 6/16/15.
 */
public class NewBudgetActivity extends AppCompatActivity {


    private EditText budgetNameEditText;
    private EditText budgetDescriptionEditText;
    private EditText budgetPercentEditText;
    private Button saveButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_budget);

        budgetNameEditText = (EditText) findViewById(R.id.budgetNameEditText);
        budgetDescriptionEditText = (EditText) findViewById(R.id.budgetDescriptionEditText);
        budgetPercentEditText = (EditText) findViewById(R.id.budgetPercentEditText);

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Budget budget = new Budget(budgetNameEditText.getText().toString(), budgetDescriptionEditText.getText().toString(), Double.parseDouble(budgetPercentEditText.getText().toString()));
                // TODO: Create the budget item then save it to the listview on the BudgetListFragment
            }
        });

        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
