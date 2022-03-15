package com.example.designui.tuan5DuLieu;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.designui.R;

import java.util.List;

public class CakeAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Cake> listCake;

    public CakeAdapter(Context context, int layout, List<Cake> listCake) {
        this.context = context;
        this.layout = layout;
        this.listCake = listCake;
    }

    @Override
    public int getCount() {
        return listCake.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtTenSP, txtNote, txtMoney;
        ImageView hinh;
        ImageButton btnDetail;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.txtTenSP = convertView.findViewById(R.id.txtName);
            viewHolder.txtNote = convertView.findViewById(R.id.txtNote);
            viewHolder.txtMoney = convertView.findViewById(R.id.txtNote);
            viewHolder.hinh = convertView.findViewById(R.id.imgHinh);
            viewHolder.btnDetail = convertView.findViewById(R.id.btnDetail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtTenSP.setText(listCake.get(position).tenSP);
        viewHolder.txtNote.setText(listCake.get(position).ghiChu);
        viewHolder.txtMoney.setText(listCake.get(position).giaTien);
        viewHolder.hinh.setImageResource(listCake.get(position).hinhAnh);

        return  convertView;
    }
}
