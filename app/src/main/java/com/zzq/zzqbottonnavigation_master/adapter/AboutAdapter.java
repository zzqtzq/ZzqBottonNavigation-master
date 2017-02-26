package com.zzq.zzqbottonnavigation_master.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zzq.zzqbottonnavigation_master.R;
import com.zzq.zzqbottonnavigation_master.entity.AboutEntity;

/**
 * Created by 志强 on 2017.2.15.
 */

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {

    private AboutEntity aboutEntity;
    private Context mContext;
    private View v;

    public AboutAdapter(AboutEntity aboutEntity, Context mContext) {
        this.aboutEntity = aboutEntity;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //元素赋值
        holder.name.setText(aboutEntity.getStories().get(position).getTitle());
        Glide.with(mContext).load(aboutEntity.getStories().get(position).getImages().get(0)).error(R.drawable.ic_link_white_24dp).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return aboutEntity == null ? 0 : aboutEntity.getStories().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView pic;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) v.findViewById(R.id.name);
            pic = (ImageView) v.findViewById(R.id.pic);
        }
    }
}
