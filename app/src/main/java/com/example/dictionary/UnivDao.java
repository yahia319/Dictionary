package com.example.dictionary;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UnivDao {

    @Query("SELECT * FROM univ WHERE ARABIC_NORMALIZED LIKE:arabic")
    List<Univ> getArabicTranslate(String arabic);

    @Query("SELECT * FROM univ")
    List<Univ> getAll();


    @Query("SELECT *  FROM univ WHERE FRENCH_NORMALIZED LIKE:french")
    List<Univ> getFrenchTranslate(String french);

}
