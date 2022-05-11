package binar.andlima.file_processing.handlepdf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import binar.andlima.file_processing.R
import kotlinx.android.synthetic.main.activity_pdf_webview.*

class PdfWebview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_webview)

        val url = "https://kotlinlang.org/assets/kotlin-media-kit.pdf"


        webviewPdf.webViewClient = WebViewClient()
        webviewPdf.settings.setSupportZoom(true)
        webviewPdf.settings.javaScriptEnabled = true
        webviewPdf.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + "https://kotlinlang.org/assets/kotlin-media-kit.pdf")
    }
}