package poly.store.service;

import java.util.List;

import poly.store.entity.Manufacturer;



public interface ManufactureService {

	List<Manufacturer> findAll();
	
	Manufacturer save(Manufacturer Manufactures);

	Manufacturer update(Manufacturer Manufactures);


	Manufacturer findById(Integer id);

	void delete(Integer id);



	void deleteById(Integer id);

}
