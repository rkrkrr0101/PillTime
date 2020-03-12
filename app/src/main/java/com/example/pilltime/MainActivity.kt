package com.example.pilltime

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity()  {


    //데이터베이스 생성및 세팅




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainview.setHasFixedSize(true)
        mainview.layoutManager=LinearLayoutManager(this)
        val dbset=dbsetting(this,1)
        val db=dbset.writableDatabase
        var cursor:Cursor=db.rawQuery("select * from maindb",null)
        var i:Int=0
        var dbdt= arrayOfNulls<String>(cursor.getCount())
        var dbname=arrayOfNulls<String>(cursor.getCount())
        while (cursor.moveToNext()){
            dbdt[i]=cursor.getString(0)
            dbname[i]=cursor.getString(1)
            i=i+1
        }
        mainview.adapter=recyviewAdap(dbdt,dbname,cursor.getCount())
        Toast.makeText(this,i.toString(),Toast.LENGTH_LONG).show()



        //메인뷰 어댑터연결하고 레이아웃세팅



        dayhourbutton.setOnClickListener {

            try {
                insert(dayhourbutton.text.toString(),db )
            }catch (e:Exception){
                Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show()
            }
        }
        sixhourButton.setOnClickListener {
            //insert(sixhourButton.text.toString(),db )
        }
    }

    fun insert(name:String,maindb:SQLiteDatabase){
        val dt= LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYMMDDhhmmss"))
        maindb.execSQL("insert into maindb values('$name','$dt')   ")
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
        //위에 커서질하는거 따로뺴서 여기도넣어서 갱신
    }


}
