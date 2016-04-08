<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/student.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="index">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="stu-info">个人信息</a></li>
        <li><a href="weekly-plan">周计划</a></li>
        <li><a href="practical-reports">实训报告</a></li>
        <li><a href="internship-reports">实习报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li class="active"><a href="reset-pwd">修改密码</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <form>
            <div class="form-group">
              <label>初始密码：</label>
              <input type="email" class="form-control">
            </div>
            <div class="form-group">
              <label>新密码：</label>
              <input type="password" class="form-control">
            </div>
            <div class="form-group">
              <label>确认新密码：</label>
              <input type="password" class="form-control">
            </div>
            <button href="index" class="btn btn-primary fr">确认修改</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>