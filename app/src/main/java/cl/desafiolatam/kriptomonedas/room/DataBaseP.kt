package cl.desafiolatam.kriptomonedas.room

import android.content.Context
import androidx.room.*
import cl.desafiolatam.kriptomonedas.dao.DaoCripto
import cl.desafiolatam.kriptomonedas.modelo.DataCriptoM


@Database(entities = [DataCriptoM::class], version = 1)

abstract class DataBaseP :RoomDatabase(){
    abstract fun daoCripto():DaoCripto

    companion object
    {
        @Volatile
        private var intancia : DataBaseP?= null

        fun getIntancia(context: Context):DataBaseP

        { if (intancia == null)
            {
            synchronized(this)
            {
                intancia= Room.databaseBuilder(context,
                    DataBaseP::class.java,
                    "proyecto_cripto")
                    .build()
                }

                }
            return intancia!!
            }
        }




    }


