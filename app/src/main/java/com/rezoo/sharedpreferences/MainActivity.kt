package com.rezoo.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rezoo.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharePref = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = sharePref.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val name =edName.text.toString()
                val family =edFamily.text.toString()

                editor.apply {
                    putString("name",name)
                    putString("family",family)
                    apply()
                }
            }
            btnShow.setOnClickListener {
            val name = sharePref.getString("name",null)
            val family = sharePref.getString("family",null)
                tvName.text=name
                tvFamily.text= family
            }
        }
    }
}