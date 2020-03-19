package com.example.cs473mobiledeviceprogramming.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs473mobiledeviceprogramming.Model.PdfModel
import com.example.cs473mobiledeviceprogramming.R
//import kotlinx.android.synthetic.main.activity_product_list_layout.view.*
import kotlinx.android.synthetic.main.customview.view.*

class MyAdapter(
    var clist: ArrayList<PdfModel>,
    val clickListener: OnCategoryClick
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customview, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return clist.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.loadView(clist[position],clickListener)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var vimage = itemView.imageViewId
        var vname = itemView.textViewId


        fun loadView(leacture: PdfModel, action: OnCategoryClick){
             vname.text = leacture.pdfName
            vimage.setImageResource(leacture.img)

            itemView.setOnClickListener {
                action.onClickCategory(leacture)
            }
        }


    }

}

interface  OnCategoryClick{
    fun onClickCategory(product: PdfModel)
}