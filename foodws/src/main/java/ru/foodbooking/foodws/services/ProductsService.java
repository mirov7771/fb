package ru.foodbooking.foodws.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.ProductsRepository;
import ru.foodbooking.foodws.dao.model.Products;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("products")
public class ProductsService implements FBServices {

    private static Logger LOG = Logger.getLogger(ProductsService.class);

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<FBServicesRes> execute(FBServicesReq request) throws FBException {
        LOG.debug("In method products");
        FBServicesRes res = new FBServicesRes();
        ValidationUtils.validateRequest(request);
        List<Products> productsList;
        List<FBServicesRes> tProductsList = new ArrayList<>();
        if (request.getCtgrId() != null){
            productsList = productsRepository.findByCtgrId(request.getCtgrId());
            if (!CollectionUtils.isEmpty(productsList)){
                for(Products product : productsList){
                    FBServicesRes tProduct = new FBServicesRes();
                    tProduct.setCtgrId(product.getCtgrId());
                    tProduct.setPrdBrief(product.getPrdBrief());
                    tProduct.setPrdName(product.getPrdName());
                    tProduct.setPrdLogo(product.getPrdLogo());
                    tProduct.setDescription(product.getDescription());
                    tProduct.setCost(product.getCost());
                    tProductsList.add(tProduct);
                }
            }
        }
        LOG.debug("Out method products");
        return tProductsList;
    }
}
