package com.example.austinsy_velasco.babybraceletmonitor2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Baby_Braclet extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby__braclet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.baby__braclet, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        if (id == R.id.home) {
            graph.removeAllSeries();
            setTitle("Home");
            Home home = new Home();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, home).commit();
        } else if (id == R.id.sleep) {
            graph.removeAllSeries();
            setTitle("Sleep");
            First first = new First();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, first).commit();
            //GraphView graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                    new DataPoint(0, 4),
                    new DataPoint(1, 2),
                    new DataPoint(2, 1),
                    new DataPoint(3, 7),
                    new DataPoint(4, 4)
            });
            graph.addSeries(series);
            series.setTitle("foo");

            //graph.getLegendRenderer().setVisible(true);
            //graph.setPadding(0, 230,400, 700 );
        } else if (id == R.id.Temperature) {
            graph.removeAllSeries();
            setTitle("Temperature");
            Second second = new Second();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, second).commit();
            //GraphView graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                    new DataPoint(0, 1),
                    new DataPoint(1, 5),
                    new DataPoint(2, 3),
                    new DataPoint(3, 2),
                    new DataPoint(4, 6)
            });
            graph.addSeries(series2);


            series2.setTitle("bar");
            //graph.getLegendRenderer().setVisible(true);
            //graph.setPadding(0, 230,400, 700 );
        } else if (id == R.id.Pulse) {
            graph.removeAllSeries();
            setTitle("Pulse");
            Third third = new Third();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment, third).commit();
            //GraphView graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                    new DataPoint(0, 2),
                    new DataPoint(1, 1),
                    new DataPoint(2, 5),
                    new DataPoint(3, 7),
                    new DataPoint(4, 6)
            });
            graph.addSeries(series3);

            series3.setTitle("bar");
            //graph.getLegendRenderer().setVisible(true);
            //graph.setPadding(0, 230,400, 700 );
        }
        return true;
    }
}
