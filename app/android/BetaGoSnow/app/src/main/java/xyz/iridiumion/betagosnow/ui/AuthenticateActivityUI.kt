package xyz.iridiumion.betagosnow.ui

import android.content.Context
import android.content.ContextWrapper
import android.content.res.TypedArray
import android.graphics.Color
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.support.v7.view.ContextThemeWrapper
import android.text.*
import android.util.TypedValue
import android.view.View
import android.widget.Button
import org.jetbrains.anko.*
import xyz.iridiumion.betagosnow.AuthenticateActivity
import xyz.iridiumion.betagosnow.R

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
            val loginPerspective = verticalLayout {
                id = LOGIN_PERSPECTIVE_ID
                editText {
                    hint = "Username"
                }
                editText {
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                button("Connect") {
                }
            }
            loginPerspective.visibility = View.GONE
            val signupPerspective = verticalLayout {
                id = SIGNUP_PERSPECTIVE_ID
                editText {
                    hint = "Username"
                }
                editText {
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                button("Register") {
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
                        .lparams(width = wrapContent)
                val btnLogin = button("Log In")
                        .lparams(width = wrapContent)
                btnLogin.onClick {
                    loginPerspective.visibility = View.VISIBLE
                    signupPerspective.visibility = View.GONE
                    btnRegister.visibility = View.VISIBLE
                    btnLogin.visibility = View.GONE
                    btnRegister.text = "Register Instead"
                    btnRegister.lparams(width = matchParent)
                }
                btnRegister.onClick {
                    loginPerspective.visibility = View.GONE
                    signupPerspective.visibility = View.VISIBLE
                    btnRegister.visibility = View.GONE
                    btnLogin.visibility = View.VISIBLE
                    btnLogin.text = "Log In Instead"
                    btnLogin.lparams(width = matchParent)
                }
            }
        }.applyRecursively {
            view ->
            when (view) {
                is Button -> {
                }
            }
        }
    }
}