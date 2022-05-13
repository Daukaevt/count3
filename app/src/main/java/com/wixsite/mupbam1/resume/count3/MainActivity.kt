package com.wixsite.mupbam1.resume.count3

//https://www.youtube.com/watch?v=Zlo3qpkZ1aI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.wixsite.mupbam1.resume.count3.databinding.ActivityMainBinding
import java.io.*

val fileName= "CountFile"

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val count=intent.getStringExtra("CountIntent")

        if (count != null) {
            saveData(fileName, count)
        }
        binding.launch.text=count
    }

    private fun saveData(fileName:String, count:String) {
        try {
            val writer= BufferedWriter(
                OutputStreamWriter(openFileOutput(
                    fileName,
                    MODE_PRIVATE))
            )
            writer.write(count)
            writer.close()
        }catch (e: Exception){
            Log.d("MyLog","$e")
        }
        catch (e: IOException){
            Log.d("MyLog","$e")
        }
    }
}
