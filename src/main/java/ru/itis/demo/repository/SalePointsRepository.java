package ru.itis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.demo.model.PointOfSale;
import ru.itis.demo.model.SportInventory;

import java.util.List;

public interface SalePointsRepository extends JpaRepository<PointOfSale,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id\n" +
            "    inner join sport_item_info sii on si.id = sii.sport_inventory_id where sii.price between :price_min and :price_max;")
     List<PointOfSale> getPointOfSaleByCriteria(Long price_min,Long price_max);

    @Query("select pos from PointOfSale pos where :item member of pos.sportInventoryList ")
     List<PointOfSale> getPointOfSaleBySportInventoryList(String item);
    //language=SQL
    //SELECT * FROM point_of_sale inner join sport_inventory si on point_of_sale.point_of_sale_id = si.point_of_sale_point_of_sale_id
    //    inner join sport_item_info sii on si.id = sii.sport_inventory_id where (sii.price between :? and :?) and si.name_of_item = :?;
}
