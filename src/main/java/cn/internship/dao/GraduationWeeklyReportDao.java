package cn.internship.dao;

import java.util.List;

import cn.internship.entity.GraduationWeeklyReport;
import cn.internship.entity.WeeklyReport;

public interface GraduationWeeklyReportDao {

	// 通过主键找到指定周报
		public GraduationWeeklyReport get(Integer id);

		// 通过主键删除指定周报
		public void delete(Integer id);

		// 通过主键修改指定周报
		public void update(GraduationWeeklyReport graduationWeeklyReport);

		// 增加一条周报数据
		public void save(GraduationWeeklyReport graduationWeeklyReport);

		// 获得所有周报
		public List<GraduationWeeklyReport> getAll(String studentId);
}
