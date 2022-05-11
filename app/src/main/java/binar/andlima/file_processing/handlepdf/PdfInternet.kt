package binar.andlima.file_processing.handlepdf

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import binar.andlima.file_processing.R
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import kotlinx.android.synthetic.main.activity_pdf_internet.*
import java.io.File

class PdfInternet : AppCompatActivity() {

    val PDF_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_internet)

        checkPdf(intent)
        PRDownloader.initialize(applicationContext)

    }

    private fun checkPdf(intent: Intent) {

                // perform action to show pdf from the internet
                val fileName = "myFile.pdf"
                downloadPdfFromInternet(
                    getPdfUrl(),
                    getRootDirPath(this),
                    fileName
                )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PDF_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedPdfFromStorage = data.data
            showPdfFromUri(selectedPdfFromStorage)
        }
    }


    private fun showPdfFromUri(uri: Uri?) {
        pdfViewInternet.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    private fun downloadPdfFromInternet(url: String, dirPath: String, fileName: String) {
        PRDownloader.download(
            url,
            dirPath,
            fileName
        ).build()
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    Toast.makeText(this@PdfInternet, "downloadComplete", Toast.LENGTH_LONG)
                        .show()
                    val downloadedFile = File(dirPath, fileName)
                    showPdfFromFile(downloadedFile)
                }

                override fun onError(error: com.downloader.Error?) {
                    Toast.makeText(
                        this@PdfInternet,
                        "Error in downloading file : $error",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }


            })
    }

    private fun showPdfFromFile(file: File) {
        pdfViewInternet.fromFile(file)
            .password(null)
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageError { page, _ ->
                Toast.makeText(
                    this@PdfInternet,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()
    }




    fun getPdfUrl(): String {
        return "https://kotlinlang.org/assets/kotlin-media-kit.pdf"
    }

    fun getRootDirPath(context: Context): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val file: File = ContextCompat.getExternalFilesDirs(
                context.applicationContext,
                null
            )[0]
            file.absolutePath
        } else {
            context.applicationContext.filesDir.absolutePath
        }
    }





}