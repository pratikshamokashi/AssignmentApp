package com.equinoxlabs.demoassignmentapp.Presentation.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.equinoxlabs.demoassignmentapp.Presentation.view.userList.ListOfEmployee
import com.equinoxlabs.demoassignmentapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_go.setOnClickListener {
            val i = Intent(this,
                ListOfEmployee::class.java)
            startActivity(i)
        }
    }
}