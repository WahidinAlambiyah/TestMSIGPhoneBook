package com.alambiyah.testmsigphonebook;

import com.alambiyah.testmsigphonebook.config.AsyncSyncConfiguration;
import com.alambiyah.testmsigphonebook.config.EmbeddedRedis;
import com.alambiyah.testmsigphonebook.config.EmbeddedSQL;
import com.alambiyah.testmsigphonebook.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { TestMsigPhoneBookApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
public @interface IntegrationTest {
}
