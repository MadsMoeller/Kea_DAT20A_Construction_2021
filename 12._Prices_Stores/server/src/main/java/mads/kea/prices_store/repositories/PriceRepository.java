package mads.kea.prices_store.repositories;

import mads.kea.prices_store.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByStoreId(Long storeId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prices " +
            "WHERE store_id=?",
            nativeQuery = true
    )
    void deleteAllPricesByStoreId(Long id);

}
