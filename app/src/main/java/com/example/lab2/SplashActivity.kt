package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var list = ArrayList<String>()


        val thread = Thread() {
            val conn = URL("https://raw.githubusercontent.com/wesleywerner/" +
                    "ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src" +
                    "/data/techs.ruleset.json").openConnection()

            val reader = BufferedReader(InputStreamReader(conn.getInputStream()))

            var str : String? = ""
            str = reader.readLine()
            while (str != null) {
                list.add(str + "\n")
                str = reader.readLine()
            }
            reader.close()
        }

        thread.start()
        while (thread.isAlive) { }

//        Log.d("a", list.toString())
        intent = Intent(this, MainActivity::class.java)
        intent.putExtra("json", list)
        startActivity(intent)

    }

    override fun onRestart() {
        super.onRestart()

        finish()
    }
}
