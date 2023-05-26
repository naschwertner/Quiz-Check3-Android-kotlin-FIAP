package com.example.nathaliariegler_rm87498

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Encontra o botão no layout
        val button = view.findViewById<Button>(R.id.startBtn)

        // Define um OnClickListener no botão
        button.setOnClickListener {
            // Navega para a fragmento "Questões" quando o botão é clicado
            findNavController().navigate(R.id.action_homeFragment_to_questaoFragment)
        }


        return view
    }


}