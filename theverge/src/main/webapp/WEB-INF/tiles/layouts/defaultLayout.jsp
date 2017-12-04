<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<div id="wrapper">
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content">
			<tiles:insertAttribute name="content" />
	
	</div>

</div>