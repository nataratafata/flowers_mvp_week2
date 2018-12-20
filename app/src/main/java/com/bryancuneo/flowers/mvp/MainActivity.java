package com.bryancuneo.flowers.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.List;

import com.bryancuneo.flowers.mvp.flowerlist.FlowerList_Presenter;
import com.bryancuneo.flowers.mvp.flowerlist.IFlowerList_Contract;
import com.bryancuneo.flowers.mvp.data.FlowerModel;
import com.bryancuneo.flowers.mvp.network.ConnectionService;
import com.bryancuneo.flowers.mvp.network.IFlower_Interacter;
import com.bryancuneo.flowers.mvp.presentation.FlowerAdapter;

public class MainActivity extends AppCompatActivity implements IFlowerList_Contract.IView_FlowerList {

    private FlowerList_Presenter flowerList_presenter;
    private IFlower_Interacter iFlower_interacter;

    private FlowerAdapter adapter;
    private RecyclerView recyclerView;

    public static File cacheDir;

    @Override
    public void _displayProgressDialog() {

    }

    @Override
    public void _flowerList(List<FlowerModel> flowerModels) {
        recyclerView = (RecyclerView) findViewById(R.id.rv_flower_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FlowerAdapter(flowerModels);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void _dismissProgressDialog() {

    }
// 1 Initialize the request object
    // 2 OnLoad of our activity, we are request data using RxJavav multithreading
    // API request: should be always on separate thread


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _initializePresenterAndCallApi();

        cacheDir = getCacheDir();
    }


    public void _initializePresenterAndCallApi(){
        iFlower_interacter = new ConnectionService();
        flowerList_presenter = new FlowerList_Presenter(iFlower_interacter);
        flowerList_presenter.onBind(this);
        flowerList_presenter.getFlowerFromAPI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flowerList_presenter.unBind();
    }
}
