package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Dokter

class DokterListViewModel(application: Application): AndroidViewModel(application)  {
    val dokterLD = MutableLiveData<List<Dokter>>()
    val loadingErrorDokterLD = MutableLiveData<Boolean>()
    val loadingDokterLD = MutableLiveData<Boolean>()

    fun refresh() {
        val dokter1 = Dokter(
            "1",
            "Charity MacEvilly",
            "McKesson Contract Packaging",
            "http://dummyimage.com/242x100.png/5fa2dd/ffffff"
        )

        val dokter2 = Dokter(
            "2",
            "Lodovico Bolwell",
            "Liberty Pharmaceuticals, Inc.",
            "http://dummyimage.com/190x100.png/cc0000/ffffff"
        )

        val dokter3 = Dokter(
            "3",
            "Clark Muge",
            "CorePharma, LLC",
            "http://dummyimage.com/141x100.png/dddddd/000000"
        )

        val dokter4 = Dokter(
            "4",
            "Susanne Creboe",
            "Walgreens",
            "http://dummyimage.com/125x100.png/ff4444/ffffff"
        )

        val dokter5 = Dokter(
            "5",
            "Laura Sebring",
            "Navajo Manufacturing Company Inc.",
            "http://dummyimage.com/105x100.png/ff4444/ffffff"
        )

        val dokter6 = Dokter(
            "6",
            "Matelda Fer",
            "Landy International",
            "http://dummyimage.com/167x100.png/5fa2dd/ffffff"
        )


        dokterLD.value = arrayListOf<Dokter>(dokter1, dokter2, dokter3, dokter4, dokter5, dokter6)
        loadingErrorDokterLD.value = false
        loadingDokterLD.value = false
    }
}