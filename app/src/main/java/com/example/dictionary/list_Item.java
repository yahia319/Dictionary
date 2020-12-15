package com.example.dictionary;

public class list_Item {

    private String nameEng;
    private String nameAr ;

    public list_Item(String nameEng,String nameAr){
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
