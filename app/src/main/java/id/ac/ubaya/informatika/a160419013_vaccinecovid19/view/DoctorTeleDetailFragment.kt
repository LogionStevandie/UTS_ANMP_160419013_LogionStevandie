package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.loadImage
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DokterDetailViewModel
import kotlinx.android.synthetic.main.fragment_doctor_tele_detail.*
import kotlinx.android.synthetic.main.fragment_info_detail.*

class DoctorTeleDetailFragment : Fragment() {
    private lateinit var viewModel: DokterDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_tele_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            val idKe = DoctorTeleDetailFragmentArgs.fromBundle(requireArguments()).datake
            viewModel = ViewModelProvider(this).get(DokterDetailViewModel::class.java)
            viewModel.refresh(idKe)

            viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
                txtNamaDokterDetail.setText(it.name)
                txtBidangDetailDokter.setText(it.bidang)
                imageDokterDetail.loadImage(it.foto.toString(), progressBarDokterDetail)
            })

        }
    }
}