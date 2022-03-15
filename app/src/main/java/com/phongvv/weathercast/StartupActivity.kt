package com.phongvv.weathercast

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.phongvv.weathercast.databinding.ActivityStartupBinding

class StartupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bitmap = (ResourcesCompat.getDrawable(resources, R.drawable.icon, null)  as BitmapDrawable).bitmap
        val imageRounded = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        val canvas = Canvas(imageRounded)
        val paint = Paint()
        paint.apply {
            isAntiAlias = true
            shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }
        canvas.drawRoundRect(RectF(0F, 0F, bitmap.width.toFloat(), bitmap.height.toFloat()), 100F, 100F, paint)

    }
}