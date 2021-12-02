package id.ac.ubaya.informatika.a160419013_vaccinecovid19.model

import androidx.room.*

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg profile: Profile)

    @Query("SELECT * FROM profile")
    suspend fun selectAllProfile():List<Profile>

    @Query("SELECT * FROM profile WHERE phoneNumber = :phoneNumber")
    suspend fun selectProfile(phoneNumber:String):Profile

    @Query("UPDATE profile SET name = :name, negara= :negara, nik=:nik, tanggal_lahir= :tanggal_lahir, email= :email WHERE phoneNumber = :phoneNumber")
    suspend fun update(name: String, negara: String, nik: String, tanggal_lahir: String, email:String, phoneNumber: String)

    @Delete
    suspend fun deleteProfile(profile: Profile)
}