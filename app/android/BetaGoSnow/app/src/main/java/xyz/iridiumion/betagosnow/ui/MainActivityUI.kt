package xyz.iridiumion.betagosnow.ui

import org.jetbrains.anko.*
import xyz.iridiumion.betagosnow.MainActivity

/**
 * Author: 0xFireball, IridiumIon Software
 */

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { ctx.toast("Hello, ${name.text}!") }
            }
        }
    }
}