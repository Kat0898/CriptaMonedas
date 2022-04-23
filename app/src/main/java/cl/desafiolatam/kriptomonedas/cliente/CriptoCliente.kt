package cl.desafiolatam.kriptomonedas.cliente

import cl.desafiolatam.kriptomonedas.servicio.CriptoServicio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CriptoCliente {

    companion object{
        const val BASE_URL ="https://api.coincap.io/v2/"
        private var cliente: Retrofit? = null

        fun getInstancia(url:String) : CriptoServicio
        {
            if(cliente == null)
            {
                cliente = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return cliente!!.create(CriptoServicio::class.java)
        }
    }
}