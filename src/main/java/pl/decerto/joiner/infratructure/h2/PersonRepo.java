package pl.decerto.joiner.infratructure.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.decerto.joiner.domain.model.Person;

@Repository
public interface PersonRepo  extends CrudRepository<Person, Long> {
}
