package com.qinbao.kotlintest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.sdk.openadsdk.TTAdConstant
import com.qinbao.kotlintest.ad.TestAdActivity
import com.qinbao.kotlintest.ui.KotlinTestActivity
import com.s20cxq.ad.csj.help.CSJHelper
import com.s20cxq.ad.csj.listener.JHVideoADListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"
    private val mCSJHelper = CSJHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        to_ad_page_btn.setOnClickListener(this)
        to_test_kotlin_page_btn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.to_ad_page_btn -> {
                startActivity(Intent(this, TestAdActivity::class.java))
            }
            R.id.to_test_kotlin_page_btn -> {
                startActivity(Intent(this, KotlinTestActivity::class.java))
            }
        }
    }


}
