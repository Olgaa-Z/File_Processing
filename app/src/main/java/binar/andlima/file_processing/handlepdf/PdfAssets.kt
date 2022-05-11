package binar.andlima.file_processing.handlepdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.andlima.file_processing.R
import kotlinx.android.synthetic.main.activity_pdf_assets.*

class PdfAssets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_assets)

        //tambahkan external read-write storage di manifest

        showPdffromAssets(getPdfNameFromAssets())


    }



    fun showPdffromAssets(pdfName : String){
        pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .onPageError{page, _ ->
                Toast.makeText(this, "Error at page $page",Toast.LENGTH_SHORT).show()
            }
            .load()
    }

    fun getPdfNameFromAssets():String{
        return "kotlin-media-kit.pdf"
    }
}