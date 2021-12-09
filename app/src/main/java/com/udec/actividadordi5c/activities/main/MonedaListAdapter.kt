package com.udec.actividadordi5c.activities.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udec.video_games.databinding.GameListItemBinding
import com.udec.video_games.models.Monedas

class MonedaListAdapter(private val gameList: List<Monedas>) : RecyclerView.Adapter<MonedaListAdapter.ViewHolder>() {
    lateinit var onClick: (Monedas) ->Unit

    inner class ViewHolder(private val binding: GameListItemBinding )  : RecyclerView.ViewHolder(binding.root) {
        fun bind(criptomoney: Monedas){
            binding.gameId.text = criptomoney.id.toString()
            binding.name.text = criptomoney.name
            binding.genre.text = criptomoney.genre.name
            binding.root.setOnClickListener(){
                if (::onClick.isInitialized)
                    onClick(criptomoney)
                else
                    Log.i("edgAdapter", "the onGameListAdapter from GameListAdapter is not initialized")
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gameList[position])
    }

    override fun getItemCount(): Int {
        return gameList.count()
    }


}