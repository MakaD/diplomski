package com.marinadamnjanovic.dao.dto;

public class OdmorDto {

    private int id;
    private String povod, datumOd, datumDo;

    public OdmorDto(int id, String povod, String datumOd, String datumDo) {
        this.id = id;
        this.povod = povod;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public OdmorDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPovod() {
        return povod;
    }

    public void setPovod(String povod) {
        this.povod = povod;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    @Override
    public String toString() {
        return "OdmorDto{" +
                "id=" + id +
                ", povod='" + povod + '\'' +
                ", datumOd='" + datumOd + '\'' +
                ", datumDo='" + datumDo + '\'' +
                '}';
    }
}
