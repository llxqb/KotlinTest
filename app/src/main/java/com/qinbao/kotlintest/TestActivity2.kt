package com.qinbao.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        vars(1,2,3,4)
    }

    /**
     *
     */
    private fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }
}