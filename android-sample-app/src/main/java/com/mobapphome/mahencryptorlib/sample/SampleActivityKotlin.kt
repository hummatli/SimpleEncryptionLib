package com.mobapphome.mahencryptorlib.sample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

import com.mobapphome.mahencryptorlib.Constants
import com.mobapphome.mahencryptorlib.MAHEncryptor
import com.mobapphome.mahencryptorlib.R
import kotlinx.android.synthetic.main.activity_main.*

class SampleActivityKotlin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This block is only in Kotlin sample
        run {
            title = getString(R.string.title_kotlin_sample)
            btnOpenJavaSample.setOnClickListener {
                val intent = Intent(this, SampleActivityJava::class.java)
                startActivity(intent)
            }
        }


        val forkMeImg = ContextCompat.getDrawable(this, R.drawable.forkme_green)
        // setting the opacity (alpha)
        forkMeImg?.alpha = 180
        // setting the images on the ImageViews
        ivForkMeOnGithub.setImageDrawable(forkMeImg)

        ivForkMeOnGithub.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.MAH_ENCHRIPTOR_GITHUB_LINK))
            startActivity(browserIntent)
        }
        btnDechrypt.setOnClickListener {
            checkKeyPhrase { k ->
                val mahEncryptor = MAHEncryptor.newInstance(k)

                val enchryptedTxt = etEnchryptedTxt.text.toString().trim { it <= ' ' }
                if (enchryptedTxt.isEmpty()) {
                    AlertDialog.Builder(this)
                            .setTitle("Caution!")
                            .setMessage("Enchrypted string is empty. Fill it and continue.")
                            .setPositiveButton("Ok", null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show()
                    return@checkKeyPhrase
                }
                etOriginalTxt.setText(mahEncryptor.decode(enchryptedTxt))
            }
        }


        btnEnchrypt.setOnClickListener {
            checkKeyPhrase { k ->
                val mahEncryptor = MAHEncryptor.newInstance(k)

                val originaltxt = etOriginalTxt.text.toString().trim { it <= ' ' }
                if (originaltxt.isEmpty()) {
                    AlertDialog.Builder(this)
                            .setTitle("Caution!")
                            .setMessage("Original string is empty. Fill it and continue.")
                            .setPositiveButton("Ok", null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show()
                    return@checkKeyPhrase
                }
                etEnchryptedTxt.setText(mahEncryptor.encode(originaltxt))
            }
        }
    }


    fun checkKeyPhrase(f: (key: String) -> Unit) {
        try {
            val keyPhraseTxt = etKeyPhrase.text.toString().trim { it <= ' ' }
            if (keyPhraseTxt.isEmpty()) {
                AlertDialog.Builder(this)
                        .setTitle("Caution!")
                        .setMessage("Key phrase is empty. Fill it and continue.")
                        .setPositiveButton("Ok", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show()
                return
            }

            f(keyPhraseTxt)
        } catch (e: Exception) {
            AlertDialog.Builder(this)
                    .setTitle("Exception")
                    .setMessage(e.message)
                    .setPositiveButton("Ok", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            return
        }
    }
}
