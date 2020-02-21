package com.anwesh.uiprojects.multicolorbouncyboxview

/**
 * Created by anweshmishra on 21/02/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.content.Context
import android.graphics.RectF
import android.graphics.Color
import android.graphics.Canvas

val colors : Array<String> = arrayOf("#3F51B5", "#4CAF50", "#f44336", "#0D47A1", "#D84315")
val rects : Int = 5
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
val deg : Float = 90f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawColorBouncyBox(i : Int, scale : Float, size : Float, paint : Paint) {
    val gap : Float = size / rects
    val sf : Float = scale.sinify().divideScale(i, rects)
    val wSize : Float = gap * i + gap * sf
    save()
    rotate(deg * sf)
    drawRect(RectF(-wSize / 2, -wSize / 2, wSize / 2, wSize / 2), paint)
    restore()
}

fun Canvas.drawMultiColorBouncyBox(scale : Float, size : Float, paint : Paint) {
    for (j in 0..(rects - 1)) {
        drawColorBouncyBox(j, scale, size, paint)
    }
}

fun Canvas.drawMCBBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val size : Float = Math.min(w, h)
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.style = Paint.Style.STROKE

    save()
    translate(w / 2, h / 2)
    drawMultiColorBouncyBox(scale, size, paint)
    restore()
}
