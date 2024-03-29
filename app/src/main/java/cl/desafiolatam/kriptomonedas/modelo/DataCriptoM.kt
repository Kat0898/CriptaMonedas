package cl.desafiolatam.kriptomonedas.modelo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "data_cripto")
data class DataCriptoM(
    @SerializedName("changePercent24Hr")
    val changePercent24Hr: String?,
    @SerializedName("explorer")
    val explorer: String?,
    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("marketCapUsd")
    val marketCapUsd: String?,
    @SerializedName("maxSupply")
    val maxSupply: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("priceUsd")
    val priceUsd: String?,
    @SerializedName("rank")
    val rank: String?,
    @SerializedName("supply")
    val supply: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("volumeUsd24Hr")
    val volumeUsd24Hr: String?,
    @SerializedName("vwap24Hr")
    val vwap24Hr: String?
)