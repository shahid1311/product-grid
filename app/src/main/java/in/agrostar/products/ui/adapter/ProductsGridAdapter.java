package in.agrostar.products.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.agrostar.products.R;
import in.agrostar.products.models.ProductModel;

public class ProductsGridAdapter extends BaseAdapter implements Filterable {

	private Context context;
	private LayoutInflater layoutInflater;
	private ArrayList<ProductModel> productModelList;
    private ArrayList<ProductModel> filteredList;

    private ProductFilter productFilter;

	public ProductsGridAdapter(Context context, ArrayList<ProductModel> productModelList) {
		this.context=context;
		layoutInflater = LayoutInflater.from(context);
		this.productModelList = productModelList;
        this.filteredList = productModelList;

        getFilter();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final ProductModel productModel = (ProductModel) getItem(position);
		if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_grid_item, null);
            holder = new ViewHolder();
            holder.productNameTv = (TextView) convertView.findViewById(R.id.product_name_tv);
            holder.productPriceTv = (TextView) convertView.findViewById(R.id.product_price_tv);
            holder.productImage = (ImageView) convertView.findViewById(R.id.product_image);

            convertView.setTag(holder);
		}else{
            // get view holder back
            holder = (ViewHolder) convertView.getTag();
		}

		holder.productImage.setImageResource(productModel.productImage);
		holder.productNameTv.setText(productModel.productName);
        holder.productPriceTv.setText(productModel.productPrice + "");
        holder.productImage.setTag(productModel);

		return convertView;

	}

    /**
     * Keep reference to children view to avoid unnecessary calls
     */
    static class ViewHolder {
        TextView productNameTv;
        TextView productPriceTv;
        ImageView productImage;
    }

    public final int getCount() {
		return filteredList.size();
	}

	public final Object getItem(int position) {
		return filteredList.get(position);
	}

	public final long getItemId(int position) {
		return position;
	}

    @Override
    public Filter getFilter() {
        if (productFilter == null) {
            productFilter = new ProductFilter();
        }
        return productFilter;
    }

    /**
     * Custom filter for Product grid
     * Filter content in product grid according to the search text
     */
    private class ProductFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<ProductModel> tempList = new ArrayList<ProductModel>();


                // search content in friend list
                for (ProductModel product : productModelList) {
                    if (product.productName.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(product);
                    }
                }


                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = productModelList.size();
                filterResults.values = productModelList;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<ProductModel>) results.values;
            notifyDataSetChanged();
        }
    }
}
