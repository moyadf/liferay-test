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
public class ClienteVehiculoSoap implements Serializable {

	public static ClienteVehiculoSoap toSoapModel(ClienteVehiculo model) {
		ClienteVehiculoSoap soapModel = new ClienteVehiculoSoap();

		soapModel.setClienteVehiculoId(model.getClienteVehiculoId());
		soapModel.setClienteId(model.getClienteId());
		soapModel.setConcesionarioId(model.getConcesionarioId());
		soapModel.setVehiculoId(model.getVehiculoId());

		return soapModel;
	}

	public static ClienteVehiculoSoap[] toSoapModels(ClienteVehiculo[] models) {
		ClienteVehiculoSoap[] soapModels =
			new ClienteVehiculoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClienteVehiculoSoap[][] toSoapModels(
		ClienteVehiculo[][] models) {

		ClienteVehiculoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ClienteVehiculoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClienteVehiculoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClienteVehiculoSoap[] toSoapModels(
		List<ClienteVehiculo> models) {

		List<ClienteVehiculoSoap> soapModels =
			new ArrayList<ClienteVehiculoSoap>(models.size());

		for (ClienteVehiculo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClienteVehiculoSoap[soapModels.size()]);
	}

	public ClienteVehiculoSoap() {
	}

	public long getPrimaryKey() {
		return _clienteVehiculoId;
	}

	public void setPrimaryKey(long pk) {
		setClienteVehiculoId(pk);
	}

	public long getClienteVehiculoId() {
		return _clienteVehiculoId;
	}

	public void setClienteVehiculoId(long clienteVehiculoId) {
		_clienteVehiculoId = clienteVehiculoId;
	}

	public long getClienteId() {
		return _clienteId;
	}

	public void setClienteId(long clienteId) {
		_clienteId = clienteId;
	}

	public long getConcesionarioId() {
		return _concesionarioId;
	}

	public void setConcesionarioId(long concesionarioId) {
		_concesionarioId = concesionarioId;
	}

	public long getVehiculoId() {
		return _vehiculoId;
	}

	public void setVehiculoId(long vehiculoId) {
		_vehiculoId = vehiculoId;
	}

	private long _clienteVehiculoId;
	private long _clienteId;
	private long _concesionarioId;
	private long _vehiculoId;

}