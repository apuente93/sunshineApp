package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //After the root view is created, create some dummy list of forecast entries

            String[] dummyForecastEntries = {"Today-Sunny-88/63", "Monday-Cloudy-70/63",
                    "Tuesday-Sunny-86-75", "Wednesday-Rainy-70/52", "Thursday-Rainy-75-65",
                    "Friday-Foggy-66-46", "Saturday-Sunny-92-80"};
            ArrayList<String> forecastEntries = new ArrayList<String>
                    (Arrays.asList(dummyForecastEntries));

            //Create adapter
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_forecast, R.id.list_item_forecast_textview, forecastEntries);

            //Find ListView by Id
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            
            //Bind dummy data list to the ListView by setting the adapter
            listView.setAdapter(arrayAdapter);
            return rootView;
        }
    }
}
