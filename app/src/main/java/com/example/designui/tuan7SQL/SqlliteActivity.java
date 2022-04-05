package com.example.designui.tuan7SQL;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.designui.R;

import java.util.ArrayList;

public class SqlliteActivity extends AppCompatActivity {
    SinhVienHelper sinhVienHelper;
    ListView lv;
    ArrayList<SinhVien> sinhViens;
    SinhVienAdapter adapter;
    EditText edtTen;
    Button btnThem;
    Button btnXoa;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllite);

        anhXa();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString().trim();
                if (TextUtils.isEmpty(ten)) {
                    Toast.makeText(SqlliteActivity.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                sinhVienHelper.QueryData("INSERT INTO SinhVien VALUES(null, '" + ten + "')");
                showData();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv = sinhViens.get(position);
                flag = position;
                if(flag == position){
                    view.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogRemove(sv.getTenSV(), sv.getId());
                    }
                });
            }
        });



        sinhViens = new ArrayList<>();
        adapter = new SinhVienAdapter(this, R.layout.item_tuan7, sinhViens);
        lv.setAdapter(adapter);

        //Tạo database
        sinhVienHelper = new SinhVienHelper(this, "SinhVien.sqlite", null, 1);

        // Tạo bảng
        sinhVienHelper.QueryData("CREATE TABLE IF NOT EXISTS SinhVien(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TenSV VARCHAR(200))");
//        sinhVienHelper.QueryData("INSERT INTO SinhVien VALUES(null, 'Đỗ Anh Bôn')");
//        sinhVienHelper.QueryData("INSERT INTO SinhVien VALUES(null, 'Hoàng Quốc Cường')");

        //Hiển thị dữ liệu
        showData();

    }

    private void showData() {
        Cursor dataSV = sinhVienHelper.GetData("SELECT * FROM SinhVien");
        sinhViens.clear();
        while (dataSV.moveToNext()) {
            int id = dataSV.getInt(0);
            String ten = dataSV.getString(1);
            sinhViens.add(new SinhVien(id, ten));
        }
        adapter.notifyDataSetChanged();
    }

    private void DialogRemove(String ten, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn xóa "+ ten +" không ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sinhVienHelper.QueryData("DELETE FROM SinhVien WHERE id = '"+id+"'");
                showData();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void anhXa() {
        lv = findViewById(R.id.lvwMain);
        edtTen = findViewById(R.id.edtTen);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
    }
}