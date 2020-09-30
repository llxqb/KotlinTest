package com.qinbao.kotlintest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qinbao.kotlintest.R
import com.qinbao.kotlintest.util.LogUtils

class KotlinTestActivity : AppCompatActivity() {
    private var  arr ={1}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)
        vars(1,3,5,6)
        a()
    }

    /**
     * 可变长参数函数
     */
    private fun vars(vararg v:Int){
        LogUtils.i("v=$v")
        for(vt in v){
            LogUtils.i("vt=$vt") //1,3,5,6
        }


    }

    //lambda(匿名函数)    参数 -> 表达式
    //!!像Java一样抛出空异常  ?为空直接返回 null
    //区间表达式由具有操作符  ..  0..5 相当于 [0,5]
    //半开区间运算符until    0 until 5 相当于 [0,5)
    //const val  Kotlin的常量(编译期常量)
    //Bitmap，即位图。它本质上就是一张图片的内容在内存中的表达形式


    private fun a(){
        for (i in 1..9){
            if(i>0 and 5){

            }
            for (j in 1..i){
                print("$j×$i=${i * j}\\t")
                println()           //另起一行
            }
        }
    }
}