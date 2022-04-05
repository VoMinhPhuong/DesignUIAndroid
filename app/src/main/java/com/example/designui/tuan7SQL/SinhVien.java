package com.example.designui.tuan7SQL;

public class SinhVien {
    private int id;
    private String tenSV;

    public SinhVien(int id, String tenSV) {
        this.id = id;
        this.tenSV = tenSV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }
}
