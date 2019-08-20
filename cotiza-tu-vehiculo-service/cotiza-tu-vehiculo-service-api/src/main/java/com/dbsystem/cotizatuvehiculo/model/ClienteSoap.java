/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dbsystem.cotizatuvehiculo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ClienteSoap implements Serializable {

	public static ClienteSoap toSoapModel(Cliente model) {
		ClienteSoap soapModel = new ClienteSoap();

		soapModel.setClienteId(model.getClienteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setNombres(model.getNombres());
		soapModel.setApellidos(model.getApellidos());
		soapModel.setCelular(model.getCelular());
		soapModel.setEmail(model.getEmail());
		soapModel.setEstado(model.isEstado());

		return soapModel;
	}

	public static ClienteSoap[] toSoapModels(Cliente[] models) {
		ClienteSoap[] soapModels = new ClienteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClienteSoap[][] toSoapModels(Cliente[][] models) {
		ClienteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClienteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClienteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClienteSoap[] toSoapModels(List<Cliente> models) {
		List<ClienteSoap> soapModels = new ArrayList<ClienteSoap>(
			models.size());

		for (Cliente model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClienteSoap[soapModels.size()]);
	}

	public ClienteSoap() {
	}

	public long getPrimaryKey() {
		return _clienteId;
	}

	public void setPrimaryKey(long pk) {
		setClienteId(pk);
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(long tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getCelular() {
		return _celular;
	}

	public void setCelular(String celular) {
		_celular = celular;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public boolean getEstado() {
		return _estado;
	}

	public boolean isEstado() {
		return _estado;
	}

	public void setEstado(boolean estado) {
		_estado = estado;
	}

	private long _clienteId;
	private long _groupId;
	private long _tipoDocumento;
	private String _numeroDocumento;
	private String _nombres;
	private String _apellidos;
	private String _celular;
	private String _email;
	private boolean _estado;

}