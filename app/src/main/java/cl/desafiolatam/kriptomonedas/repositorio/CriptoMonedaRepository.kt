package cl.desafiolatam.kriptomonedas.repositorio

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import cl.desafiolatam.kriptomonedas.modelo.DataCriptoM
import cl.desafiolatam.kriptomonedas.room.DataBaseP
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CriptoMonedaRepository(var context: Context) {

    private val dbp = DataBaseP.getIntancia(context)

    fun agregar (criptoMonedas: List<DataCriptoM>)
    {
        CoroutineScope(Dispatchers.IO).launch {
            dbp.daoCripto().agregarMonedas(criptoMonedas)
        }
    }
    fun listar(): LiveData<List<DataCriptoM>>
    {
        return dbp.daoCripto().listar()
    }
    fun buscar (id:String):DataCriptoM
    {
        return  dbp.daoCripto().buscar(id)
    }






}