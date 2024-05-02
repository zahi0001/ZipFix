package com.codepath.zipfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parse.ParseObject
import android.widget.Button
import com.parse.ParseUser


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val current_user = ParseUser.getCurrentUser()
        val login_log = ParseObject("logsLogins")
        login_log.put("user", current_user.getUsername())
        login_log.saveInBackground()

        findViewById<Button>(R.id.logout_button).setOnClickListener {
            logout_user()
        }
    }
    private fun logout_user() {
        ParseUser.logOut()
        return_to_login()
    }

    private fun return_to_login() {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
