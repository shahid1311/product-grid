package in.agrostar.products.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.agrostar.products.R;

public class ProductsPageAdapter extends PagerAdapter {
    private Context context;
    private int[] featuredProductArray;

    public ProductsPageAdapter(Context context, int[] featuredProductArray) {
        this.context = context;
        this.featuredProductArray = featuredProductArray;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewPagerView =  layoutInflater.inflate(R.layout.view_pager_layout, container,false);

        ImageView ivTutorial = (ImageView) viewPagerView.findViewById(R.id.iv_tutorial);
        ivTutorial.setImageResource(featuredProductArray[position]);

        ((ViewPager) container).addView(viewPagerView);
        return viewPagerView;
    }

    @Override
    public int getCount() {
        return featuredProductArray!=null?featuredProductArray.length:0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}