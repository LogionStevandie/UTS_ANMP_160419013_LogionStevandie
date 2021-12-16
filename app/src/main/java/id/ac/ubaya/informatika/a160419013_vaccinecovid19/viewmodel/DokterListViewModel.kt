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
            "https://media.istockphoto.com/photos/teenage-beauty-picture-id1126913832?k=20&m=1126913832&s=612x612&w=0&h=JQa7WVZhat9D5bsjdG7KeFnAAFtr1N2B8PDfNU99P3A=",
            "+62274419883"
        )

        val dokter2 = Dokter(
            "2",
            "Lodovico Bolwell",
            "Liberty Pharmaceuticals, Inc.",
            "https://media.istockphoto.com/photos/portrait-of-a-taiwanese-man-picture-id1149504274?b=1&k=20&m=1149504274&s=170667a&w=0&h=eqYn6_MS4QcPqUkR7z_ovhivBZ1CXf0MeQrCP2s08bA=",
            "+62811380151"
        )

        val dokter3 = Dokter(
            "3",
            "Clark Muge",
            "CorePharma, LLC",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTr94TUcczwCauFVcTE6mh7yJJYu4HHjO6lQ&usqp=CAU",
            "+628163607222"
        )

        val dokter4 = Dokter(
            "4",
            "Susanne Creboe",
            "Walgreens",
            "https://media.istockphoto.com/photos/glowing-face-of-beautiful-girl-picture-id1134068203?k=20&m=1134068203&s=612x612&w=0&h=msbxCabBDak_j96xQX6r0FZbs2CDwwjD2RCKQUe_vWg=",
            "+62342803212"
        )

        val dokter5 = Dokter(
            "5",
            "Laura Sebring",
            "Navajo Manufacturing Company Inc.",
            "https://cdn.shopify.com/s/files/1/1083/5260/products/Child_1024x1024.jpg?v=1587639925",
            "+62342801912"
        )

        val dokter6 = Dokter(
            "6",
            "Matelda Fer",
            "Landy International",
            "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg?size=626&ext=jpg",
            "+62318492624"
        )


        dokterLD.value = arrayListOf<Dokter>(dokter1, dokter2, dokter3, dokter4, dokter5, dokter6)
        loadingErrorDokterLD.value = false
        loadingDokterLD.value = false
    }
}