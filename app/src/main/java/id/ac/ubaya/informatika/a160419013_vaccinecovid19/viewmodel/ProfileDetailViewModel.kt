package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProfileDetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private var job = Job()
    val profileLD = MutableLiveData<Profile>()

    fun fetch(phoneNumber: String){
        launch {
            val db = buildDB(getApplication())
            profileLD.value = db.profileDao().selectProfile(phoneNumber)
        }
    }

    fun update(name: String, negara: String, nik: String, tanggal_lahir: String, email:String, phoneNumber: String){
        launch {
            val db = buildDB(getApplication())
            db.profileDao().update(name,negara, nik, tanggal_lahir, email, phoneNumber)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}