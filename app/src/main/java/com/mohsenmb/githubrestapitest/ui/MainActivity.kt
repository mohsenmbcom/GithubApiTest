package com.mohsenmb.githubrestapitest.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mohsenmb.githubrestapitest.R
import com.mohsenmb.githubrestapitest.ui.trendings.TrendingReposFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var actionManager: ActionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        actionManager.onActionListener = ::fireAction

        if (supportFragmentManager.findFragmentById(R.id.container) == null) {
            actionManager.fire(Action(ActionType.ACTION_TRENDING_REPOS))
        }
    }

    private fun fireAction(action: Action) {
        when (action.type) {
            ActionType.UNKNOWN -> Log.w(javaClass.simpleName, "Unknown Action Fired!")
            ActionType.ACTION_TRENDING_REPOS -> transition(TrendingReposFragment.newInstance(), replace = false)
            ActionType.ACTION_REPO -> Log.w(javaClass.simpleName, "${action.type} is not implemented yet!")
        }
    }

    private fun transition(fragment: BaseFragment, keepCurrent: Boolean = true,
                           replace: Boolean = true) {
        if (!keepCurrent && supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }

        val transaction = supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)

        if (replace) {
            transaction
                    .replace(R.id.container, fragment)
                    .addToBackStack(fragment.javaClass.simpleName)
        } else {
            transaction.add(R.id.container, fragment)
        }

        transaction.commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector
}
