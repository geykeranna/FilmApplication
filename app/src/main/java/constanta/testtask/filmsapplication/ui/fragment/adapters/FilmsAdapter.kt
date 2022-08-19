package constanta.testtask.filmsapplication.ui.fragment.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import constanta.testtask.filmsapplication.R
import constanta.testtask.filmsapplication.api.model.Item

class FilmsAdapter:
    RecyclerView.Adapter<FilmsAdapter.MyViewHolder>(){

    private val filmItems = mutableListOf<Item>()

    fun updateAll(films: List<Item>){
        filmItems.clear()
        filmItems.addAll(films)
        Log.d("Adapter 111", filmItems.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("Adapter 112", filmItems.toString())
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("Adapter 113", filmItems.toString())
        holder.onBind(filmItems[position])
    }

    override fun getItemCount() = filmItems.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val filmTitle: TextView = itemView.findViewById(R.id.filmTitle)
        private val filmDirectorName: TextView = itemView.findViewById(R.id.filmDirectorName)
        private val recActor: RecyclerView = itemView.findViewById(R.id.recActor)
        private val adapter: ActorAdapter = ActorAdapter()

        init{
            recActor.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            recActor.adapter = adapter
        }

        fun onBind(films: Item) {
            val title = films.title + " (" + films.releaseYear.toString() + ")"
            filmTitle.text = title
            filmDirectorName.text = films.directorName
            adapter.updateAll(films.actors.distinctBy { it.actorName })

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Фильм " + films.title + " был нажат", Toast.LENGTH_LONG).show()
            }
        }
    }
}