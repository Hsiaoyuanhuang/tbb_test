package com.example.practice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//onmethod用這個
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; // 用RESTful需要新增

// @RestController
// class EmployeeController {

//   private final EmployeeRepository repository;

//   EmployeeController(EmployeeRepository repository) {
//     this.repository = repository;
//   }

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  private final EmployeeModelAssembler assembler;

  EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {

    this.repository = repository;
    this.assembler = assembler;
  }

  // Aggregate root
  // tag::get-aggregate-root[]

  // 原本的Aggregate root
  // @GetMapping("/employees")
  // List<Employee> all() {
  // return repository.findAll();
  // }
  // @GetMapping("/employees")
  // CollectionModel<EntityModel<Employee>> all() {
  // // 是另一個 Spring HATEOAS 容器；它旨在封裝資源集合，而不是像EntityModel<>之前那樣封裝單個資源實體
  // List<EntityModel<Employee>> employees = repository.findAll().stream()
  // .map(employee -> EntityModel.of(employee,
  // linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
  // linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
  // .collect(Collectors.toList());

  // return CollectionModel.of(employees,
  // linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
  // }

  @GetMapping("/employees")
  CollectionModel<EntityModel<Employee>> all() {

    List<EntityModel<Employee>> employees = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
  }

  // end::get-aggregate-root[]

  // @PostMapping("/employees")
  // Employee newEmployee(@RequestBody Employee newEmployee) {
  // return repository.save(newEmployee);
  // }
  @PostMapping("/employees")
  ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

    EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  // Single item

  // 不是RESTful

  // @GetMapping("/employees/{id}")
  // Employee one(@PathVariable Long id) {

  // return repository.findById(id)
  // .orElseThrow(() -> new EmployeeNotFoundException(id));
  // }

  // 用RESTful
  // @GetMapping("/employees/{id}")
  // EntityModel<Employee> one(@PathVariable Long id) {

  // Employee employee = repository.findById(id) //
  // .orElseThrow(() -> new EmployeeNotFoundException(id));

  // return EntityModel.of(employee, //
  // linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
  // linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
  // }

  @GetMapping("/employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {

    Employee employee = repository.findById(id) //
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    return assembler.toModel(employee);
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}