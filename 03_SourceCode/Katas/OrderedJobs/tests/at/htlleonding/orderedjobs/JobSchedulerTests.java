package at.htlleonding.orderedjobs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobSchedulerTests {
    @Test
    public void itShouldReturnA_GivenA(){
        //arrange
        var sut = new JobScheduler();
        sut.registerJob("A");
        //act
        sut.sort();
        //assert
        assertEquals("A", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenAB(){
        //arrange
        var sut = new JobScheduler();
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
        var sut = new JobScheduler();
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
        var sut = new JobScheduler();
        sut.registerJob("B", "A");
        //act
        sut.sort();
        //assert
        assertEquals("AB", sut.getList());
    }
}