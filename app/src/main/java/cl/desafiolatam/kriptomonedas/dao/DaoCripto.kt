package cl.desafiolatam.kriptomonedas.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import cl.desafiolatam.kriptomonedas.modelo.DataCriptoM

@Dao
interface DaoCripto {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregarMonedas(criptoMonedas: List<DataCriptoM>)

    @Query("select id,name,changePercent24Hr,explorer,marketCapUsd,maxSupply,priceUsd,vwap24Hr,rank,supply,symbol from data_cripto")
    fun listar(): LiveData<List<DataCriptoM>>

    @Query("select id,name,changePercent24Hr,explorer,marketCapUsd,maxSupply,priceUsd,vwap24Hr,rank,supply,symbol from data_cripto where id=:id")
    fun buscar(id:String):DataCriptoM


}