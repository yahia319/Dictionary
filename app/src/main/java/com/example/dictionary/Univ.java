package com.example.dictionary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "univ")
public class Univ {
    @PrimaryKey
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
    @ColumnInfo(name ="FRENCH_NORMALIZED")
    private String frenchNormalized;

    public Univ(String arabicNormalized, String frenchNormalized) {
        this.arabicNormalized = arabicNormalized;
        this.frenchNormalized = frenchNormalized;
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
