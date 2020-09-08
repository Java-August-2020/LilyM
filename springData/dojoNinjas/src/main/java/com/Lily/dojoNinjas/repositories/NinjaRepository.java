package com.Lily.dojoNinjas.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Lily.dojoNinjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}