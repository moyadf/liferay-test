<%@page import="com.dbsystem.cotizatuvehiculo.service.ClienteLocalServiceUtil"%>
<%@ include file="init.jsp"%>


<aui:form name="eliminarVehiculoForm" action="${eliminarVehiculoURL}" method="POST" >
	<liferay-ui:search-container delta="2" emptyResultsMessage="No se encontraron vehiculos!!" >
	    <liferay-ui:search-container-results  results="<%=ClienteLocalServiceUtil.getClientes(-1, -1) %>" />
	   
	    <liferay-ui:search-container-row className="com.dbsystem.cotizatuvehiculo.model.Cliente" keyProperty="clienteId" modelVar="cliente">
	    	
	    	<c:choose>
		    	<c:when test="${cliente.tipoDocumento==1}"><c:set var="tipoDocumento" value="Cédula"/></c:when>
		    	<c:when test="${cliente.tipoDocumento==2}"><c:set var="tipoDocumento" value="NIT"/></c:when>
		    	<c:when test="${cliente.tipoDocumento==3}"><c:set var="tipoDocumento" value="Pasaporte"/></c:when>
	    	</c:choose>
	    
			<liferay-ui:search-container-column-text name="Nombre" value="${cliente.nombres} ${cliente.apellidos}" />
	        <liferay-ui:search-container-column-text name="Identificación" value="${tipoDocumento} ${cliente.numeroDocumento}" />
	        <liferay-ui:search-container-column-text name="Celular" value="${cliente.celular}" />
	        <liferay-ui:search-container-column-text name="Email" value="${cliente.email}" />
	        
<%-- 	        <portlet:actionURL name="desactivarCliente" var="eliminarVehiculoURL" /> --%>
			
			
			<portlet:actionURL name="buscarCliente" var="verClienteURL">
				<portlet:param name="tipoDocumento" value="${cliente.tipoDocumento}"/>
				<portlet:param name="numeroDocumento" value="${cliente.numeroDocumento}"/>
			</portlet:actionURL>
			
	        <liferay-ui:search-container-column-text name="Ver" >
	        	<aui:button href="${verClienteURL}" icon="glyphicon glyphicon-search" type="button" />
<%-- 	        	<aui:button href="${desactivarCliente}" icon="glyphicon glyphicon-remove" type="button" /> --%>
	        </liferay-ui:search-container-column-text>
	        
	    </liferay-ui:search-container-row>
	    <liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>