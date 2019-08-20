<%@ include file="init.jsp"%>

<section class="parallax">
	<h1 class="text-caption">
		<liferay-ui:message key="cotizatuvehiculo.caption" />
	</h1>
</section>

<%
	long tipoDocumentoCliente = ParamUtil.getLong(renderRequest, "tipoDocumento", 0);
	String numeroDocumentoCliente = ParamUtil.getString(renderRequest, "numeroDocumento", "");
	
	
	if(themeDisplay.isSignedIn() && tipoDocumentoCliente == 0 && numeroDocumentoCliente.equals("")){
%>
	<%@include file="admin.jsp"%>
<%
	}else{
%>
	<%@include file="cliente.jsp"%>
<%
	}
%>
