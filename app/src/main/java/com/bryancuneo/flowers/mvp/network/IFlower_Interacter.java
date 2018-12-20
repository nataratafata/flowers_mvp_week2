package com.bryancuneo.flowers.mvp.network;

import java.util.List;

import com.bryancuneo.flowers.mvp.data.FlowerModel;

import io.reactivex.Observable;

public interface IFlower_Interacter {

    Observable<List<FlowerModel>> getFlowerList();

}
