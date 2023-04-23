
@RestController
@RequestMapping("/api/parents")
public class ParentController {

  @Autowired
  private ParentService parentService;

  @GetMapping
  public ResponseEntity<List<Parent>> getAllParents() {
    List<Parent> parents = parentService.getAllParents();
    return new ResponseEntity<>(parents, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
    Parent parent = parentService.getParentById(id);
    return new ResponseEntity<>(parent, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Parent> addParent(@RequestBody Parent parent) {
    Parent newParent = parentService.addParent(parent);
    return new ResponseEntity<>(newParent, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestBody Parent parent) {
    Parent updatedParent = parentService.updateParent(id, parent);
    return new ResponseEntity<>(updatedParent, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
    parentService.deleteParent(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
