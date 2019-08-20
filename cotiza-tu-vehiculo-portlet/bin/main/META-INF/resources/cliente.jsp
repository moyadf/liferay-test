<%@page import="com.dbsystem.cotizatuvehiculo.service.VehiculoLocalServiceUtil"%>
<%@page import="com.dbsystem.cotizatuvehiculo.model.Concesionario"%>
<%@page import="com.dbsystem.cotizatuvehiculo.model.Cliente"%>
<%@page import="com.dbsystem.cotizatuvehiculo.service.ConcesionarioLocalServiceUtil"%>
<%@page import="com.dbsystem.cotizatuvehiculo.service.ClienteVehiculoLocalServiceUtil"%>
<%@page import="com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo"%>
<%@page import="com.dbsystem.cotizatuvehiculo.model.ClienteSoap"%>
<%@page import="com.dbsystem.cotizatuvehiculo.service.ClienteLocalServiceUtil"%>
<%@page import="com.dbsystem.cotizatuvehiculo.service.CiudadesLocalServiceUtil"%>
<%@ include file="init.jsp"%>


<% 
	long tipoDocumento = ParamUtil.getLong(renderRequest, "tipoDocumento", 0);
	String numeroDocumento = ParamUtil.getString(renderRequest, "numeroDocumento", "");
	
	Cliente cliente = ClienteLocalServiceUtil.findByIdentificacion(tipoDocumento, numeroDocumento);
	
	long clienteId = Validator.isNotNull(cliente)?cliente.getClienteId():0;
	
%>

<c:set var="tipoDocumento" value="<%=tipoDocumento %>" />
<c:set var="numeroDocumento" value="<%=numeroDocumento %>" />

<h2 class="caption-text-client">
	<liferay-ui:message key="cotizatuvehiculo.caption.cliente" />
</h2>

<div style="width:80%; margin:0 auto;">
	<aui:fieldset column="<%=true%>">
		<aui:col width="100">
			<portlet:actionURL name="buscarCliente" var="buscarClienteURL" />
			
			<%if(tipoDocumento == 0 && numeroDocumento.equals("")){ %>
			
			<aui:form name="buscarClienteForm" action="${buscarClienteURL}" method="POST" >
					<aui:fieldset column="<%=true%>">
						<aui:col width="50">
							<aui:select name="tipoDocumento" label="" required="true" showRequiredLabel="false">
								<aui:option value="">Tipo documento</aui:option>
								<aui:option value="1">Cédula</aui:option>
								<aui:option value="2">Nit</aui:option>
								<aui:option value="3">Pasaporte</aui:option>
							</aui:select>
						</aui:col>
						<aui:col width="50">
							<aui:input name="numeroDocumento" label="" placeholder="Número documento*" required="true" showRequiredLabel="false"></aui:input>
						</aui:col>
					</aui:fieldset>
					
					<aui:fieldset column="<%=true%>">
						<aui:col>
							<center>
								<aui:button icon="icon-refresh" value="continuar" type="submit" primary="true" />
							</center>
						</aui:col>
					</aui:fieldset>
			</aui:form>
			
			<%}else{ %>
			
			
				<portlet:actionURL name="guardarCliente" var="guardarClienteURL">
					<portlet:param name="tipoDocumento" value="${tipoDocumento}"/>
					<portlet:param name="numeroDocumento" value="${numeroDocumento}"/>
				</portlet:actionURL>
				
				<c:set var="cliente" value="<%=cliente%>" />
	
				<aui:form name="guardarClienteForm" action="${guardarClienteURL}" method="POST" >
				
				
					<aui:input name="opcion" type="hidden" value="" />
						<aui:fieldset column="<%=true%>">
							<aui:col width="50">
								<aui:select name="tipoDocumento" label="" disabled="true">
									<aui:option value="">Tipo documento</aui:option>
									<aui:option value="1" selected="<%=(tipoDocumento==1)%>">Cédula</aui:option>
									<aui:option value="2" selected="<%=(tipoDocumento==2)%>">Nit</aui:option>
									<aui:option value="3" selected="<%=(tipoDocumento==3)%>">Pasaporte</aui:option>
								</aui:select>
							</aui:col>
							<aui:col width="50">
								<aui:input name="numeroDocumento" label="" value="${numeroDocumento}" disabled="true"></aui:input>
							</aui:col>
						</aui:fieldset>
						
						<aui:fieldset column="<%=true%>">
							<aui:col width="50">
								<aui:input name="nombres" label="" value="${cliente.nombres}" placeholder="Nombre"  required="true" showRequiredLabel="false"></aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="apellidos" label="" value="${cliente.apellidos}" placeholder="Apellido"  required="true" showRequiredLabel="false"></aui:input>
							</aui:col>
						</aui:fieldset>
						
						<aui:fieldset column="<%=true%>">
							<aui:col width="50">
								<aui:input name="celular" label="" value="${cliente.celular}" placeholder="Celular"  required="true" showRequiredLabel="false"></aui:input>
							</aui:col>
							<aui:col width="50">
								<aui:input name="email" label="" value="${cliente.email}" placeholder="Correo electrónico"  required="true" showRequiredLabel="false"></aui:input>
							</aui:col>
						</aui:fieldset>
						
						<c:if test="<%=!themeDisplay.isSignedIn()%>">
							<aui:fieldset column="<%=true%>">
								<aui:col width="25">
									<aui:select name="ciudad" onChange="cargarConsecionarios(this.value)" label=""  required="true" showRequiredLabel="false">
										<aui:option value="" selected="<%= true%>">Ciudad</aui:option>
										<c:forEach var = "ciudad" items="<%=CiudadesLocalServiceUtil.findByEstado(true)%>">
											<aui:option value="${ciudad.ciudadId}">${ciudad.ciudad}</aui:option>
								      	</c:forEach>
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select name="concesionario" onChange="cargarVehiculos(this.value)" label="" title="Debe seleccionar una ciudad"  required="true" showRequiredLabel="false">
										<aui:option value="">Concesionario</aui:option>
									</aui:select>
								</aui:col>
								
								<aui:col width="25">
									
									<aui:select name="vehiculo" label="" title="Debe seleccionar un concesionario" required="true" showRequiredLabel="false">
										<aui:option value="">Vehiculo</aui:option>
									</aui:select>
								</aui:col>
								
								<aui:col width="25">
									<aui:button style="float:right;" type="submit" cssClass="boton-grande" icon="glyphicon glyphicon-plus " value="Cotizar vehiculo" onClick="guardarCliente(1)" primary="true"></aui:button>
								</aui:col>
							</aui:fieldset>
						</c:if>
				</aui:form>
				
				<aui:form name="eliminarVehiculoForm" action="${eliminarVehiculoURL}" method="POST" >
						
					<liferay-ui:search-container delta="2" emptyResultsMessage="No se encontraron vehiculos!!" >
					    <liferay-ui:search-container-results  results="<%=ClienteVehiculoLocalServiceUtil.findByClienteId(clienteId) %>" />
					   
					    <liferay-ui:search-container-row className="com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo" keyProperty="clienteVehiculoId" modelVar="clienteVehiculo">
					    
					    	<%
					    		Concesionario concesionario = ConcesionarioLocalServiceUtil.getConcesionario(clienteVehiculo.getConcesionarioId());
						    %>
						    
						    <c:set var="concesionarioX" value="<%=concesionario%>" />
							<c:set var="ciudad" value="<%=CiudadesLocalServiceUtil.getCiudades(concesionario.getCiudadId()) %>" />
							<c:set var="vehiculo" value="<%=VehiculoLocalServiceUtil.getVehiculo(clienteVehiculo.getVehiculoId())%>" />
						    
						    
							<liferay-ui:search-container-column-text name="Ciudad" value="${ciudad.ciudad}" />
					        <liferay-ui:search-container-column-text name="Concesionario" value="${concesionarioX.concesionario}" />
					        <liferay-ui:search-container-column-text name="Vehiculo" value="${vehiculo.vehiculo}" />
					        
					        <c:if test="<%=!themeDisplay.isSignedIn()%>">
						        <portlet:actionURL name="eliminarVehiculo" var="eliminarVehiculoURL">
									<portlet:param name="tipoDocumento" value="${tipoDocumento}"/>
									<portlet:param name="numeroDocumento" value="${numeroDocumento}"/>
									<portlet:param name="clienteVehiculoId" value="${clienteVehiculo.clienteVehiculoId}"/>
								</portlet:actionURL>
						        <liferay-ui:search-container-column-text name="Cancelar" >
						        	<aui:button href="${eliminarVehiculoURL}" icon="glyphicon glyphicon-remove" type="button" />
						        </liferay-ui:search-container-column-text>
						    </c:if>
					        
					        <%-- <liferay-ui:search-container-column-jsp path="/WEB-INF/jsp/studentActions.jsp" align="right" /> --%>
					    </liferay-ui:search-container-row>
					    <liferay-ui:search-iterator markupView="lexicon" />
					</liferay-ui:search-container>
				</aui:form>
						
					
				<aui:fieldset column="<%=true%>">
					<aui:col>
						<center>
							<portlet:actionURL name="eliminarVehiculo" var="salirVehiculoURL" />
							<c:if test="<%=themeDisplay.isSignedIn()%>">
								<aui:button icon="glyphicon glyphicon-backward " value="Volver" type="button" href ="${salirVehiculoURL}" />
							</c:if>
							<c:if test="<%=!themeDisplay.isSignedIn()%>">
								<aui:button icon="glyphicon glyphicon-save" value="Guardar" type ="button" onClick="guardarCliente(0)" primary="true" />
								<aui:button icon="glyphicon glyphicon-log-out" value="Salir" type="button" href ="${salirVehiculoURL}" />
							</c:if>
						</center>
					</aui:col>
				</aui:fieldset>
					
			<%} %>
		</aui:col>
	</aui:fieldset>
</div>


<script type="text/javascript">

function guardarCliente(opcion){
	document.getElementById('<portlet:namespace />opcion').value = opcion;
	submitForm(document.<portlet:namespace />guardarClienteForm);
}

function cargarConsecionarios(ciudadId){
	
    AUI().use('aui-io-request', function(A){
    	A.io.request('${urlAjax}', {
            method: 'POST',
            dataType: 'json',
            data: {
            	<portlet:namespace />opcion: 'cargarConsecionarios',
            	<portlet:namespace />ciudadId: ciudadId
            },
            sync: true,
            on: {
                success: function() {
                	var response = this.get('responseData');
                	
                	console.log("ciudadId: "+ciudadId+" concesionarios "+JSON.stringify(response));
                	
                	var concesionarios = response.concesionarios;
                	
            	    document.getElementById('<portlet:namespace/>concesionario').innerHTML = "";

            		$('#<portlet:namespace/>concesionario').append($('<option>', {
            			value : '',
            			text : 'Concesionario'
            		}));
                	
                	for(var i = 0; i < concesionarios.length; i++) {
                	    var concesionairo = concesionarios[i];
                	    
                	    $('#<portlet:namespace/>concesionario').append($('<option>', {
                			value : concesionairo.concesionarioId,
                			text : concesionairo.concesionario
                		}));

                	}
                    
                },
                failure: function() {
                }
            }
        });
    });
}

function cargarVehiculos(concesionarioId){
	
    AUI().use('aui-io-request', function(A){
    	A.io.request('${urlAjax}', {
            method: 'POST',
            dataType: 'json',
            data: {
            	<portlet:namespace />opcion: 'cargarVehiculos',
            	<portlet:namespace />concesionarioId: concesionarioId
            },
            sync: true,
            on: {
                success: function() {
                	var response = this.get('responseData');
                	
                	var vehiculos = response.vehiculos;
                	
            	    document.getElementById('<portlet:namespace/>vehiculo').innerHTML = "";

            		$('#<portlet:namespace/>vehiculo').append($('<option>', {
            			value : '',
            			text : 'Vehiculo'
            		}));
                	
                	for(var i = 0; i < vehiculos.length; i++) {
                	    var vehiculo = vehiculos[i];
                	    
                	    $('#<portlet:namespace/>vehiculo').append($('<option>', {
                			value : vehiculo.vehiculoId,
                			text : vehiculo.vehiculo
                		}));
                	}
                    
                },
                failure: function() {
                }
            }
        });
    });
}
</script>



