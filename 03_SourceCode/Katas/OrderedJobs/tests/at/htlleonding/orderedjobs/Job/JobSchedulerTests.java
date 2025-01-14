package at.htlleonding.orderedjobs.Job;

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

    @Test
    public void itShouldReturnABC_GivenCDependantOnB_AndBDependantOnA(){
        var sut = new JobScheduler();
        sut.registerJob("B", "A");
        sut.registerJob("C", "B");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnAB_GivenABB(){
        var sut = new JobScheduler();
        sut.registerJob("A");
        sut.registerJob("B");
        sut.registerJob("B");

        sut.sort();

        assertEquals("AB", sut.getList());
    }

    @Test
    public void itShouldReturnABC_GivenBDependantOnA_AndCDependantOnB(){
        var sut = new JobScheduler();
        sut.registerJob("C", "B");
        sut.registerJob("B", "A");

        sut.sort();

        assertEquals("ABC", sut.getList());
    }

    @Test
    public void itShouldReturnBA_GivenBA(){
        var sut = new JobScheduler();
        sut.registerJob("B");
        sut.registerJob("A");

        sut.sort();

        assertEquals("BA", sut.getList());
    }

    @Test
    public void itShouldReturnBACDEF_GivenB_andA_andFdependantOnE_andEdependantOnD_andDdependantOnC_andCdependantOnA(){
        var sut = new JobScheduler();
        sut.registerJob("B");
        sut.registerJob("A");
        sut.registerJob("F", "E");
        sut.registerJob("E", "D");
        sut.registerJob("D", "C");
        sut.registerJob("C", "A");

        sut.sort();

        assertEquals("BACDEF", sut.getList());
    }

    @Test
    public void itShouldReturnBACDEF_GivenB_andA_andEdependantOnF_andFdependantOnC_andCdependantOnD_andDdependantOnA(){
        var sut = new JobScheduler();
        sut.registerJob("B");
        sut.registerJob("A");
        sut.registerJob("E", "F");
        sut.registerJob("F", "C");
        sut.registerJob("C", "D");
        sut.registerJob("D", "A");

        sut.sort();

        assertEquals("BACDEF", sut.getList());
    }
}