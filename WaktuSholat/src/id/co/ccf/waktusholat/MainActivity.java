package id.co.ccf.waktusholat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity
{

	TextView txtPrayerTimes, txtAddress, txtHijriDate;

	GPSTracker gps;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		txtHijriDate = (TextView) findViewById(R.id.txtHijriDate);
		txtPrayerTimes = (TextView) findViewById(R.id.txtPrayerTimes);
		txtAddress = (TextView) findViewById(R.id.txtAddress);

		Typeface tf = Typeface.createFromAsset(getAssets(), "DejaVuSans.ttf"); 
		txtPrayerTimes.setTypeface(tf);

		gps = new GPSTracker(MainActivity.this);

		if (gps.canGetLocation())
		{
			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			double timezone = (Calendar.getInstance()
				.getTimeZone()
				.getOffset(Calendar.getInstance()
						   .getTimeInMillis())) / (1000 * 60 * 60); 

			// Tidak bisa mendapatkan lokasi
            // GPS or Network tidak dinyalakan
            // Tanya pengguna untuk menyalakan GPS
            gps.showSettingsAlert();

			LocationAddress locationAddress = new LocationAddress(); 
			locationAddress.getAddressFromLocation(latitude, longitude, 
												   getApplicationContext(), 
												   new GeocoderHandler()); 

			// Metode pengaturan Waktu Sholat
			PrayTime prayers = new PrayTime(); 
			prayers.setTimeFormat(prayers.Time24); 
			prayers.setCalcMethod(prayers.Makkah); 
			prayers.setAsrJuristic(prayers.Shafii); 
			prayers.setAdjustHighLats(prayers.AngleBased); 
			int[] offsets = { 0, 0, 0, 0, 0, 0, 0 };
			prayers.tune(offsets); 

			Date now = new Date(); 
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(now); 

			ArrayList prayerTimes = prayers.getPrayerTimes(cal, latitude, 
														   longitude, timezone); 
			ArrayList prayerNames = prayers.getTimeNames(); 
			for (int i = 0; i < prayerTimes.size(); i++)
			{ 

			    txtPrayerTimes.append(prayerNames.get(i) + " - " + prayerTimes.get(i) + "\n");

			} 
			
			txtHijriDate.append(HijriCalendar.getSimpleDate(cal));

		} 

	} 

	public Intent createIntent(Context context)
	{
		Intent i = new Intent(context, MainActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		return i;

	} 


	private class GeocoderHandler extends Handler
	{ 

		@Override 
		public void handleMessage(Message message)
		{ 
			String locationAddress; 
			switch (message.what)
			{ 
				case 1: 
					Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
					break; 
				default: locationAddress = null; 
			} 

			txtAddress.setText(locationAddress);

		}

	}

}
