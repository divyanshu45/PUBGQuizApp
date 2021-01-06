package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.ListItemClickListner{

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerViewAdapter()

        btn_random.setOnClickListener {
            startActivity(Intent(this, RandomQuesActivity::class.java))
            finish()
        }
    }

    private fun setRecyclerViewAdapter(){
        rv_modes.setHasFixedSize(true)
        rv_modes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = RecyclerAdapter(this, Constants.getCards(),this)
        rv_modes.adapter =adapter
    }

    override fun onCardClick(Index: Int) {
        when(Index){
            0 ->{
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
            1 ->{
                val intent = Intent(this, OtherQuesActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}