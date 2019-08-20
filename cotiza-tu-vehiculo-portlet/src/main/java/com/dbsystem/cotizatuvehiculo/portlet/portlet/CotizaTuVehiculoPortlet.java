package com.dbsystem.cotizatuvehiculo.portlet.portlet;

import com.dbsystem.cotizatuvehiculo.model.Cliente;
import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;
import com.dbsystem.cotizatuvehiculo.model.Concesionario;
import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;
import com.dbsystem.cotizatuvehiculo.model.Vehiculo;
import com.dbsystem.cotizatuvehiculo.portlet.constants.CotizaTuVehiculoPortletKeys;
import com.dbsystem.cotizatuvehiculo.service.ClienteLocalServiceUtil;
import com.dbsystem.cotizatuvehiculo.service.ClienteVehiculoLocalServiceUtil;
import com.dbsystem.cotizatuvehiculo.service.ConcesionarioLocalServiceUtil;
import com.dbsystem.cotizatuvehiculo.service.ConcesionarioVehiculoLocalServiceUtil;
import com.dbsystem.cotizatuvehiculo.service.VehiculoLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author onev88
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dbsystem",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.name=" + CotizaTuVehiculoPortletKeys.CotizaTuVehiculo,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CotizaTuVehiculoPortlet extends MVCPortlet {
	
	@SuppressWarnings("unused")
	private static ResourceBundle rb = ResourceBundle.getBundle("content.Language");
	
	@Override
		public void serveResource(ResourceRequest request, ResourceResponse response)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
			
			PrintWriter writer = response.getWriter();
			
			JSONObject resultJSONObject = JSONFactoryUtil.createJSONObject();

			String opcion = ParamUtil.getString(request, "opcion");
			
			if (opcion.equalsIgnoreCase("cargarConsecionarios")) {
				
				long ciudadId = ParamUtil.getLong(request, "ciudadId");
				List<Concesionario> concesionarioList = ConcesionarioLocalServiceUtil.findByCiudadIdEstado(ciudadId, true);
				
				JSONArray concesionariosJSONArray = JSONFactoryUtil.createJSONArray();
				
				for(Concesionario concesionario : concesionarioList) {
					JSONObject concesionarioJSONObject = JSONFactoryUtil.createJSONObject();
					
					concesionarioJSONObject.put("concesionarioId", concesionario.getConcesionarioId());
					concesionarioJSONObject.put("concesionario", concesionario.getConcesionario());
					
					concesionariosJSONArray.put(concesionarioJSONObject);
				}
				
				resultJSONObject.put("concesionarios", concesionariosJSONArray);
				
			}
			
			if (opcion.equalsIgnoreCase("cargarVehiculos")) {
				
				long concesionarioId = ParamUtil.getLong(request, "concesionarioId");
				List<ConcesionarioVehiculo> concesionarioVehiculoList = ConcesionarioVehiculoLocalServiceUtil.findByConcesionarioId(concesionarioId);
				
				JSONArray concesionariosJSONArray = JSONFactoryUtil.createJSONArray();
				
				for(ConcesionarioVehiculo concesionarioVehiculo : concesionarioVehiculoList) {
					JSONObject concesionarioJSONObject = JSONFactoryUtil.createJSONObject();
					
					Vehiculo vehiculo;
					try {
						vehiculo = VehiculoLocalServiceUtil.getVehiculo(concesionarioVehiculo.getVehiculoId());
						
						concesionarioJSONObject.put("vehiculoId", vehiculo.getVehiculoId());
						concesionarioJSONObject.put("vehiculo", vehiculo.getVehiculo());
						
						concesionariosJSONArray.put(concesionarioJSONObject);
						
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
				
				resultJSONObject.put("vehiculos", concesionariosJSONArray);
				
			}
			
			response.reset();
			writer.print(resultJSONObject);
			writer.flush();
			writer.close();
		}
	
	
	public static void buscarCliente(ActionRequest request, ActionResponse response) {
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		long tipoDocumento = ParamUtil.getLong(request, "tipoDocumento");
		String numeroDocumento = ParamUtil.getString(request, "numeroDocumento");
		
		if(tipoDocumento!=0 && !numeroDocumento.equals("")) {
			request.setAttribute("tipoDocumento", tipoDocumento);
			request.setAttribute("numeroDocumento", numeroDocumento);
		}
	}
	
	public static void guardarCliente(ActionRequest request, ActionResponse response) {
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		long tipoDocumento = ParamUtil.getLong(request, "tipoDocumento");
		String numeroDocumento = ParamUtil.getString(request, "numeroDocumento");
		
		int opcion = ParamUtil.getInteger(request, "opcion");
		
		String nombres = ParamUtil.getString(request, "nombres");
		String apellidos = ParamUtil.getString(request, "apellidos");
		
		String celular = ParamUtil.getString(request, "celular");
		
		String email = ParamUtil.getString(request, "email");
		
		Cliente cliente = ClienteLocalServiceUtil.findByIdentificacion(tipoDocumento, numeroDocumento);
		
		boolean existe = true;
		
		if(Validator.isNull(cliente)) {
			cliente = ClienteLocalServiceUtil.createCliente(CounterLocalServiceUtil.increment(Cliente.class.getName()));
			existe = false;
		}
		
		if (opcion == 0 || !existe) {
			
			cliente.setNombres(nombres);
			cliente.setApellidos(apellidos);
			cliente.setCelular(celular);
			cliente.setEmail(email);
			cliente.setEstado(true);

			if (existe) {
				ClienteLocalServiceUtil.updateCliente(cliente);
			} else {
				cliente.setTipoDocumento(tipoDocumento);
				cliente.setNumeroDocumento(numeroDocumento);
				ClienteLocalServiceUtil.addCliente(cliente);
			}
		}
		
		
		long clienteId = cliente.getClienteId();
		long concesionarioId = ParamUtil.getLong(request, "concesionario");
		long vehiculoId = ParamUtil.getLong(request, "vehiculo");
		
			
		ClienteVehiculo clienteVehiculo = ClienteVehiculoLocalServiceUtil.findByClienteIdConcesionarioIdVehiculoId(clienteId, concesionarioId, vehiculoId);
		
		if(Validator.isNotNull(clienteVehiculo)) {
			SessionMessages.add(request, "agregado-anteriormente");
		}else {
			
			clienteVehiculo = ClienteVehiculoLocalServiceUtil.createClienteVehiculo(CounterLocalServiceUtil.increment(ClienteVehiculo.class.getName()));
			
			clienteVehiculo.setClienteId(clienteId);
			clienteVehiculo.setVehiculoId(vehiculoId);
			clienteVehiculo.setConcesionarioId(concesionarioId);
			ClienteVehiculoLocalServiceUtil.addClienteVehiculo(clienteVehiculo);
		}
		
		request.setAttribute("tipoDocumento", tipoDocumento);
		request.setAttribute("numeroDocumento", numeroDocumento);
	}
	
	public void eliminarVehiculo(ActionRequest request, ActionResponse response) {
		
		long tipoDocumento = ParamUtil.getLong(request, "tipoDocumento");
		String numeroDocumento = ParamUtil.getString(request, "numeroDocumento");

		long clienteVehiculoId = ParamUtil.getLong(request, "clienteVehiculoId");
		try {
			ClienteVehiculo clienteVehiculo = ClienteVehiculoLocalServiceUtil.getClienteVehiculo(clienteVehiculoId);
			if (Validator.isNotNull(clienteVehiculo)) {
				ClienteVehiculoLocalServiceUtil.deleteClienteVehiculo(clienteVehiculo);
			}

		} catch (PortalException e) {
		}
		
		request.setAttribute("tipoDocumento", tipoDocumento);
		request.setAttribute("numeroDocumento", numeroDocumento);
	}
}