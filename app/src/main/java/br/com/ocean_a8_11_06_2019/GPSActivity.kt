package br.com.ocean_a8_11_06_2019

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.PermissionChecker.PERMISSION_GRANTED
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_gps.*

class GPSActivity : AppCompatActivity() {


    val PERMISSION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)

        if(!checkGpsPermission()){
            askPermission()
        }else{
            initLocation()
        }
    }


    @SuppressLint("MissingPermission")
    fun initLocation(){

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationProvider = LocationManager.GPS_PROVIDER


        locationManager.requestLocationUpdates(locationProvider, 1000L, 1F,
            object: LocationListener {
                override fun onLocationChanged(location: Location?) {

                    textview.text = "Latitude: ${location?.latitude} Longitude: ${location?.longitude}"
                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                }

                override fun onProviderEnabled(provider: String?) {
                }

                override fun onProviderDisabled(provider: String?) {
                }

            })

    }

    //Permissão de GPS
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == PERMISSION_REQUEST_CODE){
            if(grantResults[0] == PERMISSION_GRANTED){
                initLocation()
            }
        }
    }



    fun askPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_CODE)
    }

    fun checkGpsPermission():Boolean{

        return checkSelfPermission(ACCESS_FINE_LOCATION) == PERMISSION_GRANTED
                && checkSelfPermission(ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED
    }

}
