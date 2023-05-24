package com.example.nathaliariegler_rm87498

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class QuestaoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questao, container, false)
        val button = view.findViewById<Button>(R.id.)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_questaoFragment)
        }
    }


}