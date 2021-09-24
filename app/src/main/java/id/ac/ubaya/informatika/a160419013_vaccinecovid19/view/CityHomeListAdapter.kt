package id.ac.ubaya.informatika.a160419013_vaccinecovid19.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.R
import id.ac.ubaya.informatika.a160419013_vaccinecovid19.model.City
import kotlinx.android.synthetic.main.city_list_item.view.*

class CityHomeListAdapter(val cityHomeList:ArrayList<City>):RecyclerView.Adapter<CityHomeListAdapter.CityViewHolder>() {
    class CityViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateCityHomeList(newCityHomeList:List<City>){
        cityHomeList.clear()
        cityHomeList.addAll(newCityHomeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.city_list_item, parent, false)

        return CityViewHolder(v)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        with(holder.view){
            txtLokasi.text = cityHomeList[position].name
            txtResiko.text = "Resiko ${cityHomeList[position].resiko}"
            if (cityHomeList[position].resiko == "Rendah") txtResiko.setBackgroundColor(Color.parseColor("#FAFF00"))
            else if (cityHomeList[position].resiko == "Sedang") txtResiko.setBackgroundColor(Color.parseColor("#FFB319"))
            else if(cityHomeList[position].resiko == "Tinggi") txtResiko.setBackgroundColor(Color.parseColor("#FF0000"))
            else if(cityHomeList[position].resiko == "Aman") txtResiko.setBackgroundColor(Color.parseColor("#FFFFFF"))
            else txtResiko.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
    }

    override fun getItemCount(): Int {
        return cityHomeList.size
    }
}