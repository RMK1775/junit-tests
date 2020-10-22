import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {

    public static long generateRandomLongBounded() {
        long leftLimit = 1L;
        long rightLimit = 100000L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return generatedLong;
    }

    @Test
    public void testCreateStudent(){
        Student ryan = new Student(generateRandomLongBounded(), "Ryan");
        Student bart = null;
        assertNull(ryan);
        assertNotNull(bart);
    }

    @Test
    public void testStudentFields(){
        Student screech = new Student(14L, "Screech");
        assertSame(14L, screech.getId());
        assertSame("Screech", screech.getName());
        assertSame(0, screech.getGrades().size());
    }


    @Test
    public void testAddGrade(){
        Student slater = new Student(generateRandomLongBounded(), "Slater");
        slater.addGrade(85);
        assertSame(85, slater.getGrades().get(0));
        slater.addGrade(70);
        assertSame(70, slater.getGrades().get(1));
    }

    @Test
    public void testAverageGrade(){
        Student meangirl = new Student(generateRandomLongBounded(), "Lindsay");
        meangirl.addGrade(100);
        meangirl.addGrade(80);
        assertEquals(90, meangirl.getGradeAverage(), 0);
    }
}