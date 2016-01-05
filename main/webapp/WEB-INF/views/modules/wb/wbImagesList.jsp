<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>鸟图片库管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wb/wbImages/">鸟图片库列表</a></li>
		<shiro:hasPermission name="wb:wbImages:edit"><li><a href="${ctx}/wb/wbImages/form">鸟图片库添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wbImages" action="${ctx}/wb/wbImages/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>name：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>name</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="wb:wbImages:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="wbImages">
			<tr>
				<td><a href="${ctx}/wb/wbImages/form?id=${wbImages.id}">
					${wbImages.name}
				</a></td>
				<td>
					<fmt:formatDate value="${wbImages.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${wbImages.remarks}
				</td>
				<shiro:hasPermission name="wb:wbImages:edit"><td>
    				<a href="${ctx}/wb/wbImages/form?id=${wbImages.id}">修改</a>
					<a href="${ctx}/wb/wbImages/delete?id=${wbImages.id}" onclick="return confirmx('确认要删除该鸟图片库吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>