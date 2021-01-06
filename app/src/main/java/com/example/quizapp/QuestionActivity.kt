package com.example.quizapp

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPos: Int = 1
    private var mQuestionList: ArrayList<Ques>? = null
    private var mSelectedOptionPos: Int = 0
    private var mCorrectAns: Int = 0
    private var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        defaultOptionsView()

        mQuestionList = Constants.getQuestion()
        setQuestion()

        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){
        val ques = mQuestionList!![mCurrentPos-1]

        defaultOptionsView()

        progress_bar.progress = mCurrentPos
        tv_progress.text = "${mCurrentPos} / ${mQuestionList!!.size}"

        btn_submit.text = "SUBMIT"

        tv_question.text = ques.question
        iv_image.setImageResource(ques.image)
        tv_option1.text = ques.option1
        tv_option2.text = ques.option2
        tv_option3.text = ques.option3
        tv_option4.text = ques.option4
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option1)
        options.add(1,tv_option2)
        options.add(2,tv_option3)
        options.add(3,tv_option4)

        for(option in options){
            option.setTextColor(Color.GRAY)
            option.background = ContextCompat.getDrawable(this, R.drawable.defaul_option_bg)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPos = selectedOptionNum
        tv.setTextColor(Color.BLACK)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_bg_option)
    }

    private fun answerView(ans: Int, drawableView: Int){
        when(ans){
            1 ->{
                tv_option1.background = ContextCompat.getDrawable(this, drawableView)
                tv_option1.setTextColor(Color.WHITE)
            }
            2 ->{
                tv_option2.background = ContextCompat.getDrawable(this, drawableView)
                tv_option2.setTextColor(Color.WHITE)
            }
            3 ->{
                tv_option3.background = ContextCompat.getDrawable(this, drawableView)
                tv_option3.setTextColor(Color.WHITE)
            }
            4 ->{
                tv_option4.background = ContextCompat.getDrawable(this, drawableView)
                tv_option4.setTextColor(Color.WHITE)
            }
        }
    }

    override fun onBackPressed() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setCancelable(false)
        alertDialog.setTitle("Warning")
        alertDialog.setMessage("Do you want to exit?")
        alertDialog.setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        alertDialog.setNegativeButton("No") { dialog: DialogInterface?, which: Int -> }
        alertDialog.show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option1 ->{
                if(!isChecked)
                    selectedOptionView(tv_option1, 1)
            }
            R.id.tv_option2 ->{
                if(!isChecked)
                    selectedOptionView(tv_option2, 2)
            }
            R.id.tv_option3 ->{
                if(!isChecked)
                    selectedOptionView(tv_option3, 3)
            }
            R.id.tv_option4 ->{
                if(!isChecked)
                    selectedOptionView(tv_option4, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPos == 0){
                    when{
                        !isChecked ->{
                            Toast.makeText(this, "Please select at least one option", Toast.LENGTH_SHORT).show()
                        }
                        mCurrentPos <= mQuestionList!!.size ->{
                            setQuestion()
                            isChecked = false
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANS, mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUES, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else{
                    isChecked = true
                    val ques = mQuestionList?.get(mCurrentPos-1)
                    if(ques!!.correctOption != mSelectedOptionPos){
                        answerView(mSelectedOptionPos, R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAns++
                    }
                    answerView(ques.correctOption, R.drawable.correct_option_bg)

                    if(mCurrentPos == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPos = 0
                    mCurrentPos++
                }
            }
        }
    }
}