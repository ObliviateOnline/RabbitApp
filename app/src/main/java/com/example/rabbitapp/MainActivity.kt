package com.example.rabbitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.drake.brv.annotaion.AnimationType
import com.drake.brv.utils.BRV
import com.drake.brv.utils.addModels
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.example.rabbitapp.databinding.ActivityMainBinding
import com.example.rabbitapp.databinding.ItemSimpleBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var text = arrayOf("兔年大吉喜气临，昂首摆尾迎春来。双眼圆睁看世界，万水千山尽开颜。胡须翘翘美姿态，人人开心祝平安。巨大身躯摇摆摆，坎坷困境当笑谈。愿你兔年万事顺，吉星高照旺旺旺！",
        "兔年耳长长，招运进宝；兔年眼圆圆，风光无限；兔年腿蹦蹦，事业上冲；兔年尾短短，烦恼不见；兔年唇三瓣，快乐无限；兔年身白白，鸿运不歇；兔年舌舔舔，新年如愿！",
    "兔年好，兔年鞭炮正欢闹。兔年来，兔年嗨，兔年祝福最精彩，愿你如虎般舞出自己的锦绣前程，如虎般游出自己的甜美爱情，如虎般点燃自己的美丽心情。兔年快乐，大吉大利。",
    "一年一年开心过，开开心心，一生快快乐乐，一世平平安安，一家和和睦睦，愿你生命中的每一个愿望全能得到实现！新春快乐！",
    "兔年到，包水饺，萝卜白菜拌馅好；红灯笼，门前照，财神铺下金银道；放礼花，响鞭炮，祥光瑞气身边绕；要起早，多蹦跳，身康体健呱呱叫！",
    "兔年到来鞭炮闹，红妆对联也娇俏，迎春花儿悄然笑，祝福声声不停消，愿你在新年伊始之际把幸福紧紧套牢，把快乐紧紧拥抱，和好运互相依靠，把忧伤统统抛掉。兔年快乐。",
    "兔儿蹦兔儿跳，新年鸿运到；兔儿欢兔儿笑，新年身体好；兔儿睡得香，出门贵人帮；兔儿耳朵长，万事都吉祥；祝新年快乐，新年吉祥！",
    "兔儿蹦蹦跳，恭祝鸿运到；兔儿撒欢跑，恭祝身体好；兔儿睡得香，出门贵人帮；兔儿耳朵长，万事都吉祥；预祝新年快乐，兔年吉祥！",
    "兔年春节到，祝你事业路上金戈铁兔，健康路上英姿勃发，发财路上踏平坎坷，爱情路上朝歌彩霞；天天有人牵挂，职场顺利腾达，富贵荣誉共享，爱人携手天涯。祝兔年快乐！",
    "欢欢喜喜迎兔年，万事如意平安年，扬眉吐气顺心年，梦想成真发财年，事业辉煌成功年，祝君岁岁有好年！")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.attributes.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN

        binding.vMainList.linear().setup {
            addType<SimpleModel>(R.layout.item_simple)
            setAnimation(AnimationType.SLIDE_BOTTOM)

            onBind {
                val binding = getBinding<ItemSimpleBinding>() // 使用ViewBinding/DataBinding都可以使用本方法
                binding.tvName.text = getModel<SimpleModel>().name
            }
        }.models = getData()

        binding.runGif.setOnClickListener {
            val intent = Intent(this, WebViewTest::class.java)
            startActivity(intent)
        }

    }

    private fun getData(): MutableList<Any> {
        // 在Model中也可以绑定数据
        return mutableListOf<Any>().apply {
            for (i in 1..10) {
                val simpleModel = SimpleModel(
                    "$i、${text[i-1]}"
                    , i)
                add(simpleModel)
//            add(SimpleModel())
            }


        }
    }
}