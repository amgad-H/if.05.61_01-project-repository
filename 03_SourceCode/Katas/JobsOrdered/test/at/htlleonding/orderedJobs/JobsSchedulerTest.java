package at.htlleonding.orderedJobs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobsSchedulerTest {
    @Test
    public void itShouldReturnA_GivenA() {
        // arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");

        // act
        sut.sort();

        // assert
        assertEquals("A", sut.getList());
    }

    @Test
    void itShouldReturnAB_GivenAB() {
        //arranged
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");

        //act
        sut.sort();

        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    void itShouldReturnABC_GivenABC() {
        //arranged
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("C");

        //act
        sut.sort();

        //assert
        assertEquals("ABC", sut.getList());
    }

    @Test
    void itShouldReturnAB_GivenBDependsOnA() {
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B", "A");

        //act
        sut.sort();
    }
}