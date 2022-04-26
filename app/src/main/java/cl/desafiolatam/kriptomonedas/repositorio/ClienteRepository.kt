package cl.desafiolatam.kriptomonedas.repositorio

import cl.desafiolatam.kriptomonedas.cliente.CriptoCliente
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import retrofit2.Call

class ClienteRepository {

    private val cliente = CriptoCliente.getInstancia(CriptoCliente.BASE_URL)

    fun getListaCripto() : Call<CriptoMonedas>
    {
        return  cliente.getCripto()
    }

}