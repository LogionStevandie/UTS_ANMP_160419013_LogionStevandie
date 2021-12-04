package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentInfoDetailBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DetailInfoViewModel
import kotlinx.android.synthetic.main.fragment_info_detail.*
import kotlinx.android.synthetic.main.info_list_item.*

class InfoDetailFragment : Fragment() {
    private lateinit var viewModel: DetailInfoViewModel
    private lateinit var dataBinding: FragmentInfoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_info_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentInfoDetailBinding>(inflater, R.layout.fragment_info_detail, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailInfoViewModel::class.java)

        val uuid = InfoDetailFragmentArgs.fromBundle(requireArguments()).datake
        viewModel.refresh(uuid)

        /*if (arguments != null){
            val idKe = InfoDetailFragmentArgs.fromBundle(requireArguments()).datake
            viewModel = ViewModelProvider(this).get(DetailInfoViewModel::class.java)
            viewModel.refresh(idKe)

            viewModel.infoLd.observe(viewLifecycleOwner, Observer {
                txtNameInfoDetail.setText(it.name)
                txtTanggalInfoDetail.setText(it.tanggal)
                txtIsiInfoDetail.setText(it.isi)
            })

        }*/

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.infoLd.observe(viewLifecycleOwner, Observer {
            dataBinding.info = it

        })
    }
}