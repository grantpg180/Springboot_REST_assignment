package com.rest_example.rest.payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>>{

    @Override
    public EntityModel<Employee> toModel(Employee emplotee){
        return EntityModel.of(employee, 
            linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(), 
            linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
    
}