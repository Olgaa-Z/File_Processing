package binar.andlima.file_processing.handleimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.file_processing.R
import kotlinx.android.synthetic.main.activity_handle_image.*

class HandleImage : AppCompatActivity() {

    val IMAGE_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_image)

        pickImage.setOnClickListener {
            pickImageFromGallery()
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_CODE && resultCode == RESULT_OK) {
            imageView.setImageURI(data?.data)
        }
    }
}