package TestStartSSM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.alibaba.fastjson.JSON;

import startSSM.DAO.StudentDAO;
import startSSM.Model.Scores;
import startSSM.Model.Student;
import startSSM.Service.IStudentService;


@RunWith(SpringJUnit4ClassRunner.class)
//"classpath*:startSSM-servlet.xml" 加个*，免得找不到classpath
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) 
public class TestStudentDAO {
	
	@Resource(name="StudentService")
	private IStudentService studentService;

	@Autowired
	StudentDAO studentDao;
	
//	@Test
//	public void testGetStudentById() {
//		//Student s=studentService.getStudentInfo(1);
//		Student s=studentDao.getStudentById(1);
//		System.out.println(JSON.toJSONString(s));
//		
//		List<Scores> list1=studentDao.getStudentScoresById(200);
//		System.out.println(JSON.toJSONString(list1));
//	}
//	
	
	//@Test 
	public void testGetStudentByIdAsMap(){
		Map<String,String>map=studentDao.getStudentByIdAsMap(6);
		System.out.println(map);
	}
	
//	@Test
	public void testGetStudentSumScoreById(){
		System.out.println(studentDao.getStudentSumScoreById(1));
	}
	
	
	//@Test
	public void testGetStudentsByClassId(){
		System.out.println(JSON.toJSONString(studentDao.getStudentsByClassId(2)));
	}
	
	@Test
	public void testGetStudentByScore() {
		List<Student> list1=studentDao.getStudentByScore(200);
		System.out.println(JSON.toJSONString(list1));
	}
}
