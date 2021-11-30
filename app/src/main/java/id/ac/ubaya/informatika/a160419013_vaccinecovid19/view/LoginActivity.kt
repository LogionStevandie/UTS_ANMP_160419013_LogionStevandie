package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        navController = Navigation.findNavController(this, R.id.loginssFragment)
        //NavigationUI.setupActionBarWithNavController(this, navController)

        /*btnVerifikasi.setOnClickListener {
            if (txtNomorHp.text.toString() == ""){
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Harap isi Nomor Telepon!")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                        txtNomorHp.requestFocus()
                    })
                    .show()
            }
            else{
                AlertDialog.Builder(this)
                    .setTitle("Berhasil")
                    .setMessage("Kode Verifikasi: 123456")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                        txtKodeVerifikasi.requestFocus()
                    })
                    .show()
            }

        }

        btnLogin.setOnClickListener {
            if (txtKodeVerifikasi.text.toString() != "123456"){
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Harap isi Kode Verifikasi dengan benar!")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                        txtKodeVerifikasi.requestFocus()
                    })
                    .show()
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }*/
    }
    //untuk langsung keluar
    /*override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)//akses home
        intent.addCategory(Intent.CATEGORY_HOME)//menambah kategori home agar ketika di back langsung menuju home
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP//menghapus history activity yang dibuka
        startActivity(intent)
    }*/
}