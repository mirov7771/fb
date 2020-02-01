package ru.foodbooking.foodws.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.CategoriesRepository;
import ru.foodbooking.foodws.dao.model.Categories;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("categories")
public class CategoriesService implements FBServices {

    private static Logger LOG = Logger.getLogger(CategoriesService.class);

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<FBServicesRes> execute(FBServicesReq request) throws FBException {
        LOG.debug("In method categories");
        FBServicesRes res = new FBServicesRes();
        ValidationUtils.validateRequest(request);
        List<Categories> categoriesList;
        List<FBServicesRes> tCategoriesList = new ArrayList<>();
        if (request.getPointId() != null) {
            categoriesList = categoriesRepository.findByPointId(request.getPointId());
            if (!CollectionUtils.isEmpty(categoriesList)){
                for (Categories categories : categoriesList){
                    FBServicesRes tCategory = new FBServicesRes();
                    tCategory.setPointId(categories.getPointId());
                    tCategory.setCtgrBrief(categories.getCtgrBrief());
                    tCategory.setCtgrId(categories.getCtgrId());
                    tCategory.setCtgrLogo(categories.getCtgrLogo());
                    tCategory.setCtgrName(categories.getCtgrName());
                    tCategory.setDescription(categories.getDescription());
                    tCategoriesList.add(tCategory);
                }
            }
        }
        LOG.debug("Out method categories");
        return tCategoriesList;
    }
}
