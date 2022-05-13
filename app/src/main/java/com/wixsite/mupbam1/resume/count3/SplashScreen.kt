package com.wixsite.mupbam1.resume.count3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader

var countNotFound=""

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var count=readData(fileName)

        if (countNotFound=="0") count="0"
        var countValue= count.toInt()
        countValue++
        count=countValue.toString()
        if (countValue==3) {
            Toast.makeText(this, "Toast с произвольным текстом.", Toast.LENGTH_LONG).show()
        }

        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("CountIntent","$count")
        startActivity(intent)
        finish()
    }

    private fun readData(fileName: String): String {
        try {
            val reader = BufferedReader(InputStreamReader(openFileInput(fileName)))
            var line: String
            while ((reader.readLine().also { line = it })!=null) return line

        }catch (e: FileNotFoundException){
            e.printStackTrace()
            countNotFound="0"
        }catch (e: IOException){
            e.printStackTrace()

        }

        return null.toString()
    }
}