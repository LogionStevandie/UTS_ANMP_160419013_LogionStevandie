package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentLoginBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Global
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlin.math.log

class LoginFragment : Fragment(), ButtonVerificationProfileListener,ButtonGoToDaftarListener,ButtonGoToMainListener {
    private lateinit var viewModel: LoginViewModel
    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.selectAll()
        dataBinding.profil = Profile("","","","","","","")
        dataBinding.verif = this
        dataBinding.daftar = this
        dataBinding.login = this

    }

    /*fun observerViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            dataBinding.profil = it

        })
    }*/

    override fun onButtonVerificationProfile(v: View) {
        var dapat = false
        for(item in viewModel.profileListLD.value!!){
            if (item.phoneNumber == dataBinding.profil!!.phoneNumber){
                AlertDialog.Builder(context)
                    .setTitle("Berhasil")
                    .setMessage("Kode Verifikasi: ${item.kodeVerifikasi}")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtKodeVerifikasi.requestFocus()
                    })
                    .show()
                Global.nomorHP = dataBinding.profil!!.phoneNumber
                dapat = true
            }
        }
        if (!dapat){
            AlertDialog.Builder(context)
                .setTitle("Gagal")
                .setMessage("Tolong Masukkan Nomor HP yang didaftarkan")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtLoginNomorHp.requestFocus()
                })
                .show()
        }
    }

    override fun onButtonGoToDaftar(v: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToDaftarLoginFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonGoToMain(v: View) {
        var dapat = false
        for(item in viewModel.profileListLD.value!!){
            if (item.kodeVerifikasi == dataBinding.profil!!.kodeVerifikasi && item.phoneNumber == dataBinding.profil!!.phoneNumber){
                AlertDialog.Builder(context)
                    .setTitle("Berhasil")
                    .setMessage("Login Nomor dan Kode Verifikasi Berhasil")
                    .setPositiveButton("OK", DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        val action = LoginFragmentDirections.actionLoginFragmentToMainActivity()
                        Navigation.findNavController(v).navigate(action)
                    })
                    .show()
                Global.nomorHP = dataBinding.profil!!.phoneNumber
                dapat = true
            }
        }
        if (!dapat){
            AlertDialog.Builder(context)
                .setTitle("Gagal")
                .setMessage("Tolong Masukkan Kode Verifikasi yang benar")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtKodeVerifikasi.requestFocus()
                })
                .show()
        }

    }

}