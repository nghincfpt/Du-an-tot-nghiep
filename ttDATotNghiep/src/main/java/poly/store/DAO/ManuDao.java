package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Manufacturer;



public interface ManuDao extends JpaRepository<Manufacturer, Integer>{

}
