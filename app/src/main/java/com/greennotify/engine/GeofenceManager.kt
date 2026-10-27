package com.greennotify.engine
import android.content.Context
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices
import com.greennotify.data.Green

class GeofenceManager(private val context: Context) {
    private val client: GeofencingClient = LocationServices.getGeofencingClient(context)
    fun registerForHole(green: Green, teeLat: Double, teeLng: Double) {
        val tee = Geofence.Builder().setRequestId("TEE_" + green.hole)
            .setCircularRegion(teeLat, teeLng, 120f)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_DWELL)
            .setLoiteringDelay(3000).setExpirationDuration(Geofence.NEVER_EXPIRE).build()
        val greenF = Geofence.Builder().setRequestId("GREEN_" + green.hole)
            .setCircularRegion(green.centerLat, green.centerLng, 45f)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_DWELL)
            .setLoiteringDelay(3000).setExpirationDuration(Geofence.NEVER_EXPIRE).build()
        val req = GeofencingRequest.Builder().setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER).addGeofences(listOf(tee, greenF)).build()
    }
}
