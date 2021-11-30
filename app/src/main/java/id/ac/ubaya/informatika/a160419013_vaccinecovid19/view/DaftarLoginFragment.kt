package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentDaftarLoginBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DaftarLoginViewModel

class DaftarLoginFragment : Fragment(), ButtonAddProfileListener {
    private lateinit var viewModel: DaftarLoginViewModel
    private lateinit var dataBinding:FragmentDaftarLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_daftar_login, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_daftar_login,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DaftarLoginViewModel::class.java)
        dataBinding.profil = Profile("","","","","","")
        dataBinding.add = this
    }

    override fun onButtonAddProfile(v: View) {
        viewModel.daftarProfile(dataBinding.profil!!)
        Toast.makeText(v.context, "Profile Sudah Dibuat", Toast.LENGTH_SHORT).show()
        val action = DaftarLoginFragmentDirections.actionDaftarLoginFragmentToLoginFragment()
        Navigation.findNavController(v).navigate(action)
    }

}