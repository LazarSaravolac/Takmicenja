package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {

}
