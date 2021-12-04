package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.CityListItemBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.databinding.CityStatsListItemBinding
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.City
import kotlinx.android.synthetic.main.city_stats_list_item.view.*

class CityStatsListAdapter (val cityStatsList:ArrayList<City>): RecyclerView.Adapter<CityStatsListAdapter.CityViewHolder>() {
    class CityViewHolder(val view: CityStatsListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateCityStatsList(newCityStatsList:List<City>){
        cityStatsList.clear()
        cityStatsList.addAll(newCityStatsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val v = inflater.inflate(R.layout.city_stats_list_item, parent, false)
        val v = DataBindingUtil.inflate<CityStatsListItemBinding>(inflater,R.layout.city_stats_list_item,parent, false)
        return CityViewHolder(v)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.view.city = cityStatsList[position]
        /*with(holder.view){
            txtKota.text = cityStatsList[position].name
            txtPositiv.text = "Positiv\n" + cityStatsList[position].positiv
            txtNegativ.text = "Negativ\n" + cityStatsList[position].negativ
            txtSembuh.text = "Sembuh\n" + cityStatsList[position].sembuh
            txtMeninggal.text = "Meninggal\n" + cityStatsList[position].meninggal
        }*/
    }

    override fun getItemCount(): Int {
        return cityStatsList.size
    }

}