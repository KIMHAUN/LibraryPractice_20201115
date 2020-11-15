package kr.co.neoplus.librarypractice_20201115

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_photo.*

class ViewPhotoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
    }

    override fun setValues() {
        val src = intent.getStringExtra("src")
        //bigImg.setImageURI(src)
       // bigImg.setImageResource(src)
    }


}