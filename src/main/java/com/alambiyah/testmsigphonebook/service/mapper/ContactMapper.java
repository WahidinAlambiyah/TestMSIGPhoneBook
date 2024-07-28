package com.alambiyah.testmsigphonebook.service.mapper;

import com.alambiyah.testmsigphonebook.domain.Contact;
import com.alambiyah.testmsigphonebook.domain.Person;
import com.alambiyah.testmsigphonebook.service.dto.ContactDTO;
import com.alambiyah.testmsigphonebook.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Contact} and its DTO {@link ContactDTO}.
 */
@Mapper(componentModel = "spring")
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {
    @Mapping(target = "contactperson", source = "contactperson", qualifiedByName = "personId")
    ContactDTO toDto(Contact s);

    @Named("personId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PersonDTO toDtoPersonId(Person person);
}
