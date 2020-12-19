package com.example.dictionary;

public class List_item {

    private String nameEng;
    private String nameAr ;

    public List_item(String nameEng, String nameAr){
        this.nameEng = nameEng;
        this.nameAr = nameAr ;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }


    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }
}
