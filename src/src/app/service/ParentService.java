package app.service;


@Service
public class ParentService {

  @Autowired
  private ParentRepository parentRepository;

  public List<Parent> getAllParents() {
    return parentRepository.findAll();
  }

  public Parent getParentById(Long id) {
    return parentRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Parent", "id", id));
  }

  public Parent addParent(Parent parent) {
    Optional<Parent> existingParent = parentRepository.findByEmail(parent.getEmail());
    if (existingParent.isPresent()) {
      throw new ResourceAlreadyExistsException("Parent", "email", parent.getEmail());
    }
    return parentRepository.save(parent);
  }

  public Parent updateParent(Long id, Parent parent) {
    Parent existingParent = getParentById(id);
    existingParent.setFirstName(parent.getFirstName());
    existingParent.setLastName(parent.getLastName());
    existingParent.setEmail(parent.getEmail());
    return parentRepository.save(existingParent);
  }

  public void deleteParent(Long id) {
    getParentById(id);
    parentRepository.deleteById(id);
  }
}
