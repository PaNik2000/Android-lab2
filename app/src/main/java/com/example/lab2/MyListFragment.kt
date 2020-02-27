package com.example.lab2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.fragment.app.ListFragment

class MyListFragment : ListFragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val context = activity as Context

        val list : ArrayList<String>? = arguments?.getStringArrayList("json")
        val technolist = ArrayList<Technology>()
        toTechnology(list!!, technolist)

        val array = ArrayList<String>()

        for (value in technolist) {
            array.add(value.name)
        }

        val adapter : ListAdapter = MyListAdapter(context, android.R.layout.simple_list_item_1, technolist)

        listAdapter = adapter
    }

    fun toTechnology(list : ArrayList<String>, technolist : ArrayList<Technology>) {
        var image : String = ""
        var name : String = ""
        var helpText : String = ""

        var i : Int = 0
        var chars : CharSequence
        while (i < 718) {
            if (Regex("\\s{8}\"graphic\".+").matches(list[i].substring(0, list[i].lastIndex))) {
                image = list[i].substring(20, list[i].lastIndex - 2)
//                Log.d("abc", image)
            }
            else if (Regex("\\s{8}\"helptext\".+").matches(list[i].substring(0, list[i].lastIndex))) {
                helpText = list[i].substring(21, list[i].lastIndex - 2)
//                Log.d("abc", helpText)
            }
            else if (Regex("\\s{8}\"name\".+").matches(list[i].substring(0, list[i].lastIndex))) {
                name = list[i].substring(17, list[i].lastIndex - 2)
//                Log.d("abc", name)
            }

            if ((image != "") and (name != "")) {
                technolist.add(Technology(name, image, helpText))
                image = ""
                name = ""
                helpText = ""
            }
            i++
        }
    }

}