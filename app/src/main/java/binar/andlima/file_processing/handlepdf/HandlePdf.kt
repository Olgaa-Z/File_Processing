package binar.andlima.file_processing.handlepdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.file_processing.R
import kotlinx.android.synthetic.main.activity_handle_pdf.*

class HandlePdf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_pdf)

        pdfWebview.setOnClickListener { startActivity(Intent(this, PdfWebview::class.java)) }
        pdfAssets.setOnClickListener { startActivity(Intent(this, PdfAssets::class.java)) }
        pdfPenyimpanan.setOnClickListener { startActivity(Intent(this, PdfStorage::class.java)) }
        pdfInternet.setOnClickListener { startActivity(Intent(this, PdfInternet::class.java)) }

    }
}