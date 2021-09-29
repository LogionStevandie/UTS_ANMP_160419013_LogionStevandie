package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.DokterListViewModel
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.InfoListViewModel
import kotlinx.android.synthetic.main.fragment_doctor_tele.*
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_info.refreshLayout

class DoctorTeleFragment : Fragment() {
    private lateinit var viewModel:DokterListViewModel
    private val dokterListAdapter = DokterListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_tele, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DokterListViewModel::class.java)
        viewModel.refresh()

        RecyclerViewDokter.layoutManager = LinearLayoutManager(context)
        RecyclerViewDokter.adapter = dokterListAdapter

        refreshLayout.setOnRefreshListener {
            RecyclerViewDokter.visibility = View.GONE
            textViewErrorDokter.visibility = View.GONE
            progressBarDokter.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun  observeViewModel(){
        viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
            dokterListAdapter.updateDokterList(it)
        })

        viewModel.loadingErrorDokterLD.observe(viewLifecycleOwner, Observer {
            textViewErrorDokter.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingDokterLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarDokter.visibility = View.VISIBLE
                RecyclerViewDokter.visibility = View.GONE
            }else{
                progressBarDokter.visibility = View.GONE
                RecyclerViewDokter.visibility = View.VISIBLE
            }
        })

    }

}