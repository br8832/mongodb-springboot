package com.example.mdbspringboot.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.example.mdbspringboot.model.Employee;
import com.example.mdbspringboot.services.SequenceGenerator;

//Credit: https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-boot-persistence-mongodb/README.md

@Component
public class EmployeeListener extends AbstractMongoEventListener<Employee> {

    private SequenceGenerator sequenceGenerator;

    @Autowired
    public EmployeeListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Employee.SEQUENCE_NAME));
        }
    }


}
