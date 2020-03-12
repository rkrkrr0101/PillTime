package com.example.pilltime

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbsetting(context: Context,ver:Int): SQLiteOpenHelper(context,"pilldb",null,ver) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("create table maindb (name TEXT,dt TEXT );")


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists maindb")
        onCreate(db)
    }

}