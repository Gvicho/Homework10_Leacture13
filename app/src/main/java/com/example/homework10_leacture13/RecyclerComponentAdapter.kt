package com.example.homework10_leacture13

import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10_leacture13.databinding.ItemProfileComponentBinding

class RecyclerComponentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val Item_Type_1 = 1
        const val Item_Type_2 = 2
        const val Item_Type_3 = 3
    }

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
        if(differ.currentList[position].type == Item_Type_1){
            return Item_Type_1
        }else if(differ.currentList[position].type == Item_Type_2){
            return Item_Type_2
        }else{
            return Item_Type_3
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Component>() {

        override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: MutableList<Component>) {
        differ.submitList(list)
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

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ComponentViewHolder)holder.bind(differ.currentList[position])
        else if(holder is ComponentViewHolder1)holder.bind(differ.currentList[position])
        else if(holder is ComponentViewHolder2)holder.bind(differ.currentList[position])
    }

}