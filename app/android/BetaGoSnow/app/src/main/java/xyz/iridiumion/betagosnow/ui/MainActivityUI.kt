package xyz.iridiumion.betagosnow.ui

import android.view.View
import android.view.View.GONE
import org.jetbrains.anko.*
import xyz.iridiumion.betagosnow.MainActivity

/**
 * Author: 0xFireball, IridiumIon Software
 */

class MainActivityUI : AnkoComponent<MainActivity> {
    companion object {
        val LAYOUT_ID = View.generateViewId()
        val LOGIN_PERSPECTIVE_ID = View.generateViewId()
        val SIGNUP_PERSPECTIVE_ID = View.generateViewId()
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            id = LAYOUT_ID
            padding = dip(30)
            val loginPerspective = linearLayout {
                id = LOGIN_PERSPECTIVE_ID
                editText {
                    hint = "Username"
                    textSize = 24f
                }
                editText {
                    hint = "Password"
                    textSize = 24f
                }
                button("Connect") {
                    textSize = 26f
                }
            }
            val signupPerspective = linearLayout {
                id = SIGNUP_PERSPECTIVE_ID
                editText {
                    hint = "Username"
                    textSize = 24f
                }
                editText {
                    hint = "Password"
                    textSize = 24f
                }
                button("Register") {
                    textSize = 26f
                }
            }
        }
    }
}