/**
 * 
 */
/**
 * @author lenovo
 *
 */
package startSSM.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import startSSM.DAO.StudentDAO;
import startSSM.Model.Student;
import startSSM.Service.StudentService;

@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDAO studentDao;
	
	public Student getStudentInfo(int id){
		return studentDao.getStudentById(id);
	}
}