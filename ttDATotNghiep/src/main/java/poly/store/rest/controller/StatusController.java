package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Role;
import poly.store.entity.Status;
import poly.store.service.RoleService;
import poly.store.service.StatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/status")
public class StatusController {
   @Autowired
   StatusService statusService;
   
   @GetMapping
   public List<Status> getAll(){
	   return statusService.findAll();
   }
}
