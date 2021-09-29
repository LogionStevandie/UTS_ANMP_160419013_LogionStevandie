package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.City

class CityHomeListViewModel(application: Application): AndroidViewModel(application) {
    val cityHomeLD = MutableLiveData<List<City>>()
    val loadingErrorHomeLD = MutableLiveData<Boolean>()
    val loadingHomeLD = MutableLiveData<Boolean>()

    fun refresh(){
        val city1 = City("1","Xiongchi","Tinggi","578","82","394","386")

        val city2 = City("2","Lawrenceville","Sedang","153","794","611","819")

        val city3 = City("3","Charikar","Tinggi","863","146","519","516")

        val city4 = City("4","Putina","Tinggi","65","889","821","475")

        val city5 = City("5","Kīsh","Aman","519","289","954","451")

        val city6 = City("6","Staryy Sambor","Rendah","274","992","780","921")

        cityHomeLD.value = arrayListOf<City>(city1, city2, city3, city4, city5, city6)
        loadingErrorHomeLD.value = false
        loadingHomeLD.value = false
    }
}