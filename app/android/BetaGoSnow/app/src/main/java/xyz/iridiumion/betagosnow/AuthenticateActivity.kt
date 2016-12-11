package xyz.iridiumion.betagosnow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.findOptional
import org.jetbrains.anko.setContentView
import xyz.iridiumion.betagosnow.ui.AuthenticateActivityUI

class AuthenticateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        AuthenticateActivityUI().setContentView(this)
    }
}

