package in.agrostar.products.ui.activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;

import in.agrostar.products.R;
import in.agrostar.products.logger.Logger;
import in.agrostar.products.ui.adapter.ProductsPageAdapter;
import in.agrostar.products.ui.custom_view.CircularPageIndicator;

/**
 * Created by Shahid on 2/26/2016.
 */
public class ProductListActivity extends AppCompatActivity {

    protected Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        logger = new Logger(ProductListActivity.class.getName());
        setUpImageSlider();
    }

    /**
     * Setup the swipe views using view pager
     */
    private void setUpImageSlider() {
        //TODO - These are hardcoded values and will require to be changed later

        int[] featuredProductsArray = {R.drawable.featured_1, R.drawable.featured_2, R.drawable.featured_3};

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerImage);
        ProductsPageAdapter adapter = new ProductsPageAdapter(this, featuredProductsArray);
        viewPager.setAdapter(adapter);

        int pageCount = adapter.getCount();
        if(pageCount>0){
            LinearLayout indicatorLayout = (LinearLayout) findViewById(R.id.circular_indicator_layout);
            CircularPageIndicator circularPageIndicator = new CircularPageIndicator(
                    this, indicatorLayout);
            circularPageIndicator.createPageIndicator(pageCount, 0);
            viewPager.addOnPageChangeListener(circularPageIndicator);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.produclt_list_menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
