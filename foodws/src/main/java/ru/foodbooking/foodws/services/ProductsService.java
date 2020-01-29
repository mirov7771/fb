package ru.foodbooking.foodws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.ProductsRepository;
import ru.foodbooking.foodws.dao.model.Products;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.support.type.TProducts;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("products")
public class ProductsService implements FBServices {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public FBServicesRes execute(FBServicesReq request) throws FBException {
        FBServicesRes res = new FBServicesRes();
        ValidationUtils.validateRequest(request);
        List<Products> productsList;
        if (request.getCtgrId() != null){
            productsList = productsRepository.findByCtgrId(request.getCtgrId());
            if (!CollectionUtils.isEmpty(productsList)){
                List<TProducts> tProductsList = new ArrayList<>();
                for(Products product : productsList){
                    TProducts tProduct = new TProducts();
                    tProduct.setCtgrId(product.getCtgrId());
                    tProduct.setPrdBrief(product.getPrdBrief());
                    tProduct.setPrdName(product.getPrdName());
                    tProduct.setPrdLogo(product.getPrdLogo());
                    tProductsList.add(tProduct);
                }
                res.setProductsList(tProductsList);
            }
        }
        return res;
    }
}
