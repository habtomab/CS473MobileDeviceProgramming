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
import com.example.cs473mobiledeviceprogramming.*
import com.example.cs473mobiledeviceprogramming.Adapter.MyAdapter
import com.example.cs473mobiledeviceprogramming.Adapter.OnCategoryClick
import com.example.cs473mobiledeviceprogramming.Model.PdfModel

//import kotlinx.android.synthetic.main.r.*
//import kotlinx.android.synthetic.main.fragment_lecture.view.*

class LectureFragment : Fragment(),
    OnCategoryClick {

private val leactures: ArrayList<PdfModel> = arrayListOf(
    PdfModel(
        "Lesson 01", "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-1-Introduction.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 02", "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-2-Kotlin%20Fundamendals.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 03",
        "https://sakai.cs.miu.edu/access/content/group/b4080844-843c-4fa6-a912-7e0476745d6f/Lectures/Lesson-3-CreatingFirstApp.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 04",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-4-Views%2C%20Layouts%2C%20Resources%20and%20Lifecycle.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 05",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-5-Activities_Intents.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 06",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-6-User%20Input%20Controls_Day1.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 07",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-7-Menus_Tabs_Fragments_Day1.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 08",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-8-SharedPreferences%20Webview.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 09",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-9-Multimedia.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 10",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson%E2%80%9310-SQLite.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 11",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-11-Sensors.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 12",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson-12-Localization.pdf",R.drawable.pdf_image),
    PdfModel(
        "lesson 13",
        "https://github.com/habtomab/MobileAppSln/blob/master/Lectures/Lesson%20-13-Publish%20APK-1.pdf",R.drawable.pdf_image)
)






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_lecture, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recyclerLecture);
        recycler.hasFixedSize()
        recycler.adapter =
            MyAdapter(leactures, this)
        recycler.layoutManager = LinearLayoutManager(activity)
        return root
    }

    override fun onClickCategory(leacture: PdfModel) {
        Toast.makeText(activity,leacture.pdfName, Toast.LENGTH_SHORT).show()
        var intent = Intent(activity, PdfActivity::class.java)
        intent.putExtra("product",leacture)
        startActivity(intent)


    }
}

