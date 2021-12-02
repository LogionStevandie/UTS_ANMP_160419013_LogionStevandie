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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentLoginBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentProfileDetailBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Global
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.LoginViewModel
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.ProfileDetailViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile_detail.*

class ProfileDetailFragment : Fragment(), ButtonEditProfileListener {
    private lateinit var viewModel: ProfileDetailViewModel
    private lateinit var dataBinding: FragmentProfileDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile_detail, container, false)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_detail, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileDetailViewModel::class.java)
        viewModel.fetch(Global.nomorHP)

        dataBinding.edit = this

        /*btnSave.setOnClickListener {
            val action = ProfileDetailFragmentDirections.actionProfileDetailFragmentToItemProfile()
            Navigation.findNavController(it).navigate(action)
        }*/

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            dataBinding.profil = it
        })
    }

    override fun onButtonEditProfile(v: View, obj: Profile) {
        viewModel.update(obj.name,obj.negara,obj.nik,obj.tanggal_lahir,obj.email,obj.phoneNumber)
        Toast.makeText(v.context,"Profile Updated",Toast.LENGTH_SHORT).show()
        val action = ProfileDetailFragmentDirections.actionProfileDetailFragmentToItemProfile()
        Navigation.findNavController(v).navigate(action)
    }

}