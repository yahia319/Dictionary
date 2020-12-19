package com.example.dictionary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class univ {

    @ColumnInfo(name = "ID")
    private int id ;
    @ColumnInfo(name = "ARABIC")
    private String arabic;
    @ColumnInfo(name = "FRENCH")
    private String french;
    @ColumnInfo(name = "ENGLISH")
    private String english;
    @ColumnInfo(name = "ARABIC_NORMALIZED")
    private String  arabicNormalized;
    @ColumnInfo(name = "FRENCH_NORMALIZED")
    private String frenchNormalized;

    public univ(String arabicNormalized, String frenchNormalized) {
        this.arabic = arabicNormalized;
        this.french = frenchNormalized;
    }

    public int getId() {
        return id;
    }

    public String getArabic() {
        return arabic;
    }

    public String getFrench() {
        return french;
    }

    public String getEnglish() {
        return english;
    }

    public String getArabicNormalized() {
        return arabicNormalized;
    }

    public String getFrenchNormalized() {
        return frenchNormalized;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
