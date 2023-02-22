package modelstudent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    public void student() {
        Student student = new Student("Jane Jensen", 22);
        assertNotNull(student);
        assertEquals("Jane Jensen", student.getName());
        assertEquals(22, student.getAge());
    }

    @Test
    public void setName() {
        Student student = new Student("Jane Jensen", 22);
        student.setName("Hugo Mortensen");
        assertEquals("Hugo Mortensen", student.getName());
    }

    @Test
    public void setAge() {
        Student student = new Student("Jane Jensen", 22);
        student.setAge(33);
        assertEquals(33, student.getAge());
    }

    @Test
    void averageGrade() {
        // Arrange
        Student student = new Student("Jane Jensen", 22);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        // Act
        double actualResult = student.averageGrade();
        // Assert
        assertEquals(7, actualResult, 0.0001);

    }

    @Test
    public void averageGradeException() {
        // Arrange
        Student student = new Student("Jane Jensen", 22);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        student.addGrade(12);
        student.addGrade(2);
        student.addGrade(7);
        // Act & Assert
        Exception exception = assertThrows(TooManyGradesException.class, () -> {
            student.addGrade(12);
        });
        assertEquals(exception.getMessage(), "For mange karakterer givet");
    }
}
