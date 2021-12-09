package com.udec.actividadordi5c.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.udec.video_games.R
import com.udec.actividadordi5c.activities.detail.DetailActivity
import com.udec.video_games.databinding.ActivityMainBinding
import com.udec.video_games.models.Monedas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val monedaList = mutableListOf<Monedas>(
            Monedas(1, "BTC", Monedas.MoneyGenre.Bitcoin, "Bitcoin", "1,014,390.49 mxn", "-5.87%"),
            Monedas(2, "ETH", Monedas.MoneyGenre.Ethereum, "Ethereum", "87,488.13 mxn",  "-6.51%"),
            Monedas(3, "ADA", Monedas.MoneyGenre.Cardano, "Cardano", "27.93 mxn", "-7.43%"),
            Monedas(4, "USDT", Monedas.MoneyGenre.Tether, "Tether", "21.02 mxn", "-0.03%"),
            Monedas(5, "BNB", Monedas.MoneyGenre.BinanceCoin, "Binance Coin", "12,102.02 mxn", "-3.81%"),
            Monedas(6, "XRP", Monedas.MoneyGenre.Ripple, "Ripple", "18.40 mxn", "-2.61%"),
            Monedas(7, "DOGE", Monedas.MoneyGenre.Dogecoin, "Dogecoin", "3.66 mxn", "-4.43%"),
            Monedas(8, "USDC", Monedas.MoneyGenre.USDCoin, "USDCoin", "20.99 mxn", "+0.02%"),
            Monedas(9, "DOT", Monedas.MoneyGenre.Polkadot, "Polkadot", "577.14 mxn", "-8.17%"),
            Monedas(10, "SOL", Monedas.MoneyGenre.Solana, "Solana", "3,810.05 mxn", "-7.61%")

        )
        val gameListAdapter = MonedaListAdapter(monedaList)

        binding.gameList.layoutManager = LinearLayoutManager(this)
        binding.gameList.adapter = gameListAdapter
        gameListAdapter.onClick = {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.PRINCIPAL_KEY, it)

            }
            startActivity(intent)

        }
    }
}