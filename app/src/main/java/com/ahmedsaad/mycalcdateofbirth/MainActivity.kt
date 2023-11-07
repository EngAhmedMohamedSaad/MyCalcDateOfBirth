package com.ahmedsaad.mycalcdateofbirth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txtAge
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        btnCalc.setOnClickListener{  txtAge.text = (Calendar.getInstance().get(Calendar.YEAR) - txtBYear.text.toString().toInt()).toString() }
        btnAct2.setOnClickListener{ val i2 = Intent(this , Activity2::class.java); startActivity(i2) }
        btnGoToScreen2Other.setOnClickListener{val i2 = Intent("Activity2");startActivity(i2)}
        btnCloseNow2.setOnClickListener{ exitProcess(-2) }
    }
    fun btnSayHello_click(view:View){var str = "Hello  ${txtName.text.toString()} " ; Toast.makeText(this,str , Toast.LENGTH_LONG).show()}
}