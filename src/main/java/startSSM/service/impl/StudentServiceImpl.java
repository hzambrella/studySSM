package startSSM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startSSM.dao.StudentDAO;
import startSSM.model.Student;
import startSSM.service.IStudentService;

@Service("StudentService")
public class StudentServiceImpl implements IStudentService{
	@Autowired
	StudentDAO studentDao;
	
	public Student getStudentInfo(int id){
		return studentDao.getStudentById(id);
	}
}