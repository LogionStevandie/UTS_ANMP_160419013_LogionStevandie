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
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.CityHomeListViewModel
import kotlinx.android.synthetic.main.fragment_home.refreshLayout
import kotlinx.android.synthetic.main.fragment_statistik.*

class StatistikFragment : Fragment() {
    private lateinit var viewModel: CityHomeListViewModel
    private val cityStatsListAdapter = CityStatsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistik, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CityHomeListViewModel::class.java)
        viewModel.refresh()

        recyclerView2.layoutManager = LinearLayoutManager(context)
        recyclerView2.adapter = cityStatsListAdapter

        refreshLayout.setOnRefreshListener {
            recyclerView2.visibility = View.GONE
            txtError2.visibility = View.GONE
            progressLoad2.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun  observeViewModel(){
        viewModel.cityHomeLD.observe(viewLifecycleOwner, Observer {
            cityStatsListAdapter.updateCityStatsList(it)
        })

        viewModel.loadingErrorHomeLD.observe(viewLifecycleOwner, Observer {
            txtError2.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingHomeLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoad2.visibility = View.VISIBLE
                recyclerView2.visibility = View.GONE
            }else{
                progressLoad2.visibility = View.GONE
                recyclerView2.visibility = View.VISIBLE
            }
        })

    }

}