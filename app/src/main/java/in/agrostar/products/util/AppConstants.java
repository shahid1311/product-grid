package in.agrostar.products.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

import in.agrostar.products.R;
import in.agrostar.products.models.ProductModel;

/**
 * Created by Shahid on 2/26/2016.
 */
public class AppConstants {
    public static final String PREF_FILE_NAME = "product_details";

    public static ArrayList<ProductModel> getProductList(Context context){
        int[] productImage = {R.drawable.product_1, R.drawable.product_2, R.drawable.product_3,
                R.drawable.product_4, R.drawable.product_5, R.drawable.product_6, R.drawable.product_7,
                R.drawable.product_8, R.drawable.product_9, R.drawable.product_10};

        String[] productList = context.getResources().getStringArray(R.array.product_name);
        ArrayList<ProductModel> productModelList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<10; i++){
            ProductModel productModel = new ProductModel();
            productModel.productId = i;
            productModel.productName = productList[i];
            productModel.productPrice = rand.nextFloat() * (200 - 100) + 100;
            productModel.productImage = productImage[i];

            productModelList.add(productModel);
        }

        return productModelList;
    }
}
