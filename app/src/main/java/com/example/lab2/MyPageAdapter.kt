package com.example.lab2

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPageAdapter internal constructor(fm: FragmentManager, context: Context) :
    FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mCatNames: Array<String>
    private val mCatDescriptions: Array<String>


    init {

        val resources = context.resources
        mCatNames = resources.getStringArray(R.array.catsTitles)
        mCatDescriptions = resources.getStringArray(R.array.catDescriptions)
    }

    override fun getItem(position: Int): Fragment {
        val arguments = Bundle()
        arguments.putString(MyFragment.CAT_NAMES, mCatNames[position])
        arguments.putString(
            MyFragment.CAT_DESCRIPTIONS,
            mCatDescriptions[position]
        )

        val catsFragment = MyFragment()
        catsFragment.setArguments(arguments)

        return catsFragment
    }

    override fun getCount(): Int {
        return mCatNames.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mCatNames[position]
    }
}