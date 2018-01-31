package com.dipakpawar;

import org.junit.Test;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassLoadingTest {

    @Test
    public void should_load_jcommander() {
        // when
        URL resource = this.getClass().getClassLoader().getResource("com/beust/jcommander");

        // then
        assertThat(resource).isNotNull();
    }

    @Test
    public void should_load_junit() {
        // when
        URL resource = this.getClass().getClassLoader().getResource("junit");

        // then
        assertThat(resource).isNotNull();
    }

}
