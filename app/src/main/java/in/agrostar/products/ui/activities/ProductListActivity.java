package in.agrostar.products.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.agrostar.products.R;
import in.agrostar.products.logger.Logger;

/**
 * Created by Shahid on 2/26/2016.
 */
public class ProductListActivity extends AppCompatActivity {

    protected Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logger = new Logger(ProductListActivity.class.getName());
    }
}
