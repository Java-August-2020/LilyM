package com.Lily.dojoNinjas.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Lily.dojoNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}