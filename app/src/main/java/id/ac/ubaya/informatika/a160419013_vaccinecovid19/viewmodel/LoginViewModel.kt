package id.ac.ubaya.informatika.a160419013_vaccinecovid19.viewmodel

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Profile
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(application: Application):AndroidViewModel(application),CoroutineScope {
    private var job = Job()
    val profileListLD = MutableLiveData<List<Profile>>()
    val profileLD = MutableLiveData<Profile>()

    fun selectAll(){
        launch {
            val db = buildDB(getApplication())
            profileListLD.value = db.profileDao().selectAllProfile()
        }
    }

    fun login(nomorTelepon:String){
        launch {
            val db = buildDB(getApplication())
            profileLD.value = db.profileDao().selectProfile(nomorTelepon)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}