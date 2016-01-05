<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>账户管理管理</title>
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
		<li class="active"><a href="${ctx}/account/adBusiness/">账户管理列表</a></li>
		<shiro:hasPermission name="account:adBusiness:edit"><li><a href="${ctx}/account/adBusiness/form">账户管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="adBusiness" action="${ctx}/account/adBusiness/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商户名称：</label>
				<form:input path="company" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>商户编号：</label>
				<form:input path="businessId" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>返利类型：</label>
				<form:radiobuttons path="userRebateType" items="${fns:getDictList('user_rebate_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商户名称</th>
				<th>商户类型</th>
				<th>商户编号</th>
				<th>返利类型</th>
				<th>账户状态</th>
				<th>删除标记</th>
				<shiro:hasPermission name="account:adBusiness:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="adBusiness">
			<tr>
				<td><a href="${ctx}/account/adBusiness/form?id=${adBusiness.id}">
					${adBusiness.company}
				</a></td>
				<td>
					${fns:getDictLabel(adBusiness.type, 'business_type', '')}
				</td>
				<td>
					${adBusiness.businessId}
				</td>
				<td>
					${fns:getDictLabel(adBusiness.userRebateType, 'user_rebate_type', '')}
				</td>
				<td>
					${adBusiness.isActive}
				</td>
				<td>
					${fns:getDictLabel(adBusiness.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="account:adBusiness:edit"><td>
    				<a href="${ctx}/account/adBusiness/form?id=${adBusiness.id}">修改</a>
					<a href="${ctx}/account/adBusiness/delete?id=${adBusiness.id}" onclick="return confirmx('确认要删除该账户管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>