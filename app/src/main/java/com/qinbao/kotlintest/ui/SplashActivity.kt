package com.qinbao.kotlintest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.qinbao.kotlintest.ConstantAd
import com.qinbao.kotlintest.MainActivity
import com.qinbao.kotlintest.R
import com.s20cxq.ad.csj.help.CSJHelper
import com.s20cxq.ad.csj.listener.JHSplashADListener
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        splash_container
        CSJHelper().loadSplashAd(this,
            ConstantAd.csjSplashId2, splash_container,
            object : JHSplashADListener {
                override fun onAdClicked() {
                    Log.e("splash", "onAdClicked()")
                }

                override fun onAdSkip() {
                    Log.e("splash", "onAdSkip()")
                    startMainActivity()
                }

                override fun onAdTimeOver() {
                    Log.e("splash", "onAdTimeOver()")
                    startMainActivity()
                }

                override fun onError(p0: Int, p1: String?) {
                    startMainActivity()
                }
            }
        )
    }

    private fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
