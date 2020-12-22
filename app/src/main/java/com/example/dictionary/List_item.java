package com.example.dictionary;

public class List_item {

    private String nameFr;
    private String nameAr ;

    public List_item(String nameFr, String nameAr){
        this.nameFr = nameFr;
        this.nameAr = nameAr ;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }


    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }
}
