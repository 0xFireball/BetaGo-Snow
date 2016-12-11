package xyz.iridiumion.betagosnow.ui

import android.content.Context
import android.content.ContextWrapper
import android.content.res.TypedArray
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.support.v7.view.ContextThemeWrapper
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

    val View.contextThemeWrapper: ContextThemeWrapper
        get() = context.contextThemeWrapper

    val Context.contextThemeWrapper: ContextThemeWrapper
        get() = when (this) {
            is ContextThemeWrapper -> this
            is ContextWrapper -> baseContext.contextThemeWrapper
            else -> throw IllegalStateException("Context is not an Activity, can't get theme: $this")
        }

    @StyleRes
    fun View.attrStyle(@AttrRes attrColor: Int): Int = contextThemeWrapper.attrStyle(attrColor)

    @StyleRes
    private fun ContextThemeWrapper.attrStyle(@AttrRes attrRes: Int): Int =
            attr(attrRes) {
                it.getResourceId(0, 0)
            }

    private fun <R> ContextThemeWrapper.attr(@AttrRes attrRes: Int, block: (TypedArray) -> R): R {
        val typedValue = TypedValue();
        if (!theme.resolveAttribute(attrRes, typedValue, true)) throw IllegalArgumentException("$attrRes is not resolvable")
        val a = obtainStyledAttributes(typedValue.data, intArrayOf(attrRes));
        val result = block(a)
        a.recycle()
        return result
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
                    attrStyle(R.attr.borderlessButtonStyle)
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
        }.applyRecursively {
            view ->
            when (view) {
                is Button -> {

                }
            }
        }
    }
}