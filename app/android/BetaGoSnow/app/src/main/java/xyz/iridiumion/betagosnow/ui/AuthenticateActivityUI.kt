package xyz.iridiumion.betagosnow.ui

import android.view.View
import org.jetbrains.anko.*
import xyz.iridiumion.betagosnow.AuthenticateActivity

/**
 * Author: 0xFireball, IridiumIon Software
 */

class AuthenticateActivityUI : AnkoComponent<AuthenticateActivity> {
    companion object {
        val LAYOUT_ID = View.generateViewId()
        val LOGIN_PERSPECTIVE_ID = View.generateViewId()
        val SIGNUP_PERSPECTIVE_ID = View.generateViewId()
    }

    override fun createView(ui: AnkoContext<AuthenticateActivity>) = with(ui) {
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
            loginPerspective.visibility = View.GONE
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
            signupPerspective.visibility = View.GONE
            fun runMainApp() {
                //TODO: Launch main app
                // complete this activity
                ui.owner.finish()
            }

            val authPickerPerspective = linearLayout {
                val btnRegister = button("Register")
                val btnLogin = button("Log In")
                btnLogin.onClick {
                    loginPerspective.visibility = View.VISIBLE
                    signupPerspective.visibility = View.GONE
                    btnRegister.visibility = View.VISIBLE
                    btnLogin.visibility = View.GONE
                    btnRegister.text = "Register Instead"
                }
                btnRegister.onClick {
                    loginPerspective.visibility = View.GONE
                    signupPerspective.visibility = View.VISIBLE
                    btnRegister.visibility = View.GONE
                    btnLogin.visibility = View.VISIBLE
                    btnLogin.text = "Log In Instead"
                }
            }
        }
    }
}