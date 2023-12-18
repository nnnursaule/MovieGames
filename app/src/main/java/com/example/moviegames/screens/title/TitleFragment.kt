package com.example.moviegames.screens.title
import android.os.Bundleimport androidx.fragment.app.Fragment
import android.view.LayoutInflaterimport android.view.View
import android.view.ViewGroupimport android.widget.Toast
import androidx.databinding.DataBindingUtilimport androidx.navigation.fragment.findNavController
import com.example.game.Rimport com.example.game.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.startBtn.setOnClickListener { view:View->

            if (binding.etName.text!!.isNotEmpty()){
                val action = TitleFragmentDirections.actionTitleFragmentToGameFragment()                action.name = binding.etName.text.toString()
                findNavController().navigate(action)            } else{
                Toast.makeText(context, "Enter your name to start", Toast.LENGTH_SHORT).show()
            }
        }



        return  binding.root

    }
}