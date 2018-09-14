package startSSM.Service;

import org.springframework.stereotype.Service;
import startSSM.Model.Student;

public interface StudentService{
	public Student getStudentInfo(int id);
}

