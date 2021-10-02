package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Dokter

class DokterDetailViewModel: ViewModel() {
    val dokterLD = MutableLiveData<Dokter>()

    fun refresh(datake:Int){
        var dokter = Dokter("","","","")
        if (datake == 1){
            dokter = Dokter(
                "1",
                "Charity MacEvilly",
                "McKesson Contract Packaging",
                "https://media.istockphoto.com/photos/teenage-beauty-picture-id1126913832?k=20&m=1126913832&s=612x612&w=0&h=JQa7WVZhat9D5bsjdG7KeFnAAFtr1N2B8PDfNU99P3A="
            )
        }
        else if(datake == 2){
            dokter = Dokter(
                "2",
                "Lodovico Bolwell",
                "Liberty Pharmaceuticals, Inc.",
                "https://media.istockphoto.com/photos/portrait-of-a-taiwanese-man-picture-id1149504274?b=1&k=20&m=1149504274&s=170667a&w=0&h=eqYn6_MS4QcPqUkR7z_ovhivBZ1CXf0MeQrCP2s08bA="
            )
        }
        else if(datake == 3){
            dokter = Dokter(
                "3",
                "Clark Muge",
                "CorePharma, LLC",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTr94TUcczwCauFVcTE6mh7yJJYu4HHjO6lQ&usqp=CAU"
            )
        }
        else if(datake == 4){
            dokter = Dokter(
                "4",
                "Susanne Creboe",
                "Walgreens",
                "https://media.istockphoto.com/photos/glowing-face-of-beautiful-girl-picture-id1134068203?k=20&m=1134068203&s=612x612&w=0&h=msbxCabBDak_j96xQX6r0FZbs2CDwwjD2RCKQUe_vWg="
            )
        }
        else if(datake == 5){
            dokter = Dokter(
                "5",
                "Laura Sebring",
                "Navajo Manufacturing Company Inc.",
                "https://cdn.shopify.com/s/files/1/1083/5260/products/Child_1024x1024.jpg?v=1587639925"
            )
        }
        else if(datake == 6){
            dokter = Dokter(
                "6",
                "Matelda Fer",
                "Landy International",
                "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg?size=626&ext=jpg"
            )
        }
        dokterLD.value = dokter
    }

}