package com.codingstuff.loginandsignup

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class StartupActivity : AppCompatActivity() {

    //variables para hacer funcionar el video en StartUpActivity
    protected lateinit var vv_fondo: VideoView
    protected lateinit var mMediaPlayer: MediaPlayer
    protected var mCurrentVideoPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        //Intento al boton de iniciar sesion
        val sesion = findViewById <Button> ( R.id.sesion )
        sesion.setOnClickListener {
            var iniciar = Intent (this , SignInActivity :: class.java )
            startActivity ( iniciar )
        }

        //intento al boton de registrar
        val registrar = findViewById <Button> ( R.id.registrar )
        registrar.setOnClickListener {
            val registrar = Intent (this , SignUpActivity :: class.java )
            startActivity ( registrar )
        }

        //video de fondo
        vv_fondo= findViewById(R.id.videoView)
        val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.video1)
        vv_fondo.setVideoURI(uri)
        vv_fondo.start()
        vv_fondo.setOnPreparedListener { mp ->
            mMediaPlayer = mp
            mMediaPlayer.isLooping = true
            if (mCurrentVideoPosition != 0) {
                mMediaPlayer.seekTo(mCurrentVideoPosition)
                mMediaPlayer.start()
            }
        }
    }
    override fun onPause() {
        super.onPause()
        mCurrentVideoPosition = mMediaPlayer.currentPosition
        vv_fondo.pause()
    }
    override fun onResume() {
        super.onResume()
        vv_fondo.start()
    }
    override fun onDestroy() {
        super.onDestroy()

        mMediaPlayer.release()
    }

}