package cl.desafiolatam.kriptomonedas.modelo


import com.google.gson.annotations.SerializedName

data class CriptoMonedas(
    @SerializedName("data")
    val data: List<DataCriptoM>
)