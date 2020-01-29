package ru.foodbooking.foodws.services;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.CategoriesRepository;
import ru.foodbooking.foodws.dao.model.Categories;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.support.type.TCategories;

import java.util.ArrayList;
import java.util.List;

@Component("categories")
public class CategoriesService implements FBServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public FBServicesRes execute(FBServicesReq request) throws FBException {

        FBServicesRes res = new FBServicesRes();
        List<Categories> categoriesList = new ArrayList<>();
        if (request != null) {
            if (request.getPointId() != null) {
                categoriesList = categoriesRepository.findByPointId(request.getPointId());
                if (!CollectionUtils.isEmpty(categoriesList)){
                    List<TCategories> tCategoriesList = new ArrayList<>();
                    for (Categories categories : categoriesList){
                        TCategories tCategories = new TCategories();
                        tCategories.setPointId(categories.getPointId());
                        tCategories.setCtgrBrief(categories.getCtgrBrief());
                        tCategories.setCtgrId(categories.getCtgrId());
                        tCategories.setCtgrLogo(categories.getCtgrLogo());
                        tCategories.setCtgrName(categories.getCtgrName());
                    }
                    res.setCtgrList(tCategoriesList);
                }
            }
        }
        return res;
    }
}
