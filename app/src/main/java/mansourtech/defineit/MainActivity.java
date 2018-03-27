package mansourtech.defineit;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate: Starting.");
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager =(ViewPager)findViewById(R.id.container);
        setupViewPager(viewPager);

        Button btnSearch = (Button)findViewById(R.id.btnSearch);
        Button btnAdd = (Button)findViewById(R.id.btnAdd);

        //the word which is to be searched about shall be entered here
        TextView searchWord = (TextView)findViewById(R.id.editText5);

        //this should show the ented word's definition
        TextView searchDefinition = (TextView)findViewById(R.id.editText7);
        //searchDefinition.setEnabled(false); this should make it not editable but it gives an error

        //the word which is to be added to your database will be entered here
        TextView addWord = (TextView)findViewById(R.id.editText4);

        //the entered word's definition should be entered here to be added to the database too
        TextView addDefinition = (TextView)findViewById(R.id.editText6);
        //addDefinition.setEnabled(true);  this should make it not editable but it gives an error

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        //This makes an error too...
        /*
        btnSearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Search about the word in editText5 and show the results in editText7
                Toast.makeText(getApplicationContext(), "Search button clicked!", Toast.LENGTH_LONG).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add button clicked!", Toast.LENGTH_LONG).show();
                //Add the word in editText4 and it's definition in editText6 to your database
            }
        });

*/

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new SearchActivity(), "Search");
        adapter.addFragment(new AddActivity(), "Add");
        adapter.addFragment(new ShowActivity(),"Show Words");
        viewPager.setAdapter(adapter);
    }
}
