package com.example.inshortsclone.data.localDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inshortsclone.data.model.latestModel.News


 @Database(entities = [News::class],version = 1)
 public abstract class AppdataBase: RoomDatabase() {
    companion object{
        var appdataBase: AppdataBase?=null
        val databasename:String="news_db"

        /*-----------INSTANTIATING DATABASE AS SIGNLETON------------*/
        fun  getDatabaseInstance(context: Context): AppdataBase {
            if(appdataBase ==null){
                appdataBase = Room.databaseBuilder(context.applicationContext, AppdataBase::class.java, databasename).build()

            }
            return appdataBase as AppdataBase
        }
    }

    abstract fun appdao(): NewsDao

}