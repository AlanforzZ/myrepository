<%--
  Created by IntelliJ IDEA.
  User: Alan
  Date: 2018/4/21
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>学生管理系统</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/jquery.gritter.css" />
    <!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>-->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        #top_th th {
            font-size: 15px;
            color: darkgrey;
        }

    </style>
    <script type="text/javascript">
        function isdelete(id){
            var is = confirm("确认删除？");
            if(is){
                window.location.href="${pageContext.request.contextPath}/delete?id="+id
            }
        }

    </script>
</head>

<body>

<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part-->

<!--sidebar-menu-->
<div id="sidebar">
    <a href="#" class="visible-phone"><i class="icon icon-home"></i></a>
    <ul class="submenu">
        <li>
            <a href="${pageContext.request.contextPath}/index"><i class="icon icon-home"></i> <span>学生信息管理</span></a>
        </li>
        <li class="active">
            <a href="${pageContext.request.contextPath}/index">学生列表</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/addUI">添加学生</a>
        </li>
    </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<!--
    作者：offline
    时间：2018-04-21
    描述：表格
-->
<div id="content">
    <div class="widget-box">
        <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>学生信息列表</h5>
        </div>
        <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
                <thead>
                <tr id="top_th">
                    <th align="center">
                    <button type="button" class="btn btn-default btn-sm" onclick="window.location.href='${pageContext.request.contextPath}/addUI'">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
                    </button>
                    </th>
                    <th>学生编号</th>
                    <th>姓名</th>
                    <th>出生日期</th>
                    <th>备注</th>
                    <th>平均分</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <<c:forEach varStatus="num" items="${pageBean.list }"  var="stu">
                    <tr>
                        <td>${num.count + pageBean.pageSize * (pageBean.pageNumber-1) }</td>
                        <td>${stu.id }</td>
                        <td>${stu.name }</td>
                        <td>${stu.birthday1 }</td>
                        <td>${stu.mark }</td>
                        <td>${stu.score }</td>
                        <td>
                            <button type="button" class="btn btn-default btn-sm" onclick="window.location.href='${pageContext.request.contextPath }/editUI?id=${stu.id }'">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                            </button>
                            <button type="button" class="btn btn-default btn-sm" onclick="isdelete('${stu.id }')" >
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 分页 -->
    <div style="width: 380px; margin: 0 auto; margin-top: 20px;">
        <ul class="pagination" style="text-align: center; margin-top: 10px;">
            <!-- 上一页 -->
            <c:if test="${pageBean.pageNumber==1 }">
                <li class="disabled"><a href="javascript:void(0);"
                                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a></li>
            </c:if>
            <c:if test="${pageBean.pageNumber!=1 }">
                <li><a
                        href="${pageContext.request.contextPath }/index?pageNumber=${pageBean.pageNumber-1 }"
                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a></li>
            </c:if>
            <c:forEach begin="1" end="${pageBean.totalPage }" var="page">
                <!-- 判断是不是当前页 -->
                <c:if test="${page==pageBean.pageNumber }">
                    <li class="active"><a href="javascript:void(0);">${page }</a></li>
                </c:if>
                <c:if test="${page!=pageBean.pageNumber }">

                    <li><a
                            href="${pageContext.request.contextPath }/index?pageNumber=${page }">${page }
                    </a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.pageNumber==pageBean.totalPage }">
                <li class="disabled"><a href="javascript:void(0);"
                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a></li>
            </c:if>
            <c:if test="${pageBean.pageNumber!=pageBean.totalPage }">
                <li><a
                        href="${pageContext.request.contextPath }/index?pageNumber=${pageBean.pageNumber+1} "
                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a></li>
            </c:if>
        </ul>
    </div>
</div>

<!--end-main-container-part-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    模态框（Modal）标题
                </h4>
            </div>
            <div class="modal-body">
                在这里添加一些文本
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--Footer-part-->

<div class="row-fluid">
    <div id="footer" class="span12"> 2018 &copy; Alan Zhang.
    </div>
</div>

<!--end-Footer-part-->

</body>

</html>
