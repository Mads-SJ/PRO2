package controller;

import modelstudent.Student;
import modelstudent.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller;


    @BeforeEach
    void setUp() {
        controller = Controller.getTestController();
    }

    @Test
    void createTeam() {
        assertEquals(0, controller.getAllTeams().size());
        //act
        Team t = controller.createTeam("T1", "R1");
        //assert
        assertNotNull(t);
        assertTrue(controller.getAllTeams().contains(t));
        assertEquals("T1", t.getName());
        assertEquals("R1", t.getRoom());
    }

    @Test
    void createStudent() {
        assertEquals(0, controller.getAllStudents().size());
        //act
        Student s = controller.createStudent("N1", 20);
        //assert
        assertNotNull(s);
        assertTrue(controller.getAllStudents().contains(s));
        assertEquals("N1", s.getName());
        assertEquals(20, s.getAge());
    }

    @Test
    void addStudentToTeam() {
        // arrange
        Team t = controller.createTeam("T1", "R1");
        Student s = controller.createStudent("N1", 20);
        assertEquals(0, t.getNumberOfStudents());
        //act
        controller.addStudentToTeam(s, t);
        //assert
        assertEquals(1, t.getNumberOfStudents());
        assertTrue(t.getStudents()[0].equals(s));
    }

    @Test
    void updateTeam() {
        // arrange
        Team t = controller.createTeam("T1", "R1");
        //act
        t.setName("T2");
        t.setRoom("R2");
        //assert
        assertEquals("T2", t.getName());
        assertEquals("R2", t.getRoom());
    }
}