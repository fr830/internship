<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/courses.css" rel="stylesheet" />
<link href="styles/course.css" rel="stylesheet" />

<body>
<jsp:include page="../nav/nav.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active">
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href="teacherinfo"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href="teachercourses"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                <li><a href=""><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li><a href=""><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

               
               <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">   
                        <div class="panel-heading">
                        		<h3 class="panel-title">作业 Homework</h3>
                        	</div>                         
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table id="mytable" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>学号</th>                                                   
                                                    <th>姓名</th>
                                                    <th>作业名称</th>
                                                    <th>上传日期</th>                                                   
                                                    <th class="position">下载</th>
                                                    <th class="position">打分</th>
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                               <tr>
                                               		<td class="sno">S201425024</td>                                              	
                                               		<td>陈晓晓</td>
                                               		<td>移动开发技术第一次作业</td>
                                               		<td>2016年4月30日</td>                                         
                                               		<td><a href="#"><span class="glyphicon glyphicon-save do"></span></a></td>
                                               		
	                                           		<td class="thin-width">
	                                           			<input type="text" class="form-control input-block input-score"/>
	                                           		</td>
                                               </tr>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>    
             </div>
</div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
<script src="scripts/tscore.js"></script>
</body>
</html>