@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Student> student = studentRepository.findByEmail(email);

    if (student.isPresent()) {
      return new User(student.get().getEmail(), student.get().getPassword(), new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with email: " + email);
    }
  }
}
