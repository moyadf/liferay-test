<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
	
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>


<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.math.RoundingMode"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.WindowState"%>

<%@ page
	import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page
	import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ page
	import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-portlet:resourceURL var="urlAjax" copyCurrentRenderParameters="<%=false %>" />