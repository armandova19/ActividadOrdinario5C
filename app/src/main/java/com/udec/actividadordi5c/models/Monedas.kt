package com.udec.video_games.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Monedas(val id: Int, val name: String, val genre: MoneyGenre, val description: String, val valor: String, val porcentaje: String) :
    Parcelable {
    enum class MoneyGenre{
        Bitcoin,Ethereum, Cardano, Tether, BinanceCoin, Ripple, Dogecoin, USDCoin, Polkadot, Solana
    }
}