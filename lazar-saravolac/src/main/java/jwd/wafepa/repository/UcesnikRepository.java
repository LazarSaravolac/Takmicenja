package jwd.wafepa.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Ucesnik;

@Repository
public interface UcesnikRepository extends PagingAndSortingRepository<Ucesnik, Long>{
	Page<Ucesnik> findByTakmicenjeId(Long takmicenjeId, Pageable pageRequest);
	
	@Query("SELECT u FROM Ucesnik u WHERE "
			+ "(:naziv IS NULL or u.naziv like :naziv ) AND "
			+ "(:idTakmicenje IS NULL or u.takmicenje.id = :idTakmicenje )"
			)
	Page<Ucesnik> pretraga(
			@Param("naziv") String naziv, 
			@Param("idTakmicenje") Long idTakmicenje,
			Pageable pageRequest);
}
