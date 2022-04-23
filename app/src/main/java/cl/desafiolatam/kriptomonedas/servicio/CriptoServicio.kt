package cl.desafiolatam.kriptomonedas.servicio

import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import retrofit2.Call
import retrofit2.http.GET

interface CriptoServicio {
    @GET("assets")
    fun getCripto():Call<CriptoMonedas>
}