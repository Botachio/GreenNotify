package com.greennotify.engine
import kotlin.math.*

object YardageEngine {
    fun haversineYards(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val R = 6371000.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat/2)*sin(dLat/2) + cos(Math.toRadians(lat1))*cos(Math.toRadians(lat2))*sin(dLon/2)*sin(dLon/2)
        val c = 2*atan2(sqrt(a), sqrt(1-a))
        return R*c*1.09361
    }
    fun isInsidePolygon(lat: Double, lng: Double, polygon: List<Pair<Double,Double>>): Boolean {
        var inside = false
        var j = polygon.size - 1
        for (i in polygon.indices) {
            if ((polygon[i].second > lng) != (polygon[j].second > lng) &&
                lat < (polygon[j].first - polygon[i].first)*(lng - polygon[i].second)/(polygon[j].second - polygon[i].second) + polygon[i].first) inside = !inside
            j = i
        }
        return inside
    }
    fun shouldNotify(lastLat: Double?, lastLng: Double?, newLat: Double, newLng: Double, stillForSec: Long): Boolean {
        if (lastLat == null) return true
        val dist = haversineYards(lastLat, lastLng!!, newLat, newLng)
        return dist > 15 && stillForSec >= 3
    }
}
