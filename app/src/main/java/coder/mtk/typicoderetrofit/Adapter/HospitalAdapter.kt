package coder.mtk.typicoderetrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.typicoderetrofit.R
import coder.mtk.typicoderetrofit.model.HospitalX
import kotlinx.android.synthetic.main.item_hospital.view.*

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    private var clickListener : ClickListener? = null

    private var hospitalx : List<HospitalX> = ArrayList()

    fun setOnClickListener (clickListener:ClickListener){
        this.clickListener = clickListener
    }

    inner class HospitalViewHolder  (itemView : View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{

        lateinit var hospitalx: HospitalX

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(hospitalx : HospitalX){
            this.hospitalx=hospitalx
            itemView.hospitalName.text = hospitalx.hospital_name
        }

        override fun onClick(p0: View?) {
            clickListener?.onClick(hospitalx)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_hospital,parent,false)
        return HospitalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospitalx[position])
    }

    override fun getItemCount(): Int {
        return hospitalx.size
    }

    fun addHospitalItem (hospitalx : List<HospitalX>){
        this.hospitalx = hospitalx
        notifyDataSetChanged()
    }

    interface ClickListener{
        fun onClick(hospitalx: HospitalX)
    }
}