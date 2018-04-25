<%--
  Created by IntelliJ IDEA.
  User: Alan
  Date: 2018/4/21
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>添加学生</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.min2.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <link rel="stylesheet" href="css/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link rel="stylesheet" href="css/jquery.gritter.css" />
    <script src="js/bootstrap.min2.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery-1.8.3.min.js" type="application/javascript"></script>
    <script src="js/jquery.validate.js" type="application/javascript"></script>
    <style type="text/css">
        .error {
            display: inline;
            overflow: hidden;
            padding: 0 8px 0 0;
            position: relative;
            color: red;

        }
    </style>
    <script type="text/javascript">
        $(function () {
            //让当前表单调用validate方法，实现表单验证功能
            $("#addstu").validate({
                rules: {     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
                    name: {
                        required: true,  //必填。如果验证方法不需要参数，则配置为true
                        rangelength: [2, 40]
                    },
                    mark: {
                        rangelength: [0, 255]
                    },
                    date: {
                        required: true  //必填。如果验证方法不需要参数，则配置为true
                    },
                    score: {
                        required: true,//必填。如果验证方法不需要参数，则配置为true
                        number: true,
                        range: [0, 100]
                    }
                },
                messages: {
                    name: {
                        required: "请输入姓名",
                        rangelength: $.validator.format("用户名长度在必须为：{2}-{40}之间")
                    },
                    mark: {
                        rangelength: jQuery.format("最多输入255个字符")
                    },
                    date: {
                        required: "请选择出生日期"  //必填。如果验证方法不需要参数，则配置为true
                    },
                    score: {
                        required: "请输入成绩",  //必填。如果验证方法不需要参数，则配置为true
                        number: "请输入合法的数字",
                        range: jQuery.format("请输入一个介于 0 和 100 之间的值")
                    }
                }
            });
        });
    </script>
</head>

<body>

<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">学生管理系统</a></h1>
</div>
<!--close-Header-part-->

<!--sidebar-menu-->
<div id="sidebar">
    <a href="#" class="visible-phone"><i class="icon icon-home"></i></a>
    <ul class="submenu">
        <li>
            <a href="${pageContext.request.contextPath}/index"><i class="icon icon-home"></i> <span>学生信息管理</span></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/index">学生列表</a>
        </li>
        <li class="active">
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
    <div class="row-fluid">
        <div class="span12">
            <div class="widget-box">
                <div class="widget-title"><span class="icon"> <i class="icon-info-sign"></i> </span>
                    <h4 style="color: darkgrey;">添加学生</h4>
                </div>
                <div class="widget-content nopadding">
                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/add" name="addstu" id="addstu">
                        <div class="control-group">
                            <label class="control-label">学生姓名</label>
                            <div class="controls">
                                <input type="text" name="name" id="name">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">出生日期</label>
                            <div class="controls">
                                <input type="date" name="date" id="date">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">平均分数</label>
                            <div class="controls">
                                <input type="text" name="score" id="score">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">备注</label>
                            <div class="controls">
                                <textarea id="mark" name="mark"></textarea>
                            </div>
                        </div>
                        <div class="form-actions">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="重置" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" value="提交" class="btn btn-success" align="left">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
    <div id="footer" class="span12"> 2018 &copy; Alan Zhang.
    </div>
</div>

<!--end-Footer-part-->

</body>

</html>
