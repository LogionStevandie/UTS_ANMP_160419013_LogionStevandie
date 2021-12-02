package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.view.View
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile

interface ButtonAddProfileListener{
    fun onButtonAddProfile(v:View)
}

interface ButtonVerificationProfileListener{
    fun onButtonVerificationProfile(v:View)
}

interface ButtonGoToMainListener{
    fun onButtonGoToMain(v:View)
}

interface ButtonGoToDaftarListener{
    fun onButtonGoToDaftar(v:View)
}

interface ButtonEditProfileListener{
    fun onButtonEditProfile(v:View, obj:Profile)
}

interface ButtonProfileQRCodeListener{
    fun onButtonProfileQRCode(v:View)
}

interface ButtonGoToProfileDetailListener{
    fun onButtonGoToProfileDetail(v:View)
}

interface ButtonDeleteProfileListener{
    fun onButtonDeleteProfile(v: View,obj: Profile)
}
interface ButtonKeluarAkunListener{
    fun onButtonKeluarAkun(v:View)
}