package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertEquals(testJob.getName(), "Product tester");
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().toString(), "ACME");
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().toString(), "Desert");
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().toString(), "Quality control");
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        //TODO create two job objects with identical fields except id. test for inequality
        Job testJob1 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(String.valueOf(testJob.toString().charAt(0)), "\n");
        assertEquals(String.valueOf(testJob.toString().charAt(testJob.toString().length()-1)), "\n");
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString =
                "\n" +
                        "ID: " + testJob.getId() + "\n" +
                        "Name: " + testJob.getName() + "\n" +
                        "Employer: " + testJob.getEmployer() + "\n" +
                        "Location: " + testJob.getLocation() + "\n" +
                        "Position Type: " + testJob.getPositionType() + "\n" +
                        "Core Competency: " + testJob.getCoreCompetency() + "\n";
        assertEquals(jobString, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString =
                "\n" +
                        "ID: " + testJob.getId() + "\n" +
                        "Name: " + testJob.getName() + "\n" +
                        "Employer: Data not available" + "\n" +
                        "Location: " + testJob.getLocation() + "\n" +
                        "Position Type: " + testJob.getPositionType() + "\n" +
                        "Core Competency: " + testJob.getCoreCompetency() + "\n";
        assertEquals(jobString, testJob.toString());
    }
}
