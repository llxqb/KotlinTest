package com.qinbao.kotlintest

import android.app.Application
import com.s20cxq.ad.csj.help.CSJHelper

/**
 *  Created by li.liu  on 2020/8/25
 */
class App :Application() {
    override fun onCreate() {
        super.onCreate()
        CSJHelper().start(this,ConstantAd.csjAppId,"appName")
    }
}