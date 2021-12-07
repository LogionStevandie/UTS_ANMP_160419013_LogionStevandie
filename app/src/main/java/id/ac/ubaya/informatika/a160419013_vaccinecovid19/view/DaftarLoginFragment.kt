package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
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
import kotlinx.android.synthetic.main.fragment_daftar_login.view.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*
import kotlin.random.Random

class DaftarLoginFragment : Fragment(), ButtonAddProfileListener, DateClickListener, DatePickerDialog.OnDateSetListener {
    private lateinit var viewModel: DaftarLoginViewModel
    private lateinit var dataBinding:FragmentDaftarLoginBinding
    var year = 0
    var month = 0
    var day = 0

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
        dataBinding.date = this
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

    override fun onDateClick(v: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        activity?.let {
                it -> DatePickerDialog(it,this,year,month,day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Calendar.getInstance().let {
            it.set(year,month,dayOfMonth)
            dataBinding.root.txtDaftarTanggalLahir.setText(
                dayOfMonth.toString().padStart(2,'0') + "-" +
                        month.toString().padStart(2,'0') + "-" +
                        year.toString().padStart(2,'0'))
            this.year = year
            this.month = month
            this.day = dayOfMonth
        }
    }

}