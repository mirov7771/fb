package ru.foodbooking.foodws.services.get;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.ProductsRepository;
import ru.foodbooking.foodws.support.builder.CategoryBuilder;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.dao.CategoriesRepository;
import ru.foodbooking.foodws.dao.model.Categories;
import ru.foodbooking.foodws.support.response.GetResponse;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("ctgr")
@Slf4j
public class CategoriesService implements GetServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<GetResponse> execute(GetRequest request) throws FBException {
        log.debug("In method categories");
        ValidationUtils.validateRequest(request);
        List<GetResponse> res = new ArrayList<>();
        CategoryBuilder categoryBuilder = new CategoryBuilder.Builder(0L)
                .setCtgrBrief(FBConstant.ALL_CATEGORY)
                .setCtgrName(FBConstant.ALL_CATEGORY)
                .build();
        res.add(categoryBuilder);
        if (request.getPointId() != null) {
            Iterable<Categories>categoriesList = categoriesRepository.findByPointId(request.getPointId());
            if (categoriesList != null){
                for(Categories category : categoriesList){
                    GetResponse tCategory = new GetResponse();
                    tCategory.setPointId(category.getPointId());
                    tCategory.setCtgrBrief(category.getCtgrBrief());
                    tCategory.setCtgrId(category.getCtgrId());
                    tCategory.setCtgrLogo(category.getCtgrLogo());
                    tCategory.setCtgrName(category.getCtgrName());
                    tCategory.setDescription(category.getDescription());
                    tCategory.setType(0);
                    res.add(tCategory);
                }
            }
        }
        log.debug("Out method categories");
        return res;
    }
}
