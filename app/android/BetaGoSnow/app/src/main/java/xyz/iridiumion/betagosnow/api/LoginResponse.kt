package xyz.iridiumion.betagosnow.api

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonObject

/**
 * Created by nihal on 12/11/16.
 */
class LoginResponse(public val obj: JsonObject) {
    val apikey: String by obj.byString
}