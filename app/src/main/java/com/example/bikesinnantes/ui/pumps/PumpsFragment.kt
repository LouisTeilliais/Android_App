package com.example.bikesinnantes.ui.pumps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikesinnantes.adapter.PumpAdapter
import com.example.bikesinnantes.api.PumpApi
import com.example.bikesinnantes.api.RetrofitHelper
import com.example.bikesinnantes.api.StationApi
import com.example.bikesinnantes.databinding.FragmentDashboardBinding
import com.example.bikesinnantes.model.allPumps
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PumpsFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pumpViewModel =
            ViewModelProvider(this).get(PumpsViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView

        pumpViewModel.pumps.observe(viewLifecycleOwner) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = PumpAdapter(it, requireContext())
            allPumps = it
        }

        val pumpApi = RetrofitHelper().getInstance().create(PumpApi::class.java)
        GlobalScope.launch{
            val result = pumpApi.getPumps()
            pumpViewModel.pumps.postValue(result.body())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}