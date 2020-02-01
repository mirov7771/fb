package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Categories;

import java.util.List;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, String> {

    List<Categories> findByPointId(Long pointId);
    List<Categories> findByCtgrId(Long ctgrId);

}
