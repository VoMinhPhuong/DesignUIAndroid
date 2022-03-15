package com.example.designui.tuan4ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.designui.R;

import java.util.ArrayList;

public class ListviewActivityMainActivity extends AppCompatActivity {
    ListView listView1;
    ArrayList<Item> arrayList;
    ItemAdapter adapter;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity_main);

        listView1 = findViewById(R.id.lvwMain);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("Ca nấu lẩu, nấu mì mini", "Devang", R.drawable.ca_nau_lau));
        arrayList.add(new Item("1 KG khô gà bơ tỏi", "LTD Food", R.drawable.ga_bo_toi));
        arrayList.add(new Item("Xe cần cẩu đa năng", "Thế giới đồ chơi", R.drawable.xa_can_cau));
        arrayList.add(new Item("Đồ chơi dạng mô hình", "Thế giới đồ chơi", R.drawable.do_choi_dang_mo_hinh));
        arrayList.add(new Item("Lãnh đạo giản đơn", "Minh Long Book", R.drawable.lanh_dao_gian_don));
        arrayList.add(new Item("Hiểu lòng con trẻ", "Minh Long Book", R.drawable.hieu_long_con_tre));
        arrayList.add(new Item("Donal Trump lãnh đạo thiên tài", "Minh Long Book", R.drawable.trump_1));

        adapter = new ItemAdapter(this, R.layout.item_listview, arrayList);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected item " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}