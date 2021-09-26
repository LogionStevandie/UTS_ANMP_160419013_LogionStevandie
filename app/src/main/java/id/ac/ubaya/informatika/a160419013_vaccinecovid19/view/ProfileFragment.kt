package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnQrCode.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToQRCodeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        fabEdit.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToProfileDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}