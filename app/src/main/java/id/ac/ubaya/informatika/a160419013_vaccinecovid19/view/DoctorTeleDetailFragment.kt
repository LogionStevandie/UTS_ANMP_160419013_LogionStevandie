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
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentDoctorTeleDetailBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.loadImage
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DokterDetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_doctor_tele_detail.*
import java.util.concurrent.TimeUnit

class DoctorTeleDetailFragment : Fragment(), ButtonCallDokterListener, ButtonDetailDokterBachHomeListener {
    private lateinit var viewModel: DokterDetailViewModel
    private lateinit var dataBinding: FragmentDoctorTeleDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_doctor_tele_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentDoctorTeleDetailBinding>(inflater, R.layout.fragment_doctor_tele_detail, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DokterDetailViewModel::class.java)

        val id = DoctorTeleDetailFragmentArgs.fromBundle(requireArguments()).datake
        viewModel.refresh(id)

        dataBinding.call = this
        dataBinding.back = this

        /*if (arguments != null){
            val idKe = DoctorTeleDetailFragmentArgs.fromBundle(requireArguments()).datake
            viewModel = ViewModelProvider(this).get(DokterDetailViewModel::class.java)
            viewModel.refresh(idKe)

            viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
                txtNamaDokterDetail.setText(it.name)
                txtBidangDetailDokter.setText(it.bidang)
                imageDokterDetail.loadImage(it.foto.toString(), progressBarDokterDetail)
            })

        }
        fabCallDokter.setOnClickListener {
            Observable.timer(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    MainActivity.showNotification(txtNamaDokterDetail.text.toString(), "Dokter akan segera menelepon, Mohon tunggu beberapa saat.", R.drawable.ic_baseline_call_24)
                }
        }

        btnBackDoctorTele.setOnClickListener {
            val action = DoctorTeleDetailFragmentDirections.actionDoctorTeleDetailFragmentToItemHome()
            Navigation.findNavController(it).navigate(action)
        }*/

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
            dataBinding.dokter = it
        })
    }

    override fun onButtonCallDokter(v: View) {
        Observable.timer(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                MainActivity.showNotification(dataBinding.dokter.name!!, "Dokter akan segera menelepon, Mohon tunggu beberapa saat.", R.drawable.ic_baseline_call_24)
            }
    }

    override fun onButtonDetailDokterBachHome(v: View) {
        val action = DoctorTeleDetailFragmentDirections.actionDoctorTeleDetailFragmentToItemHome()
        Navigation.findNavController(v).navigate(action)
    }
}