package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.DokterListItemBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Dokter
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*
import kotlinx.android.synthetic.main.info_list_item.view.*


class DokterListAdapter(val dokterList:ArrayList<Dokter>): RecyclerView.Adapter<DokterListAdapter.InfoViewHolder>(),ButtonChatDokterListener  {
    class InfoViewHolder(val view: DokterListItemBinding): RecyclerView.ViewHolder(view.root)

    fun updateDokterList(newDokterList:List<Dokter>){
        dokterList.clear()
        dokterList.addAll(newDokterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val v = inflater.inflate(R.layout.dokter_list_item, parent, false)
        val v = DataBindingUtil.inflate<DokterListItemBinding>(inflater,R.layout.dokter_list_item,parent, false)
        return InfoViewHolder(v)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.view.dokter = dokterList[position]
        holder.view.chat = this
        /*holder.view.txtIdDokter.text = dokterList[position].id
        holder.view.txtNamaDokter.text = dokterList[position].name
        holder.view.txtBidangDokter.text = dokterList[position].bidang
        holder.view.imageDokterTele.loadImage(dokterList[position].foto.toString(), holder.view.progressBarGambarDokter)
        holder.view.btnChatDokter.setOnClickListener {
            val id = holder.view.txtIdDokter.text.toString()
            val idKe = id.toInt()
            val action = DoctorTeleFragmentDirections.actionDoctorTeleFragmentToDoctorTeleDetailFragment(idKe)
            Navigation.findNavController(it).navigate(action)
        }*/
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }

    override fun onButtonChatDokter(v: View) {
        val action = DoctorTeleFragmentDirections.actionDoctorTeleFragmentToDoctorTeleDetailFragment(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }


}