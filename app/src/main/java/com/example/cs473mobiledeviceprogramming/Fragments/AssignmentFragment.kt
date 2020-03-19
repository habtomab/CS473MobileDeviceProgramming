package com.example.cs473mobiledeviceprogramming.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs473mobiledeviceprogramming.Model.PdfModel
import com.example.cs473mobiledeviceprogramming.Adapter.MyAdapter
import com.example.cs473mobiledeviceprogramming.Adapter.OnCategoryClick
import com.example.cs473mobiledeviceprogramming.PdfActivity
import com.example.cs473mobiledeviceprogramming.R

class AssignmentFragment : Fragment() ,
    OnCategoryClick {

        val assignments: ArrayList<PdfModel> = arrayListOf(
        PdfModel("Homework 01","https://github.com/habtomab/MobileAppSln/blob/master/Assignment/Homework-1.pdf", R.drawable.pdf_image),
        PdfModel("Homework 02", "https://github.com/habtomab/MobileAppSln/blob/master/Assignment/HOMEWORK-2.pdf",R.drawable.pdf_image),
        PdfModel("Homework 03", "https://github.com/habtomab/MobileAppSln/blob/master/Assignment/HOMEWORK-3.pdf",R.drawable.pdf_image),
        PdfModel("Homework 04", "https://github.com/habtomab/MobileAppSln/blob/master/Assignment/HOMEWORK-4.pdf",R.drawable.pdf_image),
        PdfModel("Homework 05", "https://github.com/habtomab/MobileAppSln/blob/master/Assignment/HOMEWORK-5.pdf",R.drawable.pdf_image),
        PdfModel("Homework 06", "https://github.com/habtomab/MobileAppSln/blob/master/Assignment/HOMEWORK-6-Group%20Assignment.pdf",R.drawable.pdf_image),
        PdfModel("Homework 07", "",R.drawable.pdf_image),
            PdfModel("Homework 08", "",R.drawable.pdf_image),
            PdfModel("Homework 09", "",R.drawable.pdf_image),
            PdfModel("Homework 10", "",R.drawable.pdf_image),
            PdfModel("Homework 11", "",R.drawable.pdf_image),
            PdfModel("Homework 12", "",R.drawable.pdf_image),
            PdfModel("Homework 13", "",R.drawable.pdf_image))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_lecture, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recyclerLecture);
        recycler.hasFixedSize()
        recycler.adapter =
            MyAdapter(
                assignments,
                this
            )
        recycler.layoutManager = LinearLayoutManager(activity)
        return root
    }

    override fun onClickCategory(product: PdfModel) {
        Toast.makeText(activity, product.pdfName, Toast.LENGTH_SHORT).show()
        var intent = Intent(activity, PdfActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }
}