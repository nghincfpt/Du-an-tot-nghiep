package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.store.entity.Role;





@Repository
public interface RoleDAO  extends JpaRepository<Role, String>{

}
