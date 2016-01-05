<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>员工信息查看管理</title>
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
		<li class="active"><a href="${ctx}/emp/adUser/">员工信息查看列表</a></li>
		<shiro:hasPermission name="emp:adUser:edit"><li><a href="${ctx}/emp/adUser/form">员工信息查看添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="adUser" action="${ctx}/emp/adUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>企业编号：</label>
				<form:input path="groupNum" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>会员状态：</label>
				<form:radiobuttons path="isActive" items="${fns:getDictList('is_active')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>会员类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('ad_user_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>企业编号</th>
				<th>真实姓名</th>
				<th>会员状态</th>
				<th>会员类型</th>
				<th>备注信息</th>
				<th>更新时间</th>
				<shiro:hasPermission name="emp:adUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="adUser">
			<tr>
				<td><a href="${ctx}/emp/adUser/form?id=${adUser.id}">
					${adUser.groupNum}
				</a></td>
				<td>
					${adUser.name}
				</td>
				<td>
					${fns:getDictLabel(adUser.isActive, 'is_active', '')}
				</td>
				<td>
					${fns:getDictLabel(adUser.type, 'ad_user_type', '')}
				</td>
				<td>
					${adUser.remarks}
				</td>
				<td>
					<fmt:formatDate value="${adUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="emp:adUser:edit"><td>
    				<a href="${ctx}/emp/adUser/form?id=${adUser.id}">修改</a>
					<a href="${ctx}/emp/adUser/delete?id=${adUser.id}" onclick="return confirmx('确认要删除该员工信息查看吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>