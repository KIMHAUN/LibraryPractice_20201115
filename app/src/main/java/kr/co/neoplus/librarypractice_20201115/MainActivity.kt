package kr.co.neoplus.librarypractice_20201115

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {
            //ACTION_CALL을 이용해서 바로 전화 연결 - 권한 획득 처리 같이 진행
            //tedPermission라이브러리 활용

            //권한 상태에 따른 행동 요령(가이드북-Listener) 작성

            //object : 가이드북을 담기 위한 임시 (익명) 클래스
            // :PermissionListener :object가 어떤 종류의 가이드북을 담는지
            val pl = object : PermissionListener{

                //권한이 승인됐을 때 -> 전화 연결
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:010-1234-5678")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                //거부 됐을 때-> 통화연결 불가 토스트
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되어 통화연결이 불가능합니다.", Toast.LENGTH_SHORT).show()

                }
            }

            //가이드북을 들고 실제로 권한 체크 실행.
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("전화 권한 거부")
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()




        }
        viewPhotoBtn.setOnClickListener {
            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            myIntent.putExtra("src", "@drawable/iu")
            startActivity(myIntent)
        }

        firstImg.setOnClickListener {

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            val myUri = Uri.parse("http://i.ytimg.com/vi/yPoXG50WrHs/maxresdefault.jpg")
            myIntent.putExtra("src", myUri)
            startActivity(myIntent)
        }

    }

    override fun setValues() {
        Glide.with(mContext).load("http://i.ytimg.com/vi/yPoXG50WrHs/maxresdefault.jpg").into(firstImg)
        Glide.with(mContext).load("https://i.ytimg.com/vi/4Ajru7bXxU0/maxresdefault.jpg").into(secondImg)

    }
}