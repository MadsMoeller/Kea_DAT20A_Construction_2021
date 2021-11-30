package mads.kea.prices_store.repositories;

import mads.kea.prices_store.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
