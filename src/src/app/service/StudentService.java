
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student getStudentById(Long id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      return optionalStudent.get();
    }
    throw new EntityNotFoundException("Could not find student with id " + id);
  }

  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student updateStudent(Long id, Student student) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      student.setId(id);
      return studentRepository.save(student);
    }
    throw new EntityNotFoundException("Could not find student with id " + id);
  }

  public void deleteStudent(Long id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      studentRepository.deleteById(id);
    } else {
      throw new EntityNotFoundException("Could not find student with id " + id);
    }
  }
}
