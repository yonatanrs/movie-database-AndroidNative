package com.yonatanrs.moviedatabase.presentation.misc.bottomnavcomponent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Yonatan on 10/07/23.
 * Modified by Yonatan Ripandra Sinaga on 10/07/2023
 * BottomNavHistory maintains history for user's navigation of bottom tabs, it stores latest unique history
 * User action: Tab 1 -> Tab 2 -> Tab 3 -> Tab 2
 * Result: Tab 1 -> Tab 3 -> Tab 2
 */

@Parcelize
data class BottomNavHistory(
    private val backStack: ArrayList<Int> = arrayListOf()
): Parcelable {
    val size: Int
        get() = backStack.size

    val isEmpty: Boolean
        get() = backStack.isEmpty()

    val isNotEmpty: Boolean
        get() = backStack.isNotEmpty()

    fun push(entry: Int) {
        if (backStack.contains(entry)) {
            backStack.run {
                remove(entry)
                add(entry)
            }
        } else backStack.add(entry)
    }

    fun pop(exit: Int) {
        backStack.remove(exit)
    }

    fun current() = backStack.last()

    fun clear() {
        backStack.clear()
    }
}