package com.baway.listviewandcheckbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by peng on 2017/9/5.
 */

public class MyAdapter extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public MyAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v;
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            v = View.inflate(context, R.layout.item, null);
            holder.cb = v.findViewById(R.id.cb);
            holder.tv = v.findViewById(R.id.tv);
            v.setTag(holder);
        } else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        Bean bean = list.get(i);
        holder.cb.setChecked(bean.isChecked());
        holder.tv.setText(bean.getStr());


        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                singleChoice(i);
                mutilChoice(i);
            }
        });
        return v;
    }

    class ViewHolder {
        CheckBox cb;
        TextView tv;

    }

    /**
     * 多选
     *
     * @param position
     */
    private void mutilChoice(int position) {
        Bean bean = list.get(position);
        bean.setChecked(true);
        notifyDataSetChanged();
    }

    /*
    *单选
     */
    private void singleChoice(int position) {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(false);
        }
        Bean bean = list.get(position);
        bean.setChecked(true);
        notifyDataSetChanged();
    }

    /**
     * 全选
     */
    public void all() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(true);
        }
        notifyDataSetChanged();
    }

    /**
     * 反选
     */
    public void reverse() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
//            if (b.isChecked()) {
//                b.setChecked(false);
//            } else {
//                b.setChecked(true);
//            }
            b.setChecked(!b.isChecked());
        }
        notifyDataSetChanged();
    }

    /**
     * 取消选择
     */
    public void cancel() {
        for (int i = 0; i < list.size(); i++) {
            Bean b = list.get(i);
            b.setChecked(false);
        }
        notifyDataSetChanged();
    }
}
