package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.model.PointOfSale;
import ru.itis.demo.model.SportInventory;

import java.util.List;

public interface SalePointsRepository extends JpaRepository<PointOfSale,Long> {
    @Transactional
    @Query(nativeQuery = true,value = "SELECT * FROM point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id\n" +
            "    inner join sport_item_info sii on si.id = sii.sport_inventory_id where sii.price between :price_min and :price_max;")
     List<PointOfSale> getPointOfSaleByPriceBetween(@Param("price_min")Long price_min,@Param("price_max")Long price_max);
    @Transactional
    @Query("select pos from PointOfSale pos where :item member of pos.sportInventoryList ")
     List<PointOfSale> getPointOfSaleBySportInventoryList(String item);



    @Query(nativeQuery = true,value = "select * from point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id\n" +
            "inner join sport_item_info sii on si.id = sii.sport_inventory_id\n" +
            "inner join reservation_time rt on sii.id = rt.sport_item_info_id where price between :price_min and :price_max and name_of_item = :item_name;")
    public List<PointOfSale> getSalePointsWithPriceBetweenAndItemName(@Param("price_min")Long price_min, @Param("price_max")Long price_max, @Param("item_name")String item_name);

//    @Query(nativeQuery = true,value = "select name_of_item from point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id\n" +
//            "inner join sport_item_info sii on si.id = sii.sport_inventory_id\n" +
//            "inner join reservation_time rt on sii.id = rt.sport_item_info_id")
//    public List<String> getAllItemNames();
    //language=SQL
    //SELECT * FROM point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id
    //    inner join sport_item_info sii on si.id = sii.sport_inventory_id where (sii.price between :? and :?) and si.name_of_item = :?;
}
