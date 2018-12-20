package com.bryancuneo.flowers.mvp.flowerlist;

import java.util.List;

import com.bryancuneo.flowers.mvp.data.FlowerModel;

public interface IFlowerList_Contract {

    interface IView_FlowerList {
        // methods which will be called by the presenter by using view instance
        void _displayProgressDialog();
        void _flowerList(List<FlowerModel> flowerModels);
        void _dismissProgressDialog();
    }


    interface IPresenter_FlowerList {
     // methods to be called in the view by using the presenter instance

        void onBind(IView_FlowerList iView_flowerList);
        void getFlowerFromAPI();
        void unBind();
    }
}
