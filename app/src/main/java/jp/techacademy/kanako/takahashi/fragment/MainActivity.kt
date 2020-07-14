package jp.techacademy.kanako.takahashi.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonmain)
        button.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, FragmentA.createInstance())
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}