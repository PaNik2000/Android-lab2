package com.example.lab2

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.core.view.get
import java.net.URL

class MyListAdapter(context: Context, resource: Int, var objects: MutableList<Technology>) :
    ArrayAdapter<Technology>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val tech = getItem(position)
        var view : View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_element, null)
        }

        (view?.findViewById(R.id.listText) as TextView).text = tech?.name
        if (tech?.bitmap != null) {
            val temp = tech.bitmap
            (view.findViewById(R.id.listImage) as ImageView).setImageBitmap(Bitmap.createScaledBitmap(temp!!, 64, 64, true))
        }
        else {
            MyAsyncTask(tech!!, view).execute()
            if (tech.bitmap == null) {
                tech.bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.resources, R.drawable.broken), 64, 64, true)
                (view.findViewById(R.id.listImage) as ImageView).setImageBitmap(tech.bitmap)
            }
        }

        return view
    }

    inner class MyAsyncTask(val tech : Technology, val view : View) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            if ((tech.image != "chemistry.jpg")         and (tech.image != "economics.jpg")             and (tech.image != "electricity.jpg")
                and (tech.image != "electronics.jpg")   and (tech.image != "espionage.jpg")             and (tech.image != "explosives.jpg")
                and (tech.image != "fusion_power.jpg")  and (tech.image != "genetic_engineering.jpg")   and (tech.image != "guerilla_warfare.jpg")
                and (tech.image != "iron_working.jpg")  and (tech.image != "literacy.jpg")              and (tech.image != "machine_tools.jpg")
                and (tech.image != "magnetism.jpg")     and (tech.image != "masonry.jpg")               and (tech.image != "miniaturization.jpg")
                and (tech.image != "plastics.jpg")      and (tech.image != "radio.jpg")                 and (tech.image != "railroad.jpg")
                and (tech.image != "refrigeration.jpg") and (tech.image != "tactics.jpg")               and (tech.image != "the_wheel.jpg")) {
                val conn = URL("https://raw.githubusercontent.com/wesleywerner/ancient-tech/" +
                        "02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + tech.image).openConnection()

                conn.connect()

                val inputStream = conn.getInputStream()
                tech.bitmap = BitmapFactory.decodeStream(inputStream)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            (view.findViewById(R.id.listImage) as ImageView).setImageBitmap(Bitmap.createScaledBitmap(tech.bitmap!!, 64, 64, true))
        }
    }

}