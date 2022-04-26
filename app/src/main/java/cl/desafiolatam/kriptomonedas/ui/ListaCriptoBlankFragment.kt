package cl.desafiolatam.kriptomonedas.ui

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.kriptomonedas.R
import cl.desafiolatam.kriptomonedas.adapter.AdapterCripto
import cl.desafiolatam.kriptomonedas.databinding.FragmentListaCriptoBlankBinding
import cl.desafiolatam.kriptomonedas.modelo.CriptoMonedas
import cl.desafiolatam.kriptomonedas.modelo.DataCriptoM
import cl.desafiolatam.kriptomonedas.viewModel.ViewCripto

class ListaCriptoBlankFragment : Fragment() {
    lateinit var binding:FragmentListaCriptoBlankBinding
    private val viewModel by activityViewModels<ViewCripto>()
    private val adapter = AdapterCripto()
    lateinit var sh :SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaCriptoBlankBinding.inflate(layoutInflater)
        sh = requireActivity().applicationContext.getSharedPreferences(getString(R.string.userd),MODE_PRIVATE)


        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
           btnIngresarList.setOnClickListener {
               val user = edtUsuarioList.text.toString()
               val commit = sh.edit().putString(getString(R.string.bienvenido), user).commit()

               Toast.makeText(requireContext(), getString(R.string.registro), Toast.LENGTH_LONG).show()
           }



            rvkRIPTO.adapter = adapter
            rvkRIPTO.layoutManager = layoutManager

        }

        adapter.setMiListener(object : AdapterCripto.MiListener{
            override fun miOnClick(criptoMonedasItem: DataCriptoM) {
                viewModel.updateMonedas(criptoMonedasItem.id)
                Navigation.findNavController(requireView()).navigate(R.id.action_listaCriptoBlankFragment_to_detalleCriptoBlankFragment)
            }

        })

        viewModel.moneCrip.observe(viewLifecycleOwner, Observer {

            adapter.updateData(it)
        })

        return binding.root



    }


}