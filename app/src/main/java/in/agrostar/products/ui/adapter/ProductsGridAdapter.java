package in.agrostar.products.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.agrostar.products.R;
import in.agrostar.products.models.ProductModel;

public class ProductsGridAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater layoutInflater;
	//private String[] categoryList;
	private ArrayList<ProductModel> productModelList;

	public ProductsGridAdapter(Context context, ArrayList<ProductModel> productModelList) {
		this.context=context;
		layoutInflater = LayoutInflater.from(context);
		this.productModelList = productModelList;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View grid;
		if(convertView==null){
			grid = new View(context);
			grid = layoutInflater.inflate(R.layout.row_grid_item, null);
		}else{
			grid = (View)convertView;
		}

		ProductModel productModelModel = productModelList.get(position);
		ImageView productImage = (ImageView) grid.findViewById(R.id.product_image);
		productImage.setImageResource(productModelModel.productImage);

		TextView productName = (TextView) grid.findViewById(R.id.product_name_tv);
		productName.setText(productModelModel.productName);

        TextView productPrice = (TextView) grid.findViewById(R.id.product_price_tv);
        productPrice.setText(productModelModel.productPrice+"");

		grid.setTag(productModelModel);

		return grid;

	}


	public final int getCount() {
		return productModelList.size();
	}

	public final Object getItem(int position) {
		return productModelList.get(position);
	}

	public final long getItemId(int position) {
		return position;
	}

}
