package com.example.moviegames.screens.game
import android.graphics.Colorimport android.graphics.Typeface
import android.os.Bundleimport android.util.Log
import androidx.fragment.app.Fragmentimport android.view.LayoutInflater
import android.view.Viewimport android.view.ViewGroup
import android.widget.TextViewimport androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtilimport androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgsimport com.example.game.Constants
import com.example.game.Questionimport com.example.game.R
import com.example.game.databinding.FragmentGameBinding
class GameFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentGameBinding
    private lateinit var mQuestionsList : ArrayList<Question>
    private  var mSelectedPosition: Int = 0    private var mCorrectAnswer : Int = 0
    var mCurrrentPosition: Int = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        mQuestionsList = Constants.getQuestion()
        Log.i("info", mCurrrentPosition.toString())
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)        binding.btnSubmit.setOnClickListener(this)

        setQuestion()


        return binding.root
    }
    private fun setQuestion() {
        val question: Question = mQuestionsList[mCurrrentPosition -1]
        binding.tvQuestion.text = question.question
        binding.imageView.setImageResource(question.image)        binding.tvOptionOne.text = question.optionOne
                binding.tvOptionTwo.text = question.optionTwo        binding.tvOptionThree.text = question.optionThree
                binding.tvOptionFour.text = question.optionFour
        binding.pb.progress = mCurrrentPosition        binding.tvProgress.text = "$mCurrrentPosition" + "/" + binding.pb.max // displays question number
/// this resets the appearance for everytime a new question comes up
        defaultAppearance()
// if all questions in the lists are used
        if (mCurrrentPosition == mQuestionsList.size){
            binding.btnSubmit.text = "Quiz Finished"
        } else {
            binding.btnSubmit.text = "Submit"
        }



    }
    private fun defaultAppearance() {
        //controlling textview that share same behavior
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)        options.add(3, binding.tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            //default appearance            option.typeface = Typeface.DEFAULT
            option.background = context?.let { ContextCompat.getDrawable(it, R.drawable.default_option_border_bg) }
        }

    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_optionOne->{
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tv_optionTwo->{
                selectedOptionView(binding.tvOptionTwo, 2)

            }
            R.id.tv_optionThree->{
                selectedOptionView(binding.tvOptionThree, 3)

            }
            R.id.tv_optionFour->{
                selectedOptionView(binding.tvOptionFour, 4)


            }
            R.id.btnSubmit->{                // if user has not selected any option
                if (mSelectedPosition == 0){
                    mCurrrentPosition++ // when current position is increasing means index is increasing                    //if index is increasing that means we will get a new question from the question list