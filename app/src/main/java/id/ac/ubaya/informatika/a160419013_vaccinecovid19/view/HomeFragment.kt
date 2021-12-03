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
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentDaftarLoginBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.FragmentHomeBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel.CityHomeListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),ButtonHomeInfoPentingListener,ButtonHomePasporDigitalListener,ButtonHomePendaftaranListener,ButtonHomeTeleDokterListener {
    private lateinit var viewModel:CityHomeListViewModel
    private val cityHomeListAdapter = CityHomeListAdapter(arrayListOf())
    private lateinit var dataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CityHomeListViewModel::class.java)
        viewModel.refresh()
        dataBinding.info = this
        dataBinding.paspor = this
        dataBinding.pendaftaran = this
        dataBinding.teledokter = this

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

        /*btnVaksin.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToVaccineFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnPasport.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDigitalPasportFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnInfo.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToInfoFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnDoctor.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDoctorTeleFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
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

    override fun onButtonHomePendaftaran(v: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToVaccineFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonHomePasporDigital(v: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToDigitalPasportFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonHomeInfoPenting(v: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToInfoFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonHomeTeleDokter(v: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToDoctorTeleFragment()
        Navigation.findNavController(v).navigate(action)
    }

}