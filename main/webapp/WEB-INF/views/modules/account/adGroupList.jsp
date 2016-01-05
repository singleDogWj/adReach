<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>企业账户管理</title>
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
		<li class="active"><a href="${ctx}/account/adGroup/">企业账户列表</a></li>
		<shiro:hasPermission name="account:adGroup:edit"><li><a href="${ctx}/account/adGroup/form">企业账户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="adGroup" action="${ctx}/account/adGroup/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>企业名称：</label>
				<form:input path="groupName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>企业编号：</label>
				<form:input path="groupNum" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>账户状态：</label>
				<form:input path="isActive" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>企业名称</th>
				<th>企业编号</th>
				<th>账户状态</th>
				<th>备注信息</th>
				<th>更新时间</th>
				<shiro:hasPermission name="account:adGroup:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="adGroup">
			<tr>
				<td><a href="${ctx}/account/adGroup/form?id=${adGroup.id}">
					${adGroup.groupName}
				</a></td>
				<td>
					${adGroup.groupNum}
				</td>
				<td>
					${adGroup.isActive}
				</td>
				<td>
					${adGroup.remarks}
				</td>
				<td>
					<fmt:formatDate value="${adGroup.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="account:adGroup:edit"><td>
    				<a href="${ctx}/account/adGroup/form?id=${adGroup.id}">修改</a>
					<a href="${ctx}/account/adGroup/delete?id=${adGroup.id}" onclick="return confirmx('确认要删除该企业账户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>