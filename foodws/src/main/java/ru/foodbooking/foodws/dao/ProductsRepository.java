package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Products;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Products, String> {

    List<Products> findByCtgrId(Long ctgrId);
    List<Products> findByPrdId(Long prdId);
    List<Products> findByPointId(Long pntId);

}
