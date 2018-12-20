package com.bryancuneo.flowers.mvp.flowerlist;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import com.bryancuneo.flowers.mvp.data.FlowerModel;
import com.bryancuneo.flowers.mvp.network.IFlower_Interacter;

public class FlowerList_Presenter implements IFlowerList_Contract.IPresenter_FlowerList {

    private IFlowerList_Contract.IView_FlowerList iView_flowerList;
    private IFlower_Interacter iFlower_interacter;


    public FlowerList_Presenter(IFlower_Interacter iFlower_interacter) {
        this.iFlower_interacter = iFlower_interacter;
    }

    @Override
    public void onBind(IFlowerList_Contract.IView_FlowerList iView_flowerList) {
        this.iView_flowerList = iView_flowerList;
    }

    @Override
    public void getFlowerFromAPI() {
        iFlower_interacter.getFlowerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FlowerModel>>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<FlowerModel> flowerModels) {
                        iView_flowerList._flowerList(flowerModels);
                    }
                });
    }


    @Override
    public void unBind() {
        this.iView_flowerList =null;
    }
}
