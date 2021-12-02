package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.app.AlertDialog
import android.content.DialogInterface
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
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Global
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DaftarLoginViewModel
import kotlinx.android.synthetic.main.fragment_daftar_login.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlin.random.Random

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
        viewModel.selectAll()
        dataBinding.profil = Profile("","","","","","", Random.nextInt(100000, 999999).toString())
        dataBinding.add = this
    }

    override fun onButtonAddProfile(v: View) {
        var dapat = false
        for(item in viewModel.profileListLD.value!!){
            if (item.phoneNumber == dataBinding.profil!!.phoneNumber){
                AlertDialog.Builder(context)
                        .setTitle("Gagal")
                        .setMessage("Nomor HP sudah terdaftar")
                        .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtDaftarNomorTelepon.requestFocus()
                        })
                        .show()
                dapat = true
            }
        }
        if (!dapat){
            viewModel.daftarProfile(dataBinding.profil!!)
            Toast.makeText(v.context, "Profile Sudah Dibuat", Toast.LENGTH_SHORT).show()
            val action = DaftarLoginFragmentDirections.actionDaftarLoginFragmentToLoginFragment()
            Navigation.findNavController(v).navigate(action)

        }
    }

}