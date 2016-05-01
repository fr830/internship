package internship;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.internship.dao.CourseDao;
import cn.internship.entity.CaseLibrary;
import cn.internship.entity.Course;
import cn.internship.entity.Student;

public class TestUtil {

	@Test
	public void testList(){
		List<String> list = new ArrayList<String>();
		System.out.println(list.size());
	}
	
	@Test
	public void testTime(){
		System.out.println(new Date().getTime());
	}
	
	@Test
	public void testTable(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao) context.getBean("courseDao");
//		List<Course> list =  courseDao.getBySno(1);
//		System.out.println(list.size());
//		Course course = list.get(0);
//		System.out.println(course.getName());
		List<Course> list =  courseDao.getByTno(1);
		System.out.println(list.size());
		Course course = list.get(0);
		System.out.println(course.getName());
	}
	
	@Test
	public void testScore(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao) context.getBean("courseDao");
		System.out.println(courseDao.getCourseScore(1, 3));
	}
	
	@Test
	public void testNull(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add(null);
		list.add("5");
		list.add("6");
		list.add(null);
		for(String s1:list){
			System.out.println(s1);
		}
	}
	
	@Test
	public void testCourse(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDao courseDao = (CourseDao) context.getBean("courseDao");
		List<Course> courses = courseDao.getByTno(1);
		Iterator<CaseLibrary> iterator = courses.get(0).getCaseLibraries().iterator();
		while(iterator.hasNext()){
			CaseLibrary caseLibrary = iterator.next();
			System.out.println(caseLibrary.getName());
		}
	}
	
}
