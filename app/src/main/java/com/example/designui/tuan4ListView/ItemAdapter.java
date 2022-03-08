package com.example.designui.tuan4ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.designui.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Item> itemList;

    public ItemAdapter(Context context, int layout, List<Item> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTenSP, txtTenShop;
        ImageView imgHinh;
        Button btnChat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            //Ánh xạ
            viewHolder.txtTenSP = convertView.findViewById(R.id.txtName);
            viewHolder.txtTenShop = convertView.findViewById(R.id.txtTenShop);
            viewHolder.imgHinh = convertView.findViewById(R.id.imgHinh);
            viewHolder.btnChat =convertView.findViewById(R.id.btnChat);
            View finalConvertView = convertView;
            viewHolder.btnChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(finalConvertView.getContext(), "Selected button", Toast.LENGTH_LONG).show();
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Gán giá trị
        viewHolder.txtTenSP.setText(itemList.get(position).tenSP);
        viewHolder.txtTenShop.setText(itemList.get(position).tenShop);
        viewHolder.imgHinh.setImageResource(itemList.get(position).hinhAnh);
        return convertView;
    }
}
