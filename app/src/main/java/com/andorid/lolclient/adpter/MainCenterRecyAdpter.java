package com.andorid.lolclient.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andorid.lolclient.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/9/5.
 */
public class MainCenterRecyAdpter extends RecyclerView.Adapter<MainCenterRecyAdpter.ViewHolder> {
    private List<String> imguriList = null;
    private Context context;

    public MainCenterRecyAdpter(List<String> imguri, Context context) {
        this.imguriList = imguri;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.main_center_item, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String uri = imguriList.get(position);
        if (!"".equals(uri))
            Glide.with(context).load(uri).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.main_center_imgview)
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.main_center_imgview);
        }
    }
}
