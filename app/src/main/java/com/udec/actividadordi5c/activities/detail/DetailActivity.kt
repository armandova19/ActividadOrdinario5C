package com.udec.actividadordi5c.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.udec.video_games.R
import com.udec.video_games.databinding.ActivityDetailBinding
import com.udec.video_games.models.Monedas

class DetailActivity : AppCompatActivity() {
    companion object{
        const val PRINCIPAL_KEY = "game_item"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if (bundle != null){
            val crimonedas = bundle.getParcelable<Monedas>(PRINCIPAL_KEY)

            binding.name.text = crimonedas?.name
            binding.score.text = crimonedas?.valor
            binding.description.text = crimonedas?.description
            binding.porcentage.text = crimonedas?.porcentaje

            val Icon = when (crimonedas?.genre){
                Monedas.MoneyGenre.Bitcoin -> R.drawable.bitcoin
                Monedas.MoneyGenre.Ethereum -> R.drawable.ethereum
                Monedas.MoneyGenre.Cardano -> R.drawable.cardano
                Monedas.MoneyGenre.Tether -> R.drawable.tether
                Monedas.MoneyGenre.BinanceCoin -> R.drawable.binance
                Monedas.MoneyGenre.Ripple -> R.drawable.ripple
                Monedas.MoneyGenre.Dogecoin -> R.drawable.dogecoin
                Monedas.MoneyGenre.USDCoin -> R.drawable.usdcoin
                Monedas.MoneyGenre.Polkadot -> R.drawable.polkadot
                Monedas.MoneyGenre.Solana -> R.drawable.solana

                else -> R.drawable.ic_launcher_foreground
            }
            binding.imageProfile.setImageResource(Icon)
        }
    }
}