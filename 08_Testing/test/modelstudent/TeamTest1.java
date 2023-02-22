package modelstudent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest1 {
    private Team team;
    private Student s1, s2, s3;

    @BeforeEach
    void setUp() {
        // arrange
        team = new Team("The winner team", "Room A");
        s1 = new Student("Jane Jensen", 21);
        s2 = new Student("Lene Hansen", 22);
        s3 = new Student("Mette Nielsen", 20);
        team.addStudent(s1);
        team.addStudent(s2);
    }
    @Test
    public void team() {
        // act
        Team team = new Team("Great Boys", "Room B");
        //assert
        assertNotNull(team);
        assertEquals("Great Boys", team.getName());
        assertEquals("Room B", team.getRoom());
        assertEquals(0, team.getNumberOfStudents());
        Student[] expected = new Student[30];
        assertArrayEquals(team.getStudents(), expected);

    }

    @Test
    void setName() {
        //act
        team.setName("Great Boys");
        //assert
        assertEquals("Great Boys", team.getName());
    }

    @Test
    void setRoom() {
        //act
        team.setRoom("Room B");
        //assert
        assertEquals("Room B", team.getRoom());
    }

    @Test
    void addStudent() {
        // arrange
        Student[] expected = new Student[30];
        expected[0] = s1;
        expected[1] = s2;
        expected[2] = s3;
        // act
        team.addStudent(s3);
        // assert
        assertArrayEquals(team.getStudents(), expected);
    }

    @Test
    void getNumberOfStudents() {
        // arrange
        // act
        int actualResult = team.getNumberOfStudents();
        // assert
        assertEquals(actualResult, 2);
    }
}