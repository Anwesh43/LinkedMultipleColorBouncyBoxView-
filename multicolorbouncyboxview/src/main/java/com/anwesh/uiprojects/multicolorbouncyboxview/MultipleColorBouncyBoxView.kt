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
