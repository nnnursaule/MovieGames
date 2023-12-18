package com.example.moviegames.screens.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.moviegames.R
import com.example.moviegames.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    lateinit var binding: FragmentTitleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.startBtn.setOnClickListener { view:View->


            // checking if the name edittext is not empty
            if (binding.etName.text!!.isNotEmpty()){
                /// takes us to the next fragment to play game
                val action = TitleFragmentDirections.actionTitleFragmentToGameFragment()
                action.name = binding.etName.text.toString()
                findNavController().navigate(action)
            } else{

                Toast.makeText(context, "Enter your name to start", Toast.LENGTH_SHORT).show()
            }


        }







        return  binding.root


    }


}