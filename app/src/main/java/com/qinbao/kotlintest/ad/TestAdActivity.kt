package com.qinbao.kotlintest.ad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bytedance.sdk.openadsdk.TTAdConstant
import com.qinbao.kotlintest.ConstantAd
import com.qinbao.kotlintest.R
import com.qinbao.kotlintest.util.SystemUtils
import com.s20cxq.ad.csj.help.CSJHelper
import com.s20cxq.ad.csj.listener.JHVideoADListener
import kotlinx.android.synthetic.main.activity_test_ad.*

class TestAdActivity : AppCompatActivity() {
    private val mCSJHelper = CSJHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_ad)
    }


    //我是改变的地方
    private fun initView() {
        //信息流横版广告  视频宽高比 1.78
        mCSJHelper.loadNativeExpressAd(
            this,
            ConstantAd.csj_NativeExpress_video1,
            ad_NativeExpress_fl,
            SystemUtils.getMinDp(this),
            0,
            true
        )
        //信息流广告 三图模板  图片比1.52
        mCSJHelper.loadNativeExpressAd(
            this,
            ConstantAd.csj_NativeExpress_three_img,
            ad_NativeExpress_three_pic_fl,
            SystemUtils.getMinDp(this),
            0,
            true
        )
        //插屏广告 图片比3:2
        CSJHelper().loadInteractionExpressAd(
            this,
            ConstantAd.csj_InteractionExpressAd,
            ad_InteractionExpress_fl,
            SystemUtils.getMinDp(this),
            0
        )
        //banner广告  底部banner
        mCSJHelper.loadBannerAd(
            this,
            ConstantAd.csjBannerId,
            csj_ad_frame_layout,
            SystemUtils.getMinDp(this),
            0,
            0,
            false
        )
    }


    private fun initClick() {
        //加载全屏广告
        load_TTFullScreenVideoAd_tv.setOnClickListener {
            mCSJHelper.loadTTFullScreenVideoAd(this, ConstantAd.csj_TTFullScreenVideoAd,
                TTAdConstant.VERTICAL, object : JHVideoADListener {
                    override fun onAdPlayComplete() {
                    }

                    override fun onAdSkip() {
                    }

                    override fun onAdClick() {
                    }

                    override fun onAdLoadComplete() {
                    }

                    override fun onAdClose() {
                    }
                })
        }
        //显示全屏广告  onAdPlayComplete之后播放视频
        show_TTFullScreenVideoAd_tv.setOnClickListener {
            mCSJHelper.showTTFullScreenVideoAd(this)
        }

        //加载激励视频广告
        load_RewardVideoAd_tv.setOnClickListener {
            mCSJHelper.loadTTRewardVideoAd(this, ConstantAd.csj_RewardVideoAd,
                TTAdConstant.VERTICAL, object : JHVideoADListener {
                    override fun onAdPlayComplete() {
                    }

                    override fun onAdSkip() {
                    }

                    override fun onAdClick() {
                    }

                    override fun onAdLoadComplete() {
                    }

                    override fun onAdClose() {
                    }
                })
        }
        //显示激励视频广告  onAdPlayComplete之后播放视频  再次播放需要重新先加载视频
        show_RewardVideoAd_tv.setOnClickListener {
            mCSJHelper.showTTRewardVideoAd(this)
        }

        //显示Draw信息流
        show_TTDrawFeedAd_tv.setOnClickListener {
            val intent = Intent(this, TTDrawFeedAdActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        CSJHelper().onDestroyCSJAd()
    }
}