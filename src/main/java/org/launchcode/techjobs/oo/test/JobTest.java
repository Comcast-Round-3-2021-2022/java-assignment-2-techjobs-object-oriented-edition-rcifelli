package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job productTester = new Job();
        Job engineer = new Job();
        assertNotEquals(productTester.getId(), engineer.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        // Test that fields of Job are of the correct type - 5 assertions
        // Use instanceOf to verify the types (along with assertTrue)
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        // Test that the *values* of the fields are correct - 5 assertions
        // Retrieve the values and compare them to the value used above
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().toString(), "ACME");
        assertEquals(job.getLocation().toString(), "Desert");
        assertEquals(job.getPositionType().toString(), "Quality control");
        assertEquals(job.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality () {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    //Part 5
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(job.toString().length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
      //create a Job object with non-empty values in the fields
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        //call getId method to have Id of object
      // call toString on the object, storing return value in a variable
            String jobStringActual = job.toString();
      //build up an expected string
            String jobStringExpected = '\n' + "ID: " + job.getId() + '\n' + "Name: Product tester" +
                    '\n' + "Employer: ACME" + '\n' + "Location: Desert" + '\n' + "Position Type: Quality control" +
                    '\n' + "Core Competency: Persistence" + '\n';
        // compare with assertEquals
        assertEquals(jobStringActual, jobStringExpected);
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job job = new Job("Web Developer",
                new Employer(""),
                new Location("StL"),
                new PositionType(""),
                new CoreCompetency("Java"));

        String jobStringActual = job.toString();
        String jobStringExpected = '\n' + "ID: " + job.getId() + '\n' + "Name: Web Developer" +
                '\n' + "Employer: Data not available" + '\n' + "Location: StL" + '\n' +
                "Position Type: Data not available" + '\n' + "Core Competency: Java" + '\n';

        assertEquals(jobStringActual, jobStringExpected);
    }
}
