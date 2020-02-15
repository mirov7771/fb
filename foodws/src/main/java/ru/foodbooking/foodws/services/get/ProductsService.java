package ru.foodbooking.foodws.services.get;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.dao.ProductsRepository;
import ru.foodbooking.foodws.dao.model.Products;
import ru.foodbooking.foodws.support.response.GetResponse;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("products")
public class ProductsService implements GetServices {

    private static Logger LOG = Logger.getLogger(ProductsService.class);

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<GetResponse> execute(GetRequest request) throws FBException {
        LOG.debug("In method products");
        ValidationUtils.validateRequest(request);
        List<GetResponse> res = new ArrayList<>();
        List<Products>productsList = new ArrayList<>();
        if (request.getCtgrId() != null && request.getCtgrId().equals(0L) && request.getPointId() != null){
            productsList = productsRepository.findByPointId(request.getPointId());
        } else if (request.getCtgrId() != null) {
            productsList = productsRepository.findByCtgrId(request.getCtgrId());
        } else if (request.getPointId() != null) {
            productsList = productsRepository.findByPointId(request.getPointId());
        }
        if (!CollectionUtils.isEmpty(productsList)){
            for(Products product : productsList){
                GetResponse tProduct = new GetResponse();
                tProduct.setCtgrId(product.getCtgrId());
                tProduct.setPrdBrief(product.getPrdBrief());
                tProduct.setPrdName(product.getPrdName());
                tProduct.setPrdLogo(product.getPrdLogo());
                tProduct.setDescription(product.getDescription());
                tProduct.setCost(product.getCost());
                tProduct.setType(1);
                tProduct.setPrdId(product.getPrdId());
                res.add(tProduct);
            }
        }

        LOG.debug("Out method products");
        return res;
    }
}
