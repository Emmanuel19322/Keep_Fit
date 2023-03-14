package com.codepen.keepfit.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import androidx.core.content.getSystemService
import com.codepen.keepfit.prefs.GeneralPrefs
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class StepCounter(context: Context) : Service(), SensorEventListener {

    private var totalStep = 0

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val countSensor:Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_NORMAL)
        }

        return START_STICKY
    }


    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var todayDate: Date = Calendar.getInstance().time
        var df: DateFormat = SimpleDateFormat("dd MM yyyy")
        var currentDate = df.format(todayDate)

        if (currentDate == GeneralPrefs.getTodayDate()) {
            totalStep = event!!.values[0].toInt()

        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }
}