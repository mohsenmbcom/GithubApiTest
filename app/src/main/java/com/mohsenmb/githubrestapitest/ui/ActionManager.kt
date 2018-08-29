package com.mohsenmb.githubrestapitest.ui

import android.os.Bundle
import java.util.*

class ActionManager {
    companion object {
        val instance: ActionManager by lazy {
            ActionManager()
        }
    }

    val actionStack: Stack<Action> = Stack()
    var onActionListener: ((Action) -> Unit)? = null

    fun fire(action: Action) {
        actionStack.push(action)
        onActionListener?.let {
            it(action)
        }
    }
}


data class Action(val type: ActionType, val data: Bundle? = null)

enum class ActionType {
    UNKNOWN,
    ACTION_TRENDING_REPOS,
    ACTION_REPO
}