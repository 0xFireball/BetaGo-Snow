package xyz.iridiumion.betagosnow.api.client

import meta.BetaGoServerLocation

/**
 * Created by nihal on 12/10/16.
 */

class BetaGoClientAutomator {
    companion object {
        // static stuff
        fun getClient(): Int {
            val serverAddr = BetaGoServerLocation.get();
            return 2;
        }
    }
}