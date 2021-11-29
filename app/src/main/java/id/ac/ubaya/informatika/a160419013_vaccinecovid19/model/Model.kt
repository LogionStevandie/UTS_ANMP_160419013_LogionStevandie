package id.ac.ubaya.informatika.a160419013_vaccinecovid19.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class City(
    val id:String?,
    val name:String?,
    val resiko:String?,
    val positiv:String?,
    val negativ:String?,
    val sembuh:String?,
    val meninggal:String?
)

data class Info(
        val id:String?,
        val name:String?,
        val tanggal:String?,
        val isi:String?
)

data class Dokter(
    val id:String?,
    val name:String?,
    val bidang:String?,
    val foto:String?
)

@Entity(tableName = "profile")
data class Profile(
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "negara")
    var negara:String,
    @ColumnInfo(name = "nik")
    var nik:String,
    @ColumnInfo(name = "tanggal_lahir")
    var tanggal_lahir:String,
    @ColumnInfo(name = "email")
    var email:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}