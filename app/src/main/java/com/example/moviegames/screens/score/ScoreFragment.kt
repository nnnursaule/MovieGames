package com.example.moviegames.screens.score
import android.os.Bundleimport androidx.fragment.app.Fragment
import android.view.LayoutInflaterimport android.view.View
import android.view.ViewGroupimport androidx.activity.addCallback
import androidx.databinding.DataBindingUtilimport androidx.navigation.findNavController
import androidx.navigation.fragment.navArgsimport com.example.game.R
import com.example.game.databinding.FragmentScoreBinding
class ScoreFragment : Fragment() {
    lateinit var binding: FragmentScoreBinding
    override fun onCreateView(        inflater: LayoutInflater, container: ViewGroup?,
                                      savedInstanceState: Bundle?    ): View? {
        val scoreArgs by navArgs<ScoreFragmentArgs>()
        binding.displayResult.text = "${scoreArgs.name}! you have scored ${scoreArgs.score} points out of 10"
        binding.playAgain.setOnClickListener{view: View->
            view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {

            view?.findNavController()?.navigate(R.id.action_scoreFragment_to_titleFragment)
        }

        return binding.root

    }


}