package com.dipakpawar;

import com.beust.jcommander.ParameterException;
import org.junit.Test;

import java.net.URL;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassLoadingTest {

    @Test
    public void should_load_ParameterException_class() throws ClassNotFoundException {
        // when
        Class<?> resource = this.getClass().getClassLoader().loadClass(ParameterException.class.getName());

        // then
        assertThat(resource).isNotNull();
    }

    @Test
    public void should_load_JUnit4_class() throws ClassNotFoundException {
        // when
        Class<?> resource = this.getClass().getClassLoader().loadClass(JUnit4.class.getName());

        // then
        assertThat(resource).isNotNull();
    }

}
