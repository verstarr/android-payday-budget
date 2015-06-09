package net.verstarr.paydaybudget;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import example.com.quickapp.R;

public class SecondaryActivityView extends ActionBarActivity {

    private Fragment bannerFrag;
    private Fragment listViewFrag;
    private FragmentTransaction fragTransaction;
    private FragmentTransaction listFragTransaction;
    private Button calendarButton;
    MenuItem calendarExpandBtn;
    MenuItem calendarMinimizeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_activity_view);

        calendarButton = (Button)findViewById(R.id.expand_calendar);
        //TODO add if SavedInstantState == null

        bannerFrag = new PayDayBannerFragment();
        fragTransaction = getFragmentManager().beginTransaction().add(R.id.calendar_container, bannerFrag);
        fragTransaction.commit();

        listViewFrag = new BudgetListFragment();
        listFragTransaction = getFragmentManager().beginTransaction().add(R.id.list_view_container, listViewFrag);
        listFragTransaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary_activity_view, menu);

        calendarExpandBtn = menu.findItem(R.id.expand_calendar);
        calendarMinimizeBtn = menu.findItem(R.id.minimize_calendar);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.expand_calendar:

                Fragment frag = new CalendarActivityFragment();
                FragmentTransaction fragTrans = getFragmentManager().beginTransaction().replace(R.id.calendar_container, frag);
                fragTrans.commit();

                if(item.isVisible()) {
                    calendarExpandBtn.setVisible(false);
                    calendarMinimizeBtn.setVisible(true);
                }
                else{
                    calendarMinimizeBtn.setVisible(true);
                }
                break;
            case R.id.minimize_calendar:

                Fragment tempfrag = new PayDayBannerFragment();
                FragmentTransaction tempfragTrans = getFragmentManager().beginTransaction().replace(R.id.calendar_container, tempfrag);
                tempfragTrans.commit();

                if(item.isVisible()) {
                    calendarMinimizeBtn.setVisible(false);
                    calendarExpandBtn.setVisible(true);
                }
                else{
                    calendarMinimizeBtn.setVisible(true);
                }
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
