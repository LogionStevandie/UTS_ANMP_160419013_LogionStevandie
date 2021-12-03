package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentHomeBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentVaccineBinding
import kotlinx.android.synthetic.main.fragment_vaccine.*

class VaccineFragment : Fragment(), ButtonVaccineCheckListener,ButtonVaccineConfirmListener {
    private lateinit var dataBinding: FragmentVaccineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_vaccine, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_vaccine,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.check = this
        dataBinding.confirm = this

        /*btnKonfirmasi.setOnClickListener {
            val action = VaccineFragmentDirections.actionVaccineFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
    }

    override fun onButtonVaccineCheck(v: View) {
        Toast.makeText(v.context, "NIK dan Nama tersedia", Toast.LENGTH_SHORT).show()
    }

    override fun onButtonVaccineConfirm(v: View) {
        Toast.makeText(v.context, "Pendaftaran sudah dilakukan", Toast.LENGTH_SHORT).show()
        val action = VaccineFragmentDirections.actionVaccineFragmentToHomeFragment()
        Navigation.findNavController(v).navigate(action)
    }

}