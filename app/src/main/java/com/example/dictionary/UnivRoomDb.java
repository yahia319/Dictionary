package com.example.dictionary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;

@Database(entities = Univ.class,version = 1)
public abstract class UnivRoomDb extends RoomDatabase{
    private static UnivRoomDb instance ;


    public abstract UnivDao univDao();

    //SingleTon

    public static synchronized   UnivRoomDb getInstance(Context context){
        if ( instance == null ){
            instance = Room.databaseBuilder(context.getApplicationContext(),UnivRoomDb.class,"univ_database.db").fallbackToDestructiveMigration().build();
        }// end if
        return instance;
    }// end getInstance



}//end class
