package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.Info
import kotlinx.android.synthetic.main.info_list_item.view.*

class InfoListAdapter(val infoList:ArrayList<Info>): RecyclerView.Adapter<InfoListAdapter.InfoViewHolder>()  {
    class InfoViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateInfoList(newInfoList:List<Info>){
        infoList.clear()
        infoList.addAll(newInfoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.info_list_item, parent, false)

        return InfoListAdapter.InfoViewHolder(v)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        with(holder.view){
            txtIdInfo.text = infoList[position].id
            txtNamaInfo.text = infoList[position].name
            txtTanggalInfo.text = infoList[position].tanggal

            cardViewInfo.setOnClickListener {
                val id = holder.view.txtIdInfo.text.toString()
                val idKe = id.toInt()
                val action = InfoFragmentDirections.actionInfoFragmentToInfoDetailFragment(idKe)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return infoList.size
    }
}