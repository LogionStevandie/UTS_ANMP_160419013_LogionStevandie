package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Info

class DetailInfoViewModel:ViewModel() {
    val infoLd = MutableLiveData<Info>()

    fun refresh(datake:Int){
        var info = Info("","","","")
        if (datake == 1){
            info = Info(
                "1",
                "Integer aliquet, massa id lobortis convallis.",
                "10/29/2020",
                "Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem."
            )
        }
        else if(datake == 2){
            info = Info(
                "2",
                "Morbi porttitor lorem id ligula.",
                "5/7/2021",
                "Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo."
            )
        }
        else if(datake == 3){
            info = Info(
                "3",
                "Fusce posuere felis sed lacus.",
                "2/10/2021",
                "Fusce consequat. Nulla nisl. Nunc nisl."
            )
        }
        else if(datake == 4){
            info = Info(
                "4",
                "Aenean fermentum.",
                "3/18/2021",
                "Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius."
            )
        }
        else if(datake == 5){
            info = Info(
                "5",
                "Integer aliquet, massa id.",
                "12/20/2020",
                "Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus."
            )
        }
        else if(datake == 6){
            info = Info(
                "6",
                "Vestibulum ac est lacinia nisi venenatis tristique.",
                "5/14/2021",
                "Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo."
            )
        }
        infoLd.value = info
    }

}