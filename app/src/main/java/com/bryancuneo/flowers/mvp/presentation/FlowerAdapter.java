package com.bryancuneo.flowers.mvp.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryancuneo.flowers.mvp.R;
import com.bryancuneo.flowers.mvp.data.FlowerModel;
import com.bryancuneo.flowers.mvp.network.IRequestInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {


    private List<FlowerModel> flowerModelList;

    public FlowerAdapter(List<FlowerModel> flowerModelList) {
        this.flowerModelList = flowerModelList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(flowerModelList.get(position).getName());
        holder.tvPrice.setText(flowerModelList.get(position).getPrice().toString());
        holder.tvInstructions.setText(flowerModelList.get(position).getInstructions());

        String url = "http://services.hanselandpetal.com/photos/" + flowerModelList.get(position).getPhoto();
        Picasso.get().load(url).resize(50, 50).centerCrop().into(holder.ivFlower);
    }

    @Override
    public int getItemCount() {
        return flowerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFlower;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvInstructions;
        public ViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tv_name);
            tvInstructions = view.findViewById(R.id.tv_instructions);
            tvPrice = view.findViewById(R.id.tv_price);
            ivFlower = view.findViewById(R.id.iv_flower);
        }
    }
}
