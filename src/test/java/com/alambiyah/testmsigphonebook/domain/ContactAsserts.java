package com.alambiyah.testmsigphonebook.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertContactAllPropertiesEquals(Contact expected, Contact actual) {
        assertContactAutoGeneratedPropertiesEquals(expected, actual);
        assertContactAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertContactAllUpdatablePropertiesEquals(Contact expected, Contact actual) {
        assertContactUpdatableFieldsEquals(expected, actual);
        assertContactUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertContactAutoGeneratedPropertiesEquals(Contact expected, Contact actual) {
        assertThat(expected)
            .as("Verify Contact auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertContactUpdatableFieldsEquals(Contact expected, Contact actual) {
        assertThat(expected)
            .as("Verify Contact relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getNumber()).as("check number").isEqualTo(actual.getNumber()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertContactUpdatableRelationshipsEquals(Contact expected, Contact actual) {
        assertThat(expected)
            .as("Verify Contact relationships")
            .satisfies(e -> assertThat(e.getContactperson()).as("check contactperson").isEqualTo(actual.getContactperson()));
    }
}
