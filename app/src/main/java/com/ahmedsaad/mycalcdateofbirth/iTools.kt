package permission.manager

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.R
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class iTools (activity:Activity) {

    var currentActivity:Activity = Activity()
    init {
        currentActivity = activity }

    fun checkPermission(permissionName:String):Boolean{

        return ContextCompat.checkSelfPermission(currentActivity, permissionName) == PackageManager.PERMISSION_GRANTED
    }

    fun iNeedPermission(permissionName: String , requestCode:Int = 26697){

        ActivityCompat.requestPermissions(currentActivity , arrayOf(permissionName) , requestCode)
    }

    fun toastShort(text:String){
        Toast.makeText(currentActivity ,text , Toast.LENGTH_SHORT ).show()
    }

    fun toastLong(text:String){
        Toast.makeText(currentActivity ,text , Toast.LENGTH_LONG ).show()
    }

    fun fillSpinner(spinner:Spinner , items:Array<String>){
        val a = ArrayAdapter(currentActivity ,R.layout.notification_action , items)
        spinner.adapter = a

    }

}