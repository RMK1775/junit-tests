import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort emptyCohort;
    Cohort cohortConUno;
    Cohort cohortMuchoPersonas;

    @Before
    public void setup(){
        emptyCohort = new Cohort();
        cohortConUno = new Cohort();
        cohortMuchoPersonas = new Cohort();

        Student marty = new Student(2020001, "Marty McFly");
        marty.addGrade(87);

        Student rj = new Student(202002, "Rick James");
        rj.addGrade(100);
        rj.addGrade(100);
        rj.addGrade(100);

        cohortConUno.addStudent(marty);
        cohortMuchoPersonas.addStudent(marty);
        cohortMuchoPersonas.addStudent(rj);
    }

    @Test
    public void testAddStudentWorks(){
        cohortMuchoPersonas.addStudent(new Student(202003, "Will Witwicky"));
        assertEquals("Will Witwicky", cohortMuchoPersonas.getStudents().get(2).getName());

        cohortMuchoPersonas.addStudent(new Student(202004, "Wesley Crusher"));
        assertEquals(4, cohortMuchoPersonas.getStudents().size());
    }

    @Test
    public void testIfGetStudentsWork(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortConUno.getStudents().size());

        assertEquals(1, cohortMuchoPersonas.getStudents().get(0).getId());
        assertEquals(2, cohortMuchoPersonas.getStudents().get(1).getId());
    }

    @Test
    public void testIfAvgIsCorrect(){
        assertEquals(Double.NaN, emptyCohort.getCohortAverage(), 0);
        assertEquals(90.0, cohortConUno.getCohortAverage(), 0);
        assertEquals(95.0, cohortMuchoPersonas.getCohortAverage(), 0);
    }

}
