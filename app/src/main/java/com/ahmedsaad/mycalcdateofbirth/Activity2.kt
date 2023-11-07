package com.ahmedsaad.mycalcdateofbirth

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_2.*
import permission.manager.iTools
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception
import kotlin.system.exitProcess

/*
private val PackageManager.PERMISIION_GRATE: Any?
    get() {
        TODO("Not yet implemented")
    }


 */



class Activity2 : AppCompatActivity() {


    private  var t =  iTools(this )
    var WRITE_EXTERNAL_STORAGE = 255

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

         t.iNeedPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
         btnCloseNow.setOnClickListener{ exitProcess(-1)}

         btnBack.setOnClickListener{finish() }

     }

    fun btnSave_click(view:View){
        if (t.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))
            saveFile()
        else Toast.makeText(this, "i Need Permission", Toast.LENGTH_LONG).show()
    }
        /*
        if (ContextCompat.checkSelfPermission(this , Manifest.permission.WRITE_EXTERNAL_STORAGE )
            != packageManager.PERMISIION_GRATE ){
            ActivityCompat.requestPermissions(this , arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),WRITE_EXTERNAL_STORAGE)
        }
        else{saveFile()}
    }
    override fun onRequestPermissionsResult( requestCode: Int,permissions: Array<out String>,grantResults: IntArray) {
        when(requestCode){
            WRITE_EXTERNAL_STORAGE -> {
                if ((grantResults.isNotEmpty() && grantResults[0]== packageManager.PERMISIION_GRATE ))
                    saveFile()
                else  {}
            } } }
         */


    fun btnReadFile_click(view:View){
        if (t.checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE))
           showFile()
        else Toast.makeText(this, "i Need Permission", Toast.LENGTH_LONG).show()


    }

    fun saveFile(){
        try{
            var fw = FileWriter(Environment.getExternalStorageDirectory().path + "/my_file.txt")
            fw.write(txtWords.text.toString())
            fw.close()
        }
        catch (ex:Exception){
            Toast.makeText(this, ex.message,Toast.LENGTH_LONG).show()
        }
        t.toastLong("is saved")
        // Toast.makeText(this , "is Saved" ,Toast.LENGTH_LONG).show()
    }
    fun showFile(){

        try{
            var fr = FileReader(Environment.getExternalStorageDirectory().path + "/my_file.txt")
            var x:Int = 0
            var str:String = ""
            while (true){
                x = fr.read()

                str += x.toChar()
                if (x == -1) break
            }
            fr.close()
            txtWords.setText(str)
        }
        catch (ex:Exception){
            Toast.makeText(this, ex.message,Toast.LENGTH_LONG).show()
        }

    }


}