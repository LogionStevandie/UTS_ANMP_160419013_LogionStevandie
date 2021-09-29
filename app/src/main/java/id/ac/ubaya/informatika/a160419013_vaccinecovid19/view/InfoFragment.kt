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
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.InfoListViewModel
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment() {
    private lateinit var viewModel:InfoListViewModel
    private val infoListAdapter = InfoListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(InfoListViewModel::class.java)
        viewModel.refresh()

        recyclerViewInfo.layoutManager = LinearLayoutManager(context)
        recyclerViewInfo.adapter = infoListAdapter

        refreshLayout.setOnRefreshListener {
            recyclerViewInfo.visibility = View.GONE
            textInfoPenting.visibility = View.GONE
            progressBarInfo.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun  observeViewModel(){
        viewModel.infoLD.observe(viewLifecycleOwner, Observer {
            infoListAdapter.updateInfoList(it)
        })

        viewModel.loadingErrorInfoLD.observe(viewLifecycleOwner, Observer {
            textInfoPenting.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingInfoLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarInfo.visibility = View.VISIBLE
                recyclerViewInfo.visibility = View.GONE
            }else{
                progressBarInfo.visibility = View.GONE
                recyclerViewInfo.visibility = View.VISIBLE
            }
        })

    }

}