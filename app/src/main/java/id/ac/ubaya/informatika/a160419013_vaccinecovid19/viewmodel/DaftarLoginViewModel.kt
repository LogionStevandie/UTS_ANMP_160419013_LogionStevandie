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

class DaftarLoginViewModel (application: Application): AndroidViewModel(application), CoroutineScope {
    private var job = Job()
    val profileLD = MutableLiveData<Profile>()

    fun daftarProfile(profile: Profile){
        launch {
            val db = buildDB(getApplication())
            db.profileDao().insertAll(profile)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}