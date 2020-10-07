package com.dashboard.dojoin.Network

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.dashboard.dojoin.R
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity():AppCompatActivity(), RadioGroup.OnCheckedChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        radioGroup.setOnCheckedChangeListener(this)
        radioGroup2.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        if(radioPerform.isChecked){

            constraintLayout.visibility = View.VISIBLE
        }
        if(radioBookTime.isChecked){

            constraintLayout2.visibility=View.VISIBLE
            appCompatTextView6.text = getString(R.string.note_1)
        }
        if(radioDropIn.isChecked){
            constraintLayout2.visibility=View.VISIBLE
            appCompatTextView6.text = getString(R.string.note_2)

        }


    }
}