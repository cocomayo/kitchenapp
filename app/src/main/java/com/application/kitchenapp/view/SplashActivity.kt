package com.application.kitchenapp.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.application.kitchenapp.R
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SplashActivity, v 0.1 27/03/21 13.40 by Richo Mahardika
 */
class SplashActivity : AppCompatActivity() {
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                statusBarColor = ContextCompat.getColor(
                    this@SplashActivity,
                    R.color.colorPrimary
                )
            }
        }

        disposable.add(Flowable.timer(5000, TimeUnit.MILLISECONDS)
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}