package xyz.iridiumion.betagosnow.api.client

import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import meta.BetaGoServerLocation

/**
 * Created by nihal on 12/10/16.
 */

class BetaGoClientAutomator constructor(val serverAddress: String) {
    init {

    }

    fun attemptLogin(username: String, password: String): Pair<Boolean, String> {
        val (request, response, result) = (serverAddress + "/login").httpPost(listOf(Pair("username", username), Pair("password", password))).responseString()
        // process response
        when (result) {
            is Result.Failure -> {
                return Pair(false, response.httpResponseMessage)
            }
            is Result.Success -> {
                return Pair(false, result.get())
            }
        }
    }

    companion object {
        // static stuff
        fun getClient(): BetaGoClientAutomator {
            val serverAddr = BetaGoServerLocation.get();
            return BetaGoClientAutomator(serverAddr)
        }
    }

}