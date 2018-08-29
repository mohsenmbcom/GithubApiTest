package com.mohsenmb.githubrestapitest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mohsenmb.githubrestapitest.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var actionManager: ActionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        actionManager.onActionListener = ::fireAction
    }

    private fun fireAction(action: Action) {

    }

    override fun onStart() {
        super.onStart()
        actionManager.fire(Action(ActionType.ACTION_TRENDING_REPOS))
    }
}
