package com.example.mysharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

lateinit var shared:SharedPreferences
public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared=getSharedPreferences("show", MODE_PRIVATE)
        val switch:Switch=findViewById(R.id.switch1)
        val textView:TextView=findViewById(R.id.viewtext)

        switch.isChecked=update("isOn")
            if(switch.isChecked){
                textView.text="Hello"
            }

        switch.setOnCheckedChangeListener(){_,isOn->
            if(isOn){
                textView.text="Hello"
                save("isOn",true)
            }
            else{
                textView.text=""
                save("isOn",false)
            }

        }
    }

    private fun save(key: String, status: Boolean) {
        val edit=shared.edit()
        edit.putBoolean(key,status)
        edit.commit()
    }
    private fun update (key:String):Boolean{
        return shared.getBoolean(key,false)

    }
}