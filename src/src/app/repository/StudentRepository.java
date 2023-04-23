 import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  // Add custom query methods here, if needed

}
