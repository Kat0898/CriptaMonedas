package cl.desafiolatam.kriptomonedas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.kriptomonedas.R
import cl.desafiolatam.kriptomonedas.databinding.ItemBinding
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import cl.desafiolatam.kriptomonedas.modelo.DataCriptoM
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class AdapterCripto : RecyclerView.Adapter<AdapterCripto.CustomViewHolder>() {






    class CustomViewHolder(itemView: View, val listener: MiListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemBinding.bind(itemView)
        fun getImageFromSymbol(symbol: String) =
            "https://static.coincap.io/assets/icons/${symbol.lowercase(Locale.getDefault())}@2x.png"



        fun bindData(dataCriptoM: DataCriptoM)
        {
            with(binding)
            {
              tvNombreItem.text = dataCriptoM.name!!
              tvPrecio.text = dataCriptoM.priceUsd!!

                Picasso.get().load(getImageFromSymbol(dataCriptoM.symbol!!)).into(imgItemSymb)

                       itemView.setOnClickListener {
                        listener.miOnClick(dataCriptoM)
                                }



            }

        }
    }

    var lista:List<DataCriptoM> = ArrayList()
    lateinit var listener: MiListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return CustomViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(criptoMonedas: List<DataCriptoM>)
    {

        lista = criptoMonedas
        notifyDataSetChanged()
    }

    interface MiListener{
        fun miOnClick(criptoMonedasItem: DataCriptoM)
    }

    fun setMiListener(listener: MiListener)
    {
        this.listener = listener
    }

}