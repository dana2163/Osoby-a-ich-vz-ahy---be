@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @GetMapping("")
  public List<Teacher> getAllTeachers() {
    return teacherService.getAllTeachers();
  }

  @GetMapping("/{id}")
  public Teacher getTeacherById(@PathVariable("id") Long id) {
    return teacherService.getTeacherById(id);
  }

  @PostMapping("")
  public Teacher createTeacher(@RequestBody Teacher teacher) {
    return teacherService.createTeacher(teacher);
  }

  @PutMapping("/{id}")
  public Teacher updateTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher) {
    return teacherService.updateTeacher(id, teacher);
  }

  @DeleteMapping("/{id}")
  public void deleteTeacher(@PathVariable("id") Long id) {
    teacherService.deleteTeacher(id);
  }
}
