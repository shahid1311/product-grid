package in.agrostar.products.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import in.agrostar.products.R;
import in.agrostar.products.logger.Logger;
import in.agrostar.products.models.ProductModel;

/**
 * Created by Shahid on 2/26/2016.
 */
public class AppConstants {
    private static Logger logger = new Logger(AppConstants.class.getName());


    public static ArrayList<ProductModel> getProductList(Context context){
        int[] productImage = {R.drawable.product_1, R.drawable.product_2, R.drawable.product_3,
                R.drawable.product_4, R.drawable.product_5, R.drawable.product_6, R.drawable.product_7,
                R.drawable.product_8, R.drawable.product_9, R.drawable.product_10};
        float[] productValue = {120, 150, 90, 225, 180, 200, 115, 170, 135, 190};

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);

        Configuration config = context.getResources().getConfiguration();

        String lang = settings.getString(context.getString(R.string.pref_locale), "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang))
        {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }

        Resources res = context.getResources();
        Configuration conf = res.getConfiguration();
        logger.debug("App const: "+conf.locale.getLanguage());

        String[] productList = context.getResources().getStringArray(R.array.product_name);
        ArrayList<ProductModel> productModelList = new ArrayList<>();

        for(int i=0; i<10; i++){
            ProductModel productModel = new ProductModel();
            productModel.productId = i;
            productModel.productName = productList[i];
            productModel.productPrice = productValue[i];
            productModel.productImage = productImage[i];

            productModelList.add(productModel);
        }

        return productModelList;
    }
}
