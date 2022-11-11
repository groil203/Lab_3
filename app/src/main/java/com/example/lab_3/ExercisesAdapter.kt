package com.example.lab_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_3.databinding.RecyclerRowBinding


class ExercisesAdapter(private val itemList: List<Pair<String, String?>>, private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ExercisesAdapter.ExercisesHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesHolder {
        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context))
        return ExercisesHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: ExercisesHolder, position: Int){
        val exData = itemList[position]
        holder.bind(exData.first, exData.second)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class ExercisesHolder(private val itemBinding: RecyclerRowBinding, private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }
        fun bind(exerciseName: String, exercisePhoto: String?){
            Glide.with(itemView)
                .load(exercisePhoto)
                .centerCrop()
                .placeholder(itemBinding.exercisesPictures.drawable)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(itemBinding.exercisesPictures)
            itemBinding.exercisesName.text = exerciseName
        }
    }
}