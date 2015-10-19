<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>导航菜单</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css">
<script type="text/javascript">
	function menuClick(menu) {
		/* $(menu).next().toggle(); */
 		$(menu).next().slideToggle();
	}
</script>
</head>
<body style="margin: 0">
	<div id="Menu">
		<!-- 显示一级菜单 -->
		<ul id="MenuUl">
			<s:iterator value="#application.topPrivilegeList">
				<li class="level1">
					<div onclick="menuClick(this)" class="level1Style">
						<img src="style/images/MenuIcon/${id }.gif" class="Icon">${name }
					</div>
					<ul style="" class="MenuLevel2" id="level2Menu">
						<!-- 显示二级菜单 -->
						<s:iterator value="children">
							<li class="level2">
								<div class="level2Style">
									<img src="style/images/MenuIcon/menu_arrow_single.gif">
									${name }
								</div>
							</li>
						</s:iterator>
					</ul>
				</li>
			</s:iterator>
		</ul>
	</div>


</body>
</html>