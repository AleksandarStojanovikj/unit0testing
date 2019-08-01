import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private String surname;
    private int age;
    private double averageGrade;
    private int numberOfSubjects;
    private double startTestGrade;

    public boolean comparesWith(Student student) {

        //studentAisBetterThenStudentB
        if (student.getAverageGrade() > this.averageGrade && student.getNumberOfSubjects() >= this
                .getNumberOfSubjects() && !this.equals(student)) {
            return true;
        }
        //studentBisBetterThenStudentA
        if (student.getNumberOfSubjects() <= this.getNumberOfSubjects() && student.getAverageGrade() < this
                .getAverageGrade() && !this.equals(student)) {
            return true;
        }
        //checkIfItIsTheSameStudent
        if (this.equals(student)) {
            return true;
        }
        //studentAHasBecomeBetterInTimeThanB
        if (student.getAverageGrade() > student.getStartTestGrade() && this.getAverageGrade() < this
                .getStartTestGrade()) {
            return true;
        }

        //studentBHasBecomeBetterInTimeThanA
        if (student.getAverageGrade() < student.getStartTestGrade() && this.getAverageGrade() > this
                .getStartTestGrade()) {
            return true;
        }
        //bothStudentsHaveBecomeBetterInTime
        if (student.getAverageGrade() > student.getStartTestGrade() && this.getStartTestGrade() > this
                .getStartTestGrade()) {
            return true;
        }

        //bothStudentsHaveNotBecomeBetterInTime
        if (student.getAverageGrade() < student.getStartTestGrade() && this.getStartTestGrade() < this
                .getStartTestGrade()) {
            return true;
        }

        return false;
    }

    public int addTwoNumbers(int one, int two) {
        return one + two;
    }
}
