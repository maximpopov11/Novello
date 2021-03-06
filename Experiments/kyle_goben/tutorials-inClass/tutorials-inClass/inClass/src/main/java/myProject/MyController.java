package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

	@Autowired
	MyDatabase db;

	@GetMapping("/person/{id}")
	Person getPerson(@PathVariable Integer id) {
		return db.findById(id).
          orElseThrow(RuntimeException::new);
	}
	@RequestMapping("/persons")
	List<Person> hello() {
		return db.findAll();
	}

	@PostMapping("/person")
	Person createPerson(@RequestBody Person p) {
		db.save(p);
		return p;
	}


	@PutMapping("/person/{id}")
	Person updatePerson(@RequestBody Person p, @PathVariable Integer id) {
		Person old_p = db.findById(id).  orElseThrow(RuntimeException::new);
		old_p.setAddress(p.address);
		db.save(old_p);
		return old_p;
	}

	@DeleteMapping("/person/{id}")
	String deletePerson(@PathVariable Integer id) {
		db.deleteById(id);
		return "deleted " + id;
	}

}
