package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Dokter
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*
import kotlinx.android.synthetic.main.info_list_item.view.*


class DokterListAdapter(val dokterList:ArrayList<Dokter>): RecyclerView.Adapter<DokterListAdapter.InfoViewHolder>()  {
    class InfoViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun updateDokterList(newDokterList:List<Dokter>){
        dokterList.clear()
        dokterList.addAll(newDokterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.dokter_list_item, parent, false)

        return InfoViewHolder(v)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.view.txtIdDokter.text = dokterList[position].id
        holder.view.txtNamaDokter.text = dokterList[position].name
        holder.view.txtBidangDokter.text = dokterList[position].bidang
        holder.view.imageDokterTele.loadImage(dokterList[position].foto.toString(), holder.view.progressBarGambarDokter)
        holder.view.btnChatDokter.setOnClickListener {
            val id = holder.view.txtIdDokter.text.toString()
            val idKe = id.toInt()
            val action = DoctorTeleFragmentDirections.actionDoctorTeleFragmentToDoctorTeleDetailFragment(idKe)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }


}