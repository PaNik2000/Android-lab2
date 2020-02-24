package com.example.lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)

        val arguments = arguments
        if (arguments != null) {
            val catName = arguments.getString(CAT_NAMES)
            val catDescription = arguments.getString(CAT_DESCRIPTIONS)
//            val topCardResourceId = arguments.getInt(TOP_IMAGE)

            displayValues(view, catName, catDescription)
        }
        return view
    }

    private fun displayValues(
        v: View, name: String?,
        catDescription: String?
    ) {
        val catNameTextView : TextView = v.findViewById(R.id.technologyName)
        val catDescriptionTextView : TextView = v.findViewById(R.id.helpText)
//        val cardImageView : ImageView = v.findViewById(R.id.image)

        catNameTextView.setText(name)
        catDescriptionTextView.setText(catDescription)

//        cardImageView.setImageResource(topCardResourceId)
    }

    companion object {
        internal val CAT_NAMES = "cats_names"
        internal val CAT_DESCRIPTIONS = "cat_descriptions"
//        internal val TOP_IMAGE = "top image"
    }
}