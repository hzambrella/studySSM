package startSSM.Model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Student{
	int id;
	String name;
	int classId;
	ArrayList<Scores> scores;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public ArrayList<Scores> getScores() {
		return scores;
	}
	public void setScores(ArrayList<Scores> scores) {
		this.scores = scores;
	}
}