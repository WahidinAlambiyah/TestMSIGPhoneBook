package com.alambiyah.testmsigphonebook.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ContactCriteriaTest {

    @Test
    void newContactCriteriaHasAllFiltersNullTest() {
        var contactCriteria = new ContactCriteria();
        assertThat(contactCriteria).is(criteriaFiltersAre(filter -> filter == null));
    }

    @Test
    void contactCriteriaFluentMethodsCreatesFiltersTest() {
        var contactCriteria = new ContactCriteria();

        setAllFilters(contactCriteria);

        assertThat(contactCriteria).is(criteriaFiltersAre(filter -> filter != null));
    }

    @Test
    void contactCriteriaCopyCreatesNullFilterTest() {
        var contactCriteria = new ContactCriteria();
        var copy = contactCriteria.copy();

        assertThat(contactCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(filter -> filter == null)),
            criteria -> assertThat(criteria).isEqualTo(contactCriteria)
        );
    }

    @Test
    void contactCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var contactCriteria = new ContactCriteria();
        setAllFilters(contactCriteria);

        var copy = contactCriteria.copy();

        assertThat(contactCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(filter -> filter != null)),
            criteria -> assertThat(criteria).isEqualTo(contactCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var contactCriteria = new ContactCriteria();

        assertThat(contactCriteria).hasToString("ContactCriteria{}");
    }

    private static void setAllFilters(ContactCriteria contactCriteria) {
        contactCriteria.id();
        contactCriteria.name();
        contactCriteria.number();
        contactCriteria.contactpersonId();
        contactCriteria.distinct();
    }

    private static Condition<ContactCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getName()) &&
                condition.apply(criteria.getNumber()) &&
                condition.apply(criteria.getContactpersonId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ContactCriteria> copyFiltersAre(ContactCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getName(), copy.getName()) &&
                condition.apply(criteria.getNumber(), copy.getNumber()) &&
                condition.apply(criteria.getContactpersonId(), copy.getContactpersonId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
