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
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel:CityHomeListViewModel
    private val cityHomeListAdapter = CityHomeListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CityHomeListViewModel::class.java)
        viewModel.refresh()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = cityHomeListAdapter

        refreshLayout.setOnRefreshListener {
            recyclerView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun  observeViewModel(){
        viewModel.cityHomeLD.observe(viewLifecycleOwner, Observer {
            cityHomeListAdapter.updateCityHomeList(it)
        })

        viewModel.loadingErrorHomeLD.observe(viewLifecycleOwner, Observer {
            txtError.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingHomeLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoad.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }else{
                progressLoad.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
        })

    }

}