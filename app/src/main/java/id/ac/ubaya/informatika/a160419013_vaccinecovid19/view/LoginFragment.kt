package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentLoginBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), ButtonLoginProfileListener {
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

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            dataBinding.profil = it

        })
    }

    override fun onButtonLoginProfile(v: View) {
        viewModel.login(txtLoginNomorHp.toString())
        if(viewModel.profileLD.value != null){
            AlertDialog.Builder(context)
                .setTitle("Berhasil")
                .setMessage("Kode Verifikasi: 123456")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtKodeVerifikasi.requestFocus()
                })
                .show()
        }
        else{
            AlertDialog.Builder(context)
                .setTitle("Gagal")
                .setMessage("Tolong Masukkan Nomor HP yang didaftarkan")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> txtKodeVerifikasi.requestFocus()
                })
                .show()
        }
    }

}