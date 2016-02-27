package in.agrostar.products.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import in.agrostar.products.R;
import in.agrostar.products.logger.Logger;
import in.agrostar.products.preferences.ProductPreference;
import in.agrostar.products.util.AppConstants;

/**
 * Created by Shahid on 2/26/2016.
 */
public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;
    protected Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (!isTaskRoot()) {
            // This stops from opening again from the Splash screen when minimized
            finish();
            return;
        }

        logger = new Logger(SplashActivity.class.getName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity if it has not been minimized
                if (!isFinishing()) {
                    Intent intent = new Intent(SplashActivity.this, ProductListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);

        ProductPreference productPref = new ProductPreference(SplashActivity.this, AppConstants.PREF_FILE_NAME);
        //TODO - Insert hardcoded data in DB
    }
}
