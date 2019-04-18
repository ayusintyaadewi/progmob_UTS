package com.example.asus.senjatakhasindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    private ArrayList<Senjata> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(SenjataData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Senjata> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedSenjata(Senjata senjata) {
        Toast.makeText(this, "Kamu memilih " + senjata.getNama(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListSenjataAdapter listSenjataAdapter = new ListSenjataAdapter(this);
        listSenjataAdapter.setListSenjata(list);
        rvCategory.setAdapter(listSenjataAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedSenjata(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridSenjataAdapter gridSenjataAdapter = new GridSenjataAdapter(this);
        gridSenjataAdapter.setListSenjata(list);
        rvCategory.setAdapter(gridSenjataAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedSenjata(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewSenjataAdapter cardViewSenjataAdapter = new CardViewSenjataAdapter(this);
        cardViewSenjataAdapter.setListSenjata(list);
        rvCategory.setAdapter(cardViewSenjataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

//    private RecyclerView rvCategory;
//    private ArrayList<Senjata> list = new ArrayList<>();
//    private String title = "Mode List";
//    final String STATE_TITLE = "state_string";
//    final String STATE_LIST = "state_list";
//    final String STATE_MODE = "state_mode";
//    int mode;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        rvCategory = findViewById(R.id.rv_category);
//        rvCategory.setHasFixedSize(true);
//
//        list.addAll(SenjataData.getListData());
//        showRecyclerList();
//    }
//
//    private void showRecyclerList(){
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        ListSenjataAdapter listSenjataAdapter = new ListSenjataAdapter(this);
//        listSenjataAdapter.setListSenjata(list);
//        rvCategory.setAdapter(listSenjataAdapter);
//    }
//
//    private void showRecyclerGrid(){
//        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
//        GridSenjataAdapter gridSenjataAdapter = new GridSenjataAdapter(this);
//        gridSenjataAdapter.setListSenjata(list);
//        rvCategory.setAdapter(gridSenjataAdapter);
//    }
//
//    private void showRecyclerCardView(){
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        CardViewSenjataAdapter cardViewSenjataAdapter = new CardViewSenjataAdapter(this);
//        cardViewSenjataAdapter.setListSenjata(list);
//        rvCategory.setAdapter(cardViewSenjataAdapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_list:
//                setActionBarTitle("Mode List");;
//                showRecyclerList();
//                break;
//            case R.id.action_grid:
//                setActionBarTitle("Mode Grid");
//                showRecyclerGrid();
//                break;
//            case R.id.action_cardview:
//                setActionBarTitle("Mode CardView");
//                showRecyclerCardView();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void setActionBarTitle(String title){
//        getSupportActionBar().setTitle(title);
//    }
}
