
@Entity
@Table(name = "parents")
public class Parent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false, unique = true)
  private String email;

  @ManyToMany(mappedBy = "parents")
  private Set<Student> students = new HashSet<>();

  // constructors, getters, setters, equals, hashCode, and toString
}
