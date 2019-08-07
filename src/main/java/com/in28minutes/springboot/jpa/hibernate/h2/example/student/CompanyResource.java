package com.in28minutes.springboot.jpa.hibernate.h2.example.student;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CompanyResource {

	@Autowired
	private CompanyRepository companyRepository;
	
	
	@GetMapping("/companies")
	public List<Company> retrieveAllCompanies() {
		return companyRepository.findAll();
	}

	@GetMapping("/companies/{id}")
	public Company getCompany(@PathVariable long id) {
		Optional<Company> company = companyRepository.findById(id);

		if (!company.isPresent())
			throw new CompanyNotFoundException("id-" + id);
		return company.get();
	}
	

	@DeleteMapping("/companies/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyRepository.deleteById(id);
	}

	@PostMapping("/companies")
	public ResponseEntity<Object> createCompany(@RequestBody Company company) {
		Company savedCompany = companyRepository.save(company);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCompany.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/companies/{id}")
	public ResponseEntity<Object> updateCompany(@RequestBody Company company, @PathVariable long id) {

		Optional<Company> companyOptional = companyRepository.findById(id);

		if (!companyOptional.isPresent())
			return ResponseEntity.notFound().build();

		company.setId(id);
		
		companyRepository.save(company);

		return ResponseEntity.noContent().build();
	}
}
