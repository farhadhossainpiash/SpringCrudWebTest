package com.springCrudWebTest.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springCrudWebTest.demo.model.Employee;

@Controller
public class EmployeeController {

	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String index(Model model) {
		ResponseEntity<Object> responseEntity =  restTemplate
				.exchange("http://localhost:9090/employeeList", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
				});
		ObjectMapper object =new ObjectMapper();
		List<Employee>employees=object.convertValue(responseEntity.getBody(), new TypeReference<List<Employee>>() {
		});
		model.addAttribute("listEmployees",employees);
		return "index";
	}
	
	@GetMapping("/showNewEmployeeform")
	public String showNewEmployeeform(Model model, @ModelAttribute("employee")Employee employee) {
			
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String createEmployee(@ModelAttribute("employee") Employee employee)
	{
		System.out.println("Inside createEmployee method of SpringBootRestTemplateDemo Application");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<String> responseEntity =  restTemplate
				.exchange("http://localhost:9090/employees", HttpMethod.POST, entity, String.class);
		return "redirect:/";
				
	}

//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable (value = "id") int id) {
//		employeeService.deleteEmployee(id);
//		return "redirect:/";
//	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:9090/deleteEmployee/" + id, HttpMethod.DELETE,
				null, String.class);
		return "redirect:/";	
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") int id, Model model) {
		ResponseEntity<Object> responseEntity =  restTemplate
				.exchange("http://localhost:9090/employeeById/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
				});
		ObjectMapper object =new ObjectMapper();
		Employee employee=object.convertValue(responseEntity.getBody(), new TypeReference<Employee>() {
		});
		model.addAttribute("employee",employee);
		return "update_employee";
	}

}
