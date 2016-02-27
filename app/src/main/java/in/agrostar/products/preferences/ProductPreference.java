package in.agrostar.products.preferences;

import android.content.Context;

/**
 * Created by Shahid on 2/26/2016.
 */
public class ProductPreference extends PrefManager{

    private final String IS_PRODUCTS_INSERTED_IN_DB = "is_products_inserted";

    public ProductPreference(Context context, String prefName) {
        super(context, prefName);
    }

    /**
     * Return if the hardcoded products are entered in the DB
     * @return true if the data has been inserted in DB
     */
    public boolean isProductDetailsEntered(){
        return getBoolean(IS_PRODUCTS_INSERTED_IN_DB, false);
    }

    /**
     * Set boolean value once hardcoded products are entered in the DB
     * @param isProductInserted - boolean value
     */
    public void setProductsEntered(boolean isProductInserted){
        put(IS_PRODUCTS_INSERTED_IN_DB, isProductInserted);
    }
}
