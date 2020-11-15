package kr.co.neoplus.librarypractice_20201115

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        viewPhotoBtn.setOnClickListener {
            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            myIntent.putExtra("src", "@drawable/iu")
            startActivity(myIntent)
        }

        firstImg.setOnClickListener {

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            myIntent.putExtra("src", "http://i.ytimg.com/vi/yPoXG50WrHs/maxresdefault.jpg")
            startActivity(myIntent)
        }

    }

    override fun setValues() {
        Glide.with(mContext).load("http://i.ytimg.com/vi/yPoXG50WrHs/maxresdefault.jpg").into(firstImg)
        Glide.with(mContext).load("https://i.ytimg.com/vi/4Ajru7bXxU0/maxresdefault.jpg").into(secondImg)

    }
}