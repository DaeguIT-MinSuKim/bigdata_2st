package kr.co.dgit.bigdate.mybatis_dev;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import kr.co.dgit.bigdate.mybatis_dev.dto.PhoneNumber;
import kr.co.dgit.bigdate.mybatis_dev.dto.Student;
import kr.co.dgit.bigdate.mybatis_dev.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
	}

	/*
	 * @Test public void testInsertStudent() { Calendar cal =
	 * Calendar.getInstance();
	 * 
	 * cal.clear(); cal.set(1980, 0, 1);
	 * 
	 * Student insStd=new Student(); insStd.setStudId(5); insStd.setName("박경아");
	 * insStd.setEmail("pka@asd.asd"); insStd.setPhone(new
	 * PhoneNumber("010-123-1234")); insStd.setDob(cal.getTime());
	 * 
	 * int res= studentService.insertStudent(insStd); Assert.assertEquals(1,
	 * res); }
	 */
	@Test
	public void testInsertStudentAutoInc() {
		Calendar cal = Calendar.getInstance();

		cal.clear();
		cal.set(1980, 0, 1);

		Student insStd = new Student();
		insStd.setName("박경아2");
		insStd.setEmail("pka@asd.asd");
		insStd.setPhone(new PhoneNumber("010-123-1234"));
		insStd.setDob(cal.getTime());

		int res = studentService.insertStudent(insStd);
		Assert.assertEquals(1, res);
	}
	
	
}
