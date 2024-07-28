package com.alambiyah.testmsigphonebook.domain;

import static com.alambiyah.testmsigphonebook.domain.ContactTestSamples.*;
import static com.alambiyah.testmsigphonebook.domain.PersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.alambiyah.testmsigphonebook.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Contact.class);
        Contact contact1 = getContactSample1();
        Contact contact2 = new Contact();
        assertThat(contact1).isNotEqualTo(contact2);

        contact2.setId(contact1.getId());
        assertThat(contact1).isEqualTo(contact2);

        contact2 = getContactSample2();
        assertThat(contact1).isNotEqualTo(contact2);
    }

    @Test
    void contactpersonTest() {
        Contact contact = getContactRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        contact.setContactperson(personBack);
        assertThat(contact.getContactperson()).isEqualTo(personBack);

        contact.contactperson(null);
        assertThat(contact.getContactperson()).isNull();
    }
}
