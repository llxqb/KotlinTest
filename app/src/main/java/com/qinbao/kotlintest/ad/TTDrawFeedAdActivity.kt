package com.qinbao.kotlintest.ad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.qinbao.kotlintest.ConstantAd
import com.qinbao.kotlintest.R
import com.qinbao.kotlintest.util.SystemUtils
import com.s20cxq.ad.csj.bean.DrawItem
import com.s20cxq.ad.csj.help.CSJHelper
import com.s20cxq.ad.csj.listener.JHDrawNativeADListener
import kotlinx.android.synthetic.main.activity_t_t_draw_feed_ad.*

/**
 * 个性化模板Draw信息流
 */
class TTDrawFeedAdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_t_draw_feed_ad)
        val drawItem  = DrawItem(1,null,-1,-1)
        CSJHelper().loadTTDrawFeedAd(this,
            ConstantAd.csj_TTDrawFeedAd,
            SystemUtils.getMinDp(this),
            0,drawItem,object :JHDrawNativeADListener{
                override fun onAdClicked() {
                }

                override fun onRenderSuccess(mutableList: MutableList<DrawItem>) {
                    Log.e("tt","---"+mutableList.size)
                    if(mutableList.size>0){
                        TTDrawFeedAd_fl.addView(mutableList[0].ad.expressAdView)
                    }
                }
            })
    }
}
