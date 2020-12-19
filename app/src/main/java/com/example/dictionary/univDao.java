package com.example.dictionary;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface univDao {

    @Query("SELECT * FROM univ WHERE ARABIC_NORMALIZED LIKE:arabic")
ArrayList<univ> getArabicTranslate(String arabic);



    @Query("SELECT * FROM univ WHERE FRENCH_NORMALIZED LIKE:french")
    ArrayList<univ> getFrenchTranslate(String french);

}
