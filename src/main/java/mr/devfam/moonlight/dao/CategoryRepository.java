package mr.devfam.moonlight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import mr.devfam.moonlight.entities.Category;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
