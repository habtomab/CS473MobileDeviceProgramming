package com.example.cs473mobiledeviceprogramming

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import com.example.cs473mobiledeviceprogramming.Fragments.AssignmentFragment
import com.example.cs473mobiledeviceprogramming.Fragments.LectureFragment
import com.example.cs473mobiledeviceprogramming.Fragments.QuizFragment

class MainActivity : AppCompatActivity() {

    var fmanager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
//        var transaction = fmanager.beginTransaction()
//        transaction.add(R.id.frameFragmentId,
//            QuizFragment()
//        ).commit()
    }



    fun lecture() {
    var tx = fmanager.beginTransaction()
    // when the user selects the Home button, we are replacing the HomeFragment
    tx.replace(R.id.frameFragmentId,
        LectureFragment()
    )
    tx.commit()
}

fun assignment() {
   var  tx = fmanager.beginTransaction()
    // when the user selects the Home button, we are replacing the HomeFragment
    tx.replace(R.id.frameFragmentId,
        AssignmentFragment()
    )
    tx.commit()
}

fun quiz() {
    var intent=Intent(this, QiuzeActivity::class.java)
    startActivity(intent)
//   var tx = fmanager.beginTransaction()
//    // when the user selects the Home button, we are replacing the HomeFragment
//    tx.replace(R.id.frameFragmentId,
//        QiuzeActivity()
//    )
//    tx.commit()
}
    fun corseInfo(){


        var intent=Intent(this, Info::class.java)
        intent.putExtra("id_value", 10)
        startActivity(intent)
//        var tx = fmanager.beginTransaction()
//        // when the user selects the Home button, we are replacing the HomeFragment
//        tx.replace(R.id.frameFragmentId,InfMIU())
//        tx.commit()
    }



    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        // Code to get the title and icon on the option overflow
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean {
        Toast.makeText(applicationContext, item.title.toString(), Toast.LENGTH_LONG).show()



        when(item.getItemId()) {
             R.id.m1->
             {
                 lecture()
                 Toast.makeText(applicationContext, "Lecture", Toast.LENGTH_SHORT).show()
             }

            R.id.m2->
            {
                assignment()
                Toast.makeText(applicationContext, "ASSIGNMENT", Toast.LENGTH_SHORT).show()
            }

            R.id.m3-> {
                quiz()
                Toast.makeText(applicationContext, "QUIZ", Toast.LENGTH_SHORT).show()
            }

            R.id.m4->
            {
                corseInfo()
                Toast.makeText(applicationContext, "COURSE INFO", Toast.LENGTH_SHORT).show()
            }

        }

        return super.onOptionsItemSelected(item)
    }




}







































//lateinit var fmanager: FragmentManager
//lateinit var tx: FragmentTransaction
//@SuppressLint("ResourceType")
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.menu.main_menu)
//    // assign and get the object for the FragmentManager by using the below statements
//    // supportFragmentManager.beginTransaction().add(R.id.frame1, HomeFragment()).commit()
//    fmanager = supportFragmentManager
//    //get the object for FragmentTransaction and Initialize the transaction
//    tx = fmanager.beginTransaction()
//    /* by default we are going to show the HomeFragment in onCreate() method using add() method
//        * add() method accepts two parameters -
//        * 1. id of fragment 2.object of Fragment class*/
//    tx.add(R.id.frame1,HomeFragment())
//    // Commit the fragment transaction
//    tx.commit()
//}

