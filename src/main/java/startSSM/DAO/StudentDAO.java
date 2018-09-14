package startSSM.DAO;

import java.util.List;

import startSSM.Model.Scores;
import startSSM.Model.Student;

public interface StudentDAO{
	public Student getStudentById(int id);
	public List<Scores> getStudentScoresById(int id);
}