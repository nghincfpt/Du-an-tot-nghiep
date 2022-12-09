package poly.store.service.Lmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.DAO.ManuDao;
import poly.store.entity.Manufacturer;
import poly.store.service.ManufactureService;


@Service
public class ManufactureServiceImpl implements ManufactureService {

	@Autowired
	ManuDao cdao;

	@Override
	public List<Manufacturer> findAll() {
	
		return cdao.findAll();
	}
	
	@Override
	public Manufacturer findById(Integer id) {
		
		return cdao.findById(id).get();
	}


	@Override
	public Manufacturer save(Manufacturer Manufactures) {
		// TODO Auto-generated method stub
		return cdao.save(Manufactures);
	}

	@Override
	public Manufacturer update(Manufacturer Manufactures) {
		// TODO Auto-generated method stub
		return cdao.save(Manufactures);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 cdao.deleteById(id);
		
	}

	@Override
	public void deleteById(Integer id) {
		cdao.deleteById(id);
		
	}

	

	
}
