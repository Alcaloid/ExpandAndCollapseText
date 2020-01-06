package com.codemobile.rcvcollab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codemobile.rcvcollab.newexpandtext.ExpandTextActivity
import com.codemobile.rcvcollab.oldexpandtext.RCVCollabActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val intent:Intent = Intent(this, RCVCollabActivity::class.java)
            startActivity(intent)
        }
        btn_new.setOnClickListener {
            val intent:Intent = Intent(this, ExpandTextActivity::class.java)
            startActivity(intent)
        }
    }
}
