package in.agrostar.products.models;

/**
 * Created by Shahid on 3/1/2016.
 */
public class ProductModel {
    public int productId;
    public String productName;
    public float productPrice;
    //Using hardcoded images and hence this is int.
    //Once we integrate with server for live images, we can change this to String which will accept the url for image
    public int productImage;
}
