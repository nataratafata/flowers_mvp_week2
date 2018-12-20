package com.bryancuneo.flowers.mvp.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import com.bryancuneo.flowers.mvp.data.FlowerModel;

public interface IRequestInterface {
    // GET request, PUT,
    // [ JSON ARRAY = LIST
    // { JSON OBJECT : Object


    @GET(API_Request.API_FLOWERS_LIST)
    Observable<List<FlowerModel>> getFlowerList();
}
