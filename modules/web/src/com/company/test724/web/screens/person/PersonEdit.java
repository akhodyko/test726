package com.company.test724.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import com.company.test724.entity.Person;


/**
* Created by Aleksandr Khodyko on 15.07.2020.
*/
@UiController("test724_Person.edit")
@UiDescriptor("person-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonEdit extends StandardEditor<Person> {
}