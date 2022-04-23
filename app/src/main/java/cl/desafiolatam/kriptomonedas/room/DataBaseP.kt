package cl.desafiolatam.kriptomonedas.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatam.kriptomonedas.dao.DaoCripto

//@Database(entities = [CriptoMonedasItem::class], version = 1)
abstract class DataBaseP :RoomDatabase(){
//    abstract fun daoCripto():DaoCripto
//
//    companion object
//    {
//        @Volatile
//        private var intancia : DataBaseP?= null
//
//        fun getIntancia(context: Context):DataBaseP
//        {
//            synchronized(this)
//            {
//                intancia= Room.databaseBuilder(context,
//                    DataBaseP::class.java,
//                    "proyecto_cripto")
//                    .build()
//            }
//            return intancia!!
//            }
//        }
//

    }


