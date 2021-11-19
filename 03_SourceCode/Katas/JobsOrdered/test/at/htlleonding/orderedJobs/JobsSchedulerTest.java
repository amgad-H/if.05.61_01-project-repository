package at.htlleonding.orderedJobs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobsSchedulerTests {
    @Test
    public void itShouldReturnA_GivenA(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        assertEquals("A", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenAB(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        //act
        sut.sort();
        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenABC(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("D");
        //act
        sut.sort();
        //assert
        assertEquals("ABD", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenBDependantOnA(){
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B", "A");
        //act
        sut.sort();
        //assert
        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenCDependantOnB_AndBDependantOnA(){
        var sut = new JobsScheduler();
        sut.registerJob("B", "A");
        sut.registerJob("C", "B");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenABB(){
        var sut = new JobsScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("B");

        sut.sort();

        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenBDependantOnA_AndCDependantOnB(){
        var sut = new JobsScheduler();
        sut.registerJob("C", "B");
        sut.registerJob("B", "A");


        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    void itShouldReturnBA_GivenBA() {
        //arrange
        var sut = new JobsScheduler();
        sut.registerJob("B");
        sut.registerJob("A");

        //act
        sut.sort();

        //assert
        assertEquals("BA", sut.getList());
    }
}