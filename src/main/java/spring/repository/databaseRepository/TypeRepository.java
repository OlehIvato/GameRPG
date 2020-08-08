package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.Type;

@Repository
public interface TypeRepository  extends JpaRepository<Type, Long> {
}
