package com.example.travelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.travelapp.databinding.FragmentOrderTicketBinding

class OrderTicketFragment : Fragment() {

    private lateinit var binding: FragmentOrderTicketBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOrderTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding){
            val adapterTicket = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.ticket,
                R.layout.spinner_item
            )
            spinnerTicket.adapter = adapterTicket

            spinnerTicket.onItemSelectedListener =
                object: AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedTicket = parent?.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

            btnBuyTicket.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}