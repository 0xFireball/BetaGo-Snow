package xyz.iridiumion.betagosnow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.setContentView
import xyz.iridiumion.betagosnow.ui.MainActivityUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this)
        findViewById(MainActivityUI.LOGIN_PERSPECTIVE_ID)
                .visibility = View.GONE
        findViewById(MainActivityUI.SIGNUP_PERSPECTIVE_ID)
                .visibility = View.GONE

    }
}

