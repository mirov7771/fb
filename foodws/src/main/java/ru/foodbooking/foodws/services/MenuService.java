package ru.foodbooking.foodws.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.ProductsRepository;
import ru.foodbooking.foodws.dao.model.Products;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.dao.CategoriesRepository;
import ru.foodbooking.foodws.dao.model.Categories;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("menu")
public class MenuService implements FBServices {

    private static Logger LOG = Logger.getLogger(MenuService.class);

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<FBServicesRes> execute(GetRequest request) throws FBException {
        LOG.debug("In method categories");
        ValidationUtils.validateRequest(request);
        List<FBServicesRes> res = new ArrayList<>();
        if (request.getPointId() != null) {
            Long pointId = request.getPointId();
            Iterable<Categories>categoriesList = categoriesRepository.findAll();
            if (categoriesList != null){
                for(Categories category : categoriesList){
                    FBServicesRes tCategory = new FBServicesRes();
                    tCategory.setPointId(pointId);
                    tCategory.setCtgrBrief(category.getCtgrBrief());
                    tCategory.setCtgrId(category.getCtgrId());
                    tCategory.setCtgrLogo(category.getCtgrLogo());
                    tCategory.setCtgrName(category.getCtgrName());
                    tCategory.setDescription(category.getDescription());
                    tCategory.setType(0);
                    res.add(tCategory);
                }
            }
            List<Products>productsList = productsRepository.findByPointId(pointId);
            if (!CollectionUtils.isEmpty(productsList)){
                for(Products product : productsList){
                    FBServicesRes tProduct = new FBServicesRes();
                    tProduct.setCtgrId(product.getCtgrId());
                    tProduct.setPrdBrief(product.getPrdBrief());
                    tProduct.setPrdName(product.getPrdName());
                    tProduct.setPrdLogo(product.getPrdLogo());
                    tProduct.setDescription(product.getDescription());
                    tProduct.setCost(product.getCost());
                    tProduct.setType(1);
                    res.add(tProduct);
                }
            }
        }
        res.sort(FBServicesRes.COMPARE_BY_TYPE);
        LOG.debug("Out method categories");
        return res;
    }
}
