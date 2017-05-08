package com.example.dell.testviewpagerxlistdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by DELL on 2017/4/21.
 */

public class MyAdapter extends BaseAdapter {

    private List<NewsBean.ListBean> list;
    private Context context;

    public MyAdapter(List<NewsBean.ListBean> list, Context context){

        this.list = list;
        this.context = context;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType() == 1){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        SecondHolder secondHolder = null;
        int type = getItemViewType(position);
        if (convertView == null){
            if (type == 0){

                holder = new ViewHolder();
                convertView = View.inflate(context,R.layout.oneimage_item,null);
                holder.textViewTitle = (TextView) convertView.findViewById(R.id.oneitem_text_title);
                holder.textViewDate = (TextView) convertView.findViewById(R.id.onitem_text_date);
                holder.imageView = (ImageView) convertView.findViewById(R.id.oneitem_image);

                convertView.setTag(holder);
            }else {

                secondHolder = new SecondHolder();
                convertView = View.inflate(context,R.layout.second_item,null);

                secondHolder.textViewTitle = (TextView) convertView.findViewById(R.id.second_text_title);
                secondHolder.textViewDate = (TextView) convertView.findViewById(R.id.second_text_date);
                secondHolder.image_left = (ImageView) convertView.findViewById(R.id.second_image_left);
                secondHolder.image_mid = (ImageView) convertView.findViewById(R.id.second_image_mid);
                secondHolder.image_right = (ImageView) convertView.findViewById(R.id.second_image_right);

                convertView.setTag(secondHolder);

            }
        }else {

            if (type == 0){
                holder = (ViewHolder) convertView.getTag();
            }else {
                secondHolder = (SecondHolder) convertView.getTag();
            }

        }

        if (type == 0){
            holder.textViewTitle.setText(list.get(position).getTitle());
            holder.textViewDate.setText(list.get(position).getDate());
            ImageLoader.getInstance().displayImage(list.get(position).getPic(),holder.imageView);
        }else {

            secondHolder.textViewTitle.setText(list.get(position).getTitle());
            secondHolder.textViewDate.setText(list.get(position).getDate());
            String[] arr = list.get(position).getPic().split("\\|");
            ImageLoader.getInstance().displayImage(arr[0],secondHolder.image_left);
            ImageLoader.getInstance().displayImage(arr[1],secondHolder.image_mid);
            ImageLoader.getInstance().displayImage(arr[2],secondHolder.image_right);

        }


        return convertView;
    }


    class ViewHolder{
        TextView textViewTitle;
        TextView textViewDate;
        ImageView imageView;
    }
    class SecondHolder{
        TextView textViewTitle;
        TextView textViewDate;
        ImageView image_left;
        ImageView image_mid;
        ImageView image_right;
    }
}
