
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

  Optional<Parent> findByEmail(String email);
}
