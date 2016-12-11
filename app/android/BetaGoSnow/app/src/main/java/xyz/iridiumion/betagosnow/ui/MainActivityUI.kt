package xyz.iridiumion.betagosnow.ui

import android.view.View
import org.jetbrains.anko.*
import xyz.iridiumion.betagosnow.MainActivity

/**
 * Author: 0xFireball, IridiumIon Software
 */

class MainActivityUI : AnkoComponent<MainActivity> {
    companion object {
        val LAYOUT_ID = View.generateViewId()
        val BTN_REGISTER_ID = View.generateViewId()
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            id = LAYOUT_ID
            val name = editText()
            button("Say Hello") {
                id = BTN_REGISTER_ID
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }
}