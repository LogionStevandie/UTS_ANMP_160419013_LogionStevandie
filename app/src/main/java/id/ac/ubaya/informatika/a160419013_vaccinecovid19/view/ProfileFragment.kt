package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentProfileBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Global
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.ProfileDetailViewModel
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ButtonDeleteProfileListener,ButtonKeluarAkunListener,ButtonProfileQRCodeListener,ButtonGoToProfileDetailListener {
    private lateinit var viewModel: ProfileViewModel
    private lateinit var dataBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetch(Global.nomorHP)

        dataBinding.qrcode = this
        dataBinding.keluar = this
        dataBinding.delete = this
        dataBinding.detailedit = this

        /*btnQrCode.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToQRCodeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        fabEdit.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToProfileDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnLogOut.setOnClickListener {
            val action = DoctorTeleDetailFragmentDirections.actionDoctorTeleDetailFragmentToItemHome()
            Navigation.findNavController(it).navigate(action)
        }*/

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            dataBinding.profil = it
        })
    }

    override fun onButtonProfileQRCode(v: View) {
        val action = ProfileFragmentDirections.actionProfileFragmentToQRCodeFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonGoToProfileDetail(v: View) {
        val action = ProfileFragmentDirections.actionProfileFragmentToProfileDetailFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonDeleteProfile(v: View, obj: Profile) {
        viewModel.deleteProfile(obj)
        val action = ProfileFragmentDirections.actionItemProfileToLoginActivity()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonKeluarAkun(v: View) {
        val action = ProfileFragmentDirections.actionItemProfileToLoginActivity()
        Navigation.findNavController(v).navigate(action)
    }

}