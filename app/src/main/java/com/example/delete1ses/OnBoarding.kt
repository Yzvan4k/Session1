package com.example.delete1ses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.delete1ses.databinding.ActivityOnBoardingBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoarding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val pagerview = findViewById<ViewPager2>(R.id.pagerview)
        val button = findViewById<Button>(R.id.button)


        val list = listOf(PagerData(R.drawable.oneview,"Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно"),
        PagerData(R.drawable.second,"Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно"),
            PagerData(R.drawable.third,"Обучение онлайн из любой точки мира\n" +
                    "Наше обучение изначально создавалось как дистанционное"))

        pagerview.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position:Int){
                if (position == 0){}
                if (position == 1){}
                if (position == 2){
                    button.text = "Начать"
                }
                super.onPageSelected(position)
            }
        })
        pagerview.adapter = ViewPagerAdapter(list)
        button.setOnClickListener {
            if (pagerview.currentItem == 2){
                startActivity(Intent(this,SignIn::class.java)) }
        pagerview.setCurrentItem(pagerview.currentItem+1)}

        TabLayoutMediator(tabs, pagerview,true){ tab: TabLayout.Tab, i: Int -> }.attach()
    }
}