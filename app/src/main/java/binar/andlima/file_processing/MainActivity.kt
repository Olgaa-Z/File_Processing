package binar.andlima.file_processing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.file_processing.handleimage.HandleImage
import binar.andlima.file_processing.handleimage.ImagehandleActivity
import binar.andlima.file_processing.handlepdf.HandlePdf
import binar.andlima.file_processing.handlevideo.HandleVideo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handlePdf.setOnClickListener { startActivity(Intent(this, HandlePdf::class.java)) }
        handleImage.setOnClickListener { startActivity(Intent(this, HandleImage::class.java)) }
        handleVideo.setOnClickListener { startActivity(Intent(this, HandleVideo::class.java)) }
        imagehandle.setOnClickListener { startActivity(Intent(this, ImagehandleActivity::class.java)) }

    }
}