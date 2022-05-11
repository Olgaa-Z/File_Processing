package binar.andlima.file_processing.handlepdf

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Toast
import binar.andlima.file_processing.R
import kotlinx.android.synthetic.main.activity_pdf_storage.*

class PdfStorage : AppCompatActivity() {

    val PDF_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_storage)

        selectPdfFromStorage()
    }

    fun selectPdfFromStorage(){
        Toast.makeText(this, "Select PDF",Toast.LENGTH_SHORT).show()
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.type= "application/pdf"
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(
            Intent.createChooser(browseStorage,"Select PDF"),PDF_CODE)
    }

    fun showPdfFromUri(uri : Uri?){
        pdfViewStorage.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PDF_CODE && resultCode == Activity.RESULT_OK && data != null){
            val selectPdf = data.data
            showPdfFromUri(selectPdf)
        }
    }

//    private fun selectPdf() {
//        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
//        pdfIntent.type = "application/pdf"
//        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
//        startActivityForResult(pdfIntent, 12)
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//
//        // For loading PDF
//        when (requestCode) {
//            12 -> if (resultCode == RESULT_OK) {
//
//                pdfUri = data?.data!!
//                val uri: Uri = data?.data!!
//                val uriString: String = uri.toString()
//                var pdfName: String? = null
//                if (uriString.startsWith("content://")) {
//                    var myCursor: Cursor? = null
//                    try {
//                        // Setting the PDF to the TextView
////                        myCursor = applicationContext!!.contentResolver.query(uri, null, null, null, null)
////                        if (myCursor != null && myCursor.moveToFirst()) {
////                            pdfName = myCursor.getString(myCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
////                            resultPdf.text = pdfName
////                        }
//                        resultPdf.text = pdfName
//
//                    } finally {
//                        myCursor?.close()
//                    }
//                }
//            }
//        }
//    }



}