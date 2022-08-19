package constanta.testtask.filmsapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import constanta.testtask.filmsapplication.databinding.FragmentListFilmsBinding
import constanta.testtask.filmsapplication.ui.fragment.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFilmsFragment : Fragment() {

    private lateinit var viewModel: ListFilmsViewModel
    private lateinit var binding: FragmentListFilmsBinding
    private var adapter: FilmsAdapter = FilmsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListFilmsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ListFilmsViewModel::class.java)
        binding.mainRecView.adapter = adapter

        viewModel.all.observe(viewLifecycleOwner){
            it.let {
                adapter.updateAll(it.items.sortedBy { it.releaseYear })
                binding.mainRecView.layoutManager = LinearLayoutManager(context)
            }
        }
        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance() = ListFilmsFragment()
    }

}