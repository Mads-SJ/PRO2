package modelstudent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void addStudent() {
        // arrange
        Team team = new Team("The winner team", "Room A");
        Student s1 = new Student("Jane Jensen", 21);
        Student s2 = new Student("Lene Hansen", 22);
        Student[] expected = new Student[30];
        expected[0] = s1;
        expected[1] = s2;
        // act
        team.addStudent(s1);
        team.addStudent(s2);
        // assert
        assertArrayEquals(expected, team.getStudents());
    }

    @Test
    void getNumberOfStudents() {
        // arrange
        Team team = new Team("The winner team", "Room A");
        Student s1 = new Student("Jane Jensen", 21);
        Student s2 = new Student("Lene Hansen", 22);
        Student[] expected = new Student[30];
        expected[0] = s1;
        expected[1] = s2;
        // act
        team.addStudent(s1);
        team.addStudent(s2);
        // assert
        assertEquals(2, team.getNumberOfStudents());
    }
}