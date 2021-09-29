package id.ac.ubaya.informatika.a160419013_vaccinecovid19.model

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