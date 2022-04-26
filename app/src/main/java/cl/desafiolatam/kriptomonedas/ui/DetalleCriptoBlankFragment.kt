package cl.desafiolatam.kriptomonedas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.kriptomonedas.R
import cl.desafiolatam.kriptomonedas.databinding.FragmentDetalleCriptoBlankBinding
import cl.desafiolatam.kriptomonedas.viewModel.ViewCripto
import com.squareup.picasso.Picasso
import java.util.*


class DetalleCriptoBlankFragment : Fragment() {

    lateinit var binding: FragmentDetalleCriptoBlankBinding
    private val viewModel by activityViewModels<ViewCripto>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding = FragmentDetalleCriptoBlankBinding.inflate(layoutInflater)


        fun getImageFromSymbol(symbol: String) =
            "https://static.coincap.io/assets/icons/${symbol.lowercase(Locale.getDefault())}@2x.png"
        viewModel.moneda.observe(viewLifecycleOwner, Observer {
            with(binding)
            {
              Picasso.get().load(getImageFromSymbol(it.symbol!!)).into(imgSymbolDetalle)
                tvNombreDetalle.text = it.name!!
                tvDetalle1Rank.text=it.rank!!
                tvDetalle2marketCapUsd.text = it.marketCapUsd!!
                tvDetalle3Vwap24Hr.text = it.vwap24Hr!!
                tvDetalle4ChangePercent24Hr.text = it.changePercent24Hr!!
                tvDetalleValor.text = it.priceUsd!!

            }

        })



        return binding.root
    }

}