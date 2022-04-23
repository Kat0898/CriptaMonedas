package cl.desafiolatam.kriptomonedas.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.desafiolatam.kriptomonedas.cliente.CriptoCliente
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import cl.desafiolatam.kriptomonedas.modelo.Data
import cl.desafiolatam.kriptomonedas.repositorio.ClienteRepository
import cl.desafiolatam.kriptomonedas.repositorio.CriptoMonedaRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewCripto (application: Application) : AndroidViewModel(application) {


    private val clienteRep = ClienteRepository()
    private  val criptoRep = CriptoMonedaRepository(getApplication())
    //val monedas= criptoRep.listar()
    val monedas = MutableLiveData<CriptoMonedas>()
    val moneda = MutableLiveData<Data>()



    ///error adapter coneccion


    fun getData() {
//        CoroutineScope(Dispatchers.IO).launch {
//          clienteRep.getListaCripto().enqueue(object : Callback<CriptoMonedas>{
//              override fun onResponse(
//                  call: Call<CriptoMonedas>,
//                  response: Response<CriptoMonedas>
//              ) { response.body().let {
//                  Log.d("kat",response.body().toString())
//                  criptoRep.agregar(it!!)
//              }
//
//              }
//
//              override fun onFailure(call: Call<CriptoMonedas>, t: Throwable) {
//                  Log.e("CALL", t.message.toString())
//              }
//          })
//        }










       val service = CriptoCliente.getInstancia(CriptoCliente.BASE_URL)
       service.getCripto().enqueue(object : Callback<CriptoMonedas> {
           override fun onResponse(call: Call<CriptoMonedas>, response: Response<CriptoMonedas>) {
                response.body().let {
                    Log.d("kat",response.body().toString())
                   monedas.postValue(it)
               }
           }

           override fun onFailure(call: Call<CriptoMonedas>, t: Throwable) {
               Log.e("CALL", t.message.toString())
           }

       })
    }

//    fun updateMoneda(id:String)
//    {
//        CoroutineScope(Dispatchers.IO).launch {
//            moneda.postValue(criptoRep.buscar(id))
//        }
//    }

    fun updateMoneda(moneda: Data) {
        this.moneda.value = moneda
    }
    fun updateMonedas(monedas:CriptoMonedas) {
        this.monedas.value = monedas
    }


}