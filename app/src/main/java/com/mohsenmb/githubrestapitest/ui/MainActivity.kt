package com.mohsenmb.githubrestapitest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mohsenmb.githubrestapitest.R
import com.mohsenmb.githubrestapitest.ui.trendings.TrendingReposFragment
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
        when (action.type) {
            ActionType.UNKNOWN -> Log.w(javaClass.simpleName, "Unknown Action Fired!")
            ActionType.ACTION_TRENDING_REPOS -> TrendingReposFragment.newInstance()
            ActionType.ACTION_REPO -> Log.w(javaClass.simpleName, "${action.type} is not implemented yet!")
        }
    }

    override fun onStart() {
        super.onStart()
        actionManager.fire(Action(ActionType.ACTION_TRENDING_REPOS))
    }
}
