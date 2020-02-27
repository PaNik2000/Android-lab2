package com.example.lab2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView

class MyListAdapter(context: Context, resource: Int, objects: MutableList<Technology>) :
    ArrayAdapter<Technology>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val tech = getItem(position)
        var view : View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_element, null)
        }

        (view?.findViewById(R.id.listText) as TextView).setText(tech?.name)

        return view

    }
}