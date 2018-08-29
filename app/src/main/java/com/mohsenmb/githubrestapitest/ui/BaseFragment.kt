package com.mohsenmb.githubrestapitest.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohsenmb.githubrestapitest.R
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stub_content.layoutResource = getLayoutId()
        stub_content.inflate()
        onViewReady(view, savedInstanceState)
    }

    abstract fun onViewReady(view: View, savedInstanceState: Bundle?)

    fun getMainActivity(): MainActivity? =
            if (activity is MainActivity) activity as MainActivity
            else null

    @LayoutRes
    abstract fun getLayoutId(): Int
}