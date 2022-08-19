package constanta.testtask.filmsapplication.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import constanta.testtask.filmsapplication.R
import constanta.testtask.filmsapplication.api.model.Actor
import constanta.testtask.filmsapplication.api.model.Item

class ActorAdapter():
    RecyclerView.Adapter<ActorAdapter.MyViewHolder>(){

    private val actorItems = mutableListOf<Actor>()

    fun updateAll(actor: List<Actor>){
        actorItems.clear()
        actorItems.addAll(actor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.actor_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.onBind(actorItems[position])

    override fun getItemCount() = actorItems.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val actorTextView: TextView = itemView.findViewById(R.id.actorTextView)

        fun onBind(actor: Actor) {
            actorTextView.text = actor.actorName
        }
    }
}