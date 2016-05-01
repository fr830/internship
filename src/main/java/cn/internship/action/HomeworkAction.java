package cn.internship.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.internship.entity.Homework;
import cn.internship.entity.Student;
import cn.internship.service.HomeworkService;
import cn.internship.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 上传作业的相关请求与操作
 * @author MengHan
 */
public class HomeworkAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private HomeworkService homeworkService;
	private StudentService studentService;
	
	//待上传文件的各种信息
	private String title;
	private File uploadFile;
	private String uploadContentType;
	private String uploadFileName;
	
	//选的课程的ID
	private Integer courseId;
	
	@Override
	public String execute() throws Exception {
		//当前服务器路径
		String basePath = ServletActionContext.getServletContext().getRealPath(File.separator);
		//当前用户存文件的路基
		Student student = (Student) request.getSession().getAttribute("currentUser");
		String folderPath = basePath + student.getSno() ;
		//文件路径
		String filePath = folderPath + File.separator + getUploadFileName();
		
		//判断文件夹是否存在，不存在的话，创建文件夹路径
		File file = new File(folderPath);
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		FileInputStream fis = new FileInputStream(getUploadFile());
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=fis.read(buffer))>0){
			fos.write(buffer, 0, len);
		}
		
		System.out.println(basePath);
		System.out.println(folderPath);
		System.out.println(filePath);
		return super.execute();
	}
	
	
	//罗列指定课程下的所有作业
	public String listHomeworkByCourse(){
		List<Homework> homeworks = homeworkService.getByCourse(courseId);
		int n = homeworks.size();
		List<String> snoList = new ArrayList<String>(n);
		List<String> snameList = new ArrayList<String>(n);
		
		for(int i=0;i<n;i++){
//			int courseId = homeworks.get(i).getCourseId();
			int studentId = homeworks.get(i).getStudentId();
			Student student = studentService.get(studentId);
			snoList.add(student.getSno());
			snameList.add(student.getName());
		}
		List<ComprehensiveHomeworkInfo> comprehensiveHomeworkInfos = new ArrayList<HomeworkAction.ComprehensiveHomeworkInfo>(n);
		for(int i=0;i<n;i++){
			ComprehensiveHomeworkInfo comprehensiveHomeworkInfo = new ComprehensiveHomeworkInfo();
			comprehensiveHomeworkInfo.setHomework(homeworks.get(i));
			comprehensiveHomeworkInfo.setName(snameList.get(i));
			comprehensiveHomeworkInfo.setNo(snoList.get(i));
			comprehensiveHomeworkInfos.add(comprehensiveHomeworkInfo);
		}
		
		request.setAttribute("comprehensiveHomeworkInfos", comprehensiveHomeworkInfos);
		return SUCCESS;
	}
	
	private class ComprehensiveHomeworkInfo{
		private Homework homework;
		private String name;
		private String no;
		public Homework getHomework() {
			return homework;
		}
		public void setHomework(Homework homework) {
			this.homework = homework;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		
	}
	
	//-----------------------get与set方法-------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HomeworkService getHomeworkService() {
		return homeworkService;
	}


	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	
	
	
}