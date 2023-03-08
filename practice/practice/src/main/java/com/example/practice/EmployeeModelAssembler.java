package com.example.practice;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

// 您是否注意到單個員工鏈接創建中的重複？提供指向員工的單一鏈接以及創建指向聚合根的“員工”鏈接的代碼顯示了兩次。
// 簡單地說，你需要定義一個將Employee對象轉換為EntityModel<Employee>對象的函數。

@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {

        return EntityModel.of(employee, //
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}