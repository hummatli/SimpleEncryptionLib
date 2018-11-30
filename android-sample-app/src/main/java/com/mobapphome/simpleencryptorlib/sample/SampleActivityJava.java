package com.mobapphome.simpleencryptorlib.sample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.mobapphome.simpleencryptorlib.Constants;
import com.mobapphome.simpleencryptorlib.SimpleEncryptor;
import com.mobapphome.simpleencryptorlib.R;

public class SampleActivityJava extends AppCompatActivity implements View.OnClickListener {

    EditText editTextOriginal;
    EditText editTextEnchrypted;
    EditText editTextKeyPhrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This block is only in Java sample---------------
        {
            findViewById(R.id.btnOpenJavaSample).setVisibility(View.GONE);
            setTitle(getString(R.string.title_java_sample));
        }

        editTextKeyPhrase = (EditText) findViewById(R.id.etKeyPhrase);
        editTextOriginal = (EditText) findViewById(R.id.etOriginalTxt);
        editTextEnchrypted = (EditText) findViewById(R.id.etEnchryptedTxt);


        ImageView imageView = (ImageView) findViewById(R.id.ivForkMeOnGithub);
        Drawable forkMeImg = getResources().getDrawable(R.drawable.forkme_green);
        // setting the opacity (alpha)
        forkMeImg.setAlpha(180);
        // setting the images on the ImageViews
        imageView.setImageDrawable(forkMeImg);

        imageView.setOnClickListener(this);
        findViewById(R.id.btnDechrypt).setOnClickListener(this);
        findViewById(R.id.btnEnchrypt).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.ivForkMeOnGithub) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.MAH_ENCHRIPTOR_GITHUB_LINK));
            startActivity(browserIntent);
        } else if (view.getId() == R.id.btnEnchrypt
                || view.getId() == R.id.btnDechrypt) {

            try {
                String keyPhraseTxt = editTextKeyPhrase.getText().toString().trim();
                if (keyPhraseTxt.isEmpty()) {
                    new AlertDialog.Builder(this)
                            .setTitle("Caution!")
                            .setMessage("Key phrase is empty. Fill it and continue.")
                            .setPositiveButton("Ok", null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    return;
                }

                if (view.getId() == R.id.btnEnchrypt) {
                    SimpleEncryptor simpleEncryptor = SimpleEncryptor.newInstance(keyPhraseTxt);

                    String originaltxt = editTextOriginal.getText().toString().trim();
                    if (originaltxt.isEmpty()) {
                        new AlertDialog.Builder(this)
                                .setTitle("Caution!")
                                .setMessage("Original string is empty. Fill it and continue.")
                                .setPositiveButton("Ok", null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                        return;
                    }
                    editTextEnchrypted.setText(simpleEncryptor.encode(originaltxt));

                } else if (view.getId() == R.id.btnDechrypt) {
                    SimpleEncryptor simpleEncryptor = SimpleEncryptor.newInstance(keyPhraseTxt);

                    String enchryptedTxt = editTextEnchrypted.getText().toString().trim();
                    if (enchryptedTxt.isEmpty()) {
                        new AlertDialog.Builder(this)
                                .setTitle("Caution!")
                                .setMessage("Enchrypted string is empty. Fill it and continue.")
                                .setPositiveButton("Ok", null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                        return;
                    }
                    editTextOriginal.setText(simpleEncryptor.decode(enchryptedTxt));
                }
            } catch (Exception e) {
                new AlertDialog.Builder(this)
                        .setTitle("Exception")
                        .setMessage(e.getMessage())
                        .setPositiveButton("Ok", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return;
            }
        }
    }
}
