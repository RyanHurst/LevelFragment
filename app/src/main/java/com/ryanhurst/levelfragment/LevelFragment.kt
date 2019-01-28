package com.ryanhurst.levelfragment


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * [Fragment] where rotation is manipulated so that the bottom of the view is always down
 */
abstract class LevelFragment : Fragment(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var gravitySensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get an instance of the sensor service, and use that to get an instance of
        // the gravity sensor.
        sensorManager = activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
    }

    override fun onResume() {
        super.onResume()
        // Register listener
        sensorManager.registerListener(
                this,
                gravitySensor,
                SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        super.onPause()
        // Unregister listener
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        view?.let {
            val x = event.values[0]
            val y = event.values[1]

            // Calculate angle to rotate view
            val angleInRadians = Math.atan2(x.toDouble(), y.toDouble())
            val angleInDegrees = Math.toDegrees(angleInRadians)
            it.rotation = angleInDegrees.toFloat()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
}
