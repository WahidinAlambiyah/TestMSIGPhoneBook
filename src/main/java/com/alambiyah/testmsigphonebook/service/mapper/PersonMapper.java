package com.alambiyah.testmsigphonebook.service.mapper;

import com.alambiyah.testmsigphonebook.domain.Person;
import com.alambiyah.testmsigphonebook.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {}
