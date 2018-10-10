package startSSM.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import startSSM.model.Scores;
import startSSM.model.Student;

public interface StudentDAO {
	// resultType的使用
	// Map的使用
	public Map<String, String> getStudentByIdAsMap(int id);

	// 基本类型的使用和聚集函数
	public int getStudentSumScoreById(int id);

	// 返回POJO
	public List<Student> getStudentsByClassId(int classId);

	// resultMap的使用
	// collection的使用（一对多）
	public Student getStudentById(int id);

	public List<Scores> getStudentScoresById(int id);

	// 聚集函数
	public List<Student> getStudentByScore(@Param("score") double score);

	// 使用标签
	public List<Student> useTrim(Student student);
}