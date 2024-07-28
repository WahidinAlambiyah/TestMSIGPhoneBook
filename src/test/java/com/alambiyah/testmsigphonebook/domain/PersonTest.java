package com.alambiyah.testmsigphonebook.domain;

import static com.alambiyah.testmsigphonebook.domain.ContactTestSamples.*;
import static com.alambiyah.testmsigphonebook.domain.PersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.alambiyah.testmsigphonebook.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Person.class);
        Person person1 = getPersonSample1();
        Person person2 = new Person();
        assertThat(person1).isNotEqualTo(person2);

        person2.setId(person1.getId());
        assertThat(person1).isEqualTo(person2);

        person2 = getPersonSample2();
        assertThat(person1).isNotEqualTo(person2);
    }

    @Test
    void contactpersonTest() {
        Person person = getPersonRandomSampleGenerator();
        Contact contactBack = getContactRandomSampleGenerator();

        person.addContactperson(contactBack);
        assertThat(person.getContactpeople()).containsOnly(contactBack);
        assertThat(contactBack.getContactperson()).isEqualTo(person);

        person.removeContactperson(contactBack);
        assertThat(person.getContactpeople()).doesNotContain(contactBack);
        assertThat(contactBack.getContactperson()).isNull();

        person.contactpeople(new HashSet<>(Set.of(contactBack)));
        assertThat(person.getContactpeople()).containsOnly(contactBack);
        assertThat(contactBack.getContactperson()).isEqualTo(person);

        person.setContactpeople(new HashSet<>());
        assertThat(person.getContactpeople()).doesNotContain(contactBack);
        assertThat(contactBack.getContactperson()).isNull();
    }
}
