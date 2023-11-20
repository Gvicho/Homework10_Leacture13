package com.example.homework10_leacture13

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10_leacture13.databinding.ItemProfileComponentBinding

class RecyclerComponentAdapter: ListAdapter<Component, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    // There was no need for three viewHolders, but I just wanted to have a template for multytype items recycler adapter
    inner class ComponentViewHolder(private val binding: ItemProfileComponentBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(component: Component){
            when(component.icon){
                Icon.PROFILE -> {
                    binding.iconId.setImageResource(R.drawable.iv_profile)
                }
                Icon.LOCATION -> {
                    binding.iconId.setImageResource(R.drawable.location)
                }
                Icon.BELL -> {
                    binding.iconId.setImageResource(R.drawable.bell)
                }
                Icon.WALLET -> {
                    binding.iconId.setImageResource(R.drawable.wallet)
                }
                Icon.SECURITY-> {
                    binding.iconId.setImageResource(R.drawable.security)
                }
                Icon.LOCK-> {
                    binding.iconId.setImageResource(R.drawable.locker)
                }
                Icon.HELP-> {
                    binding.iconId.setImageResource(R.drawable.help)
                }
                Icon.FRIENDS-> {
                    binding.iconId.setImageResource(R.drawable.friends)
                }
                else -> {
                    binding.iconId.setImageResource(R.drawable.logout)
                    binding.tvNameComponent.setTextColor(Color.RED)
                    binding.nextRightBtn.visibility = View.GONE
                }
            }
            binding.tvNameComponent.text = component.icon.iconName
        }
    }

    inner class ComponentViewHolder1(private val binding: ItemProfileComponentBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(component: Component){
            when(component.icon){
                Icon.LANGUAGE ->{
                    binding.iconId.setImageResource(R.drawable.iv_language)
                }
                else ->{
                    binding.iconId.setImageResource(R.drawable.iv_language)
                }
            }
            binding.tvNameComponent.text = component.icon.iconName
            binding.tvLanguageComponent.visibility = View.VISIBLE
            binding.tvLanguageComponent.text = "English(USA)"
        }
    }

    inner class ComponentViewHolder2(private val binding: ItemProfileComponentBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(component: Component){
            when(component.icon){
                Icon.MODE ->{
                    binding.iconId.setImageResource(R.drawable.eye)
                }
                else ->{
                    binding.iconId.setImageResource(R.drawable.eye)
                }
            }
            binding.tvNameComponent.text = component.icon.iconName
            binding.switchId.visibility = View.VISIBLE
            binding.nextRightBtn.visibility = View.GONE
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item.type) {
            Item_Type_1 -> Item_Type_1
            Item_Type_2 -> Item_Type_2
            else -> Item_Type_3
        }
    }

    companion object {
        const val Item_Type_1 = 1
        const val Item_Type_2 = 2
        const val Item_Type_3 = 3

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Component>() {
            override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder{
        if(viewType == Item_Type_1){
            return ComponentViewHolder(
                ItemProfileComponentBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }else if(viewType == Item_Type_2){
            return ComponentViewHolder1(
                ItemProfileComponentBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }else{
            return ComponentViewHolder2(
                ItemProfileComponentBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val component = getItem(position)
        if(holder is ComponentViewHolder)holder.bind(component)
        else if(holder is ComponentViewHolder1)holder.bind(component)
        else if(holder is ComponentViewHolder2)holder.bind(component)
    }

}