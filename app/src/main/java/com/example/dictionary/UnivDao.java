package com.example.dictionary;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface UnivDao {

    @Query("SELECT * FROM univ WHERE ARABIC_NORMALIZED LIKE:arabic")
    ArrayList<Univ> getArabicTranslate(String arabic);



    @Query("SELECT * FROM univ WHERE FRENCH_NORMALIZED LIKE:french")
    ArrayList<Univ> getFrenchTranslate(String french);

}
