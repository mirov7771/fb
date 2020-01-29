package ru.foodbooking.foodws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.CategoriesRepository;
import ru.foodbooking.foodws.dao.model.Categories;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.support.type.TCategories;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("categories")
public class CategoriesService implements FBServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public FBServicesRes execute(FBServicesReq request) throws FBException {

        FBServicesRes res = new FBServicesRes();
        ValidationUtils.validateRequest(request);
        List<Categories> categoriesList;
        if (request.getPointId() != null) {
            categoriesList = categoriesRepository.findByPointId(request.getPointId());
            if (!CollectionUtils.isEmpty(categoriesList)){
                List<TCategories> tCategoriesList = new ArrayList<>();
                for (Categories categories : categoriesList){
                    TCategories tCategory = new TCategories();
                    tCategory.setPointId(categories.getPointId());
                    tCategory.setCtgrBrief(categories.getCtgrBrief());
                    tCategory.setCtgrId(categories.getCtgrId());
                    tCategory.setCtgrLogo(categories.getCtgrLogo());
                    tCategory.setCtgrName(categories.getCtgrName());
                    tCategory.setDescription(categories.getDescription());
                    tCategoriesList.add(tCategory);
                }
                res.setCtgrList(tCategoriesList);
            }
        }
        return res;
    }
}
