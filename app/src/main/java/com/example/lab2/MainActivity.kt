package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = intent.getStringArrayListExtra("json")

        val listFrag = MyListFragment()
        val bundle = Bundle()
        bundle.putStringArrayList("json", list)
        listFrag.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.linearLayout, listFrag).commit()

/*        val myAdapter = MyPageAdapter(supportFragmentManager, this)

        var viewPager : ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = myAdapter*/
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}
