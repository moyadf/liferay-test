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
public class VehiculoSoap implements Serializable {

	public static VehiculoSoap toSoapModel(Vehiculo model) {
		VehiculoSoap soapModel = new VehiculoSoap();

		soapModel.setVehiculoId(model.getVehiculoId());
		soapModel.setVehiculo(model.getVehiculo());
		soapModel.setEstado(model.isEstado());

		return soapModel;
	}

	public static VehiculoSoap[] toSoapModels(Vehiculo[] models) {
		VehiculoSoap[] soapModels = new VehiculoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VehiculoSoap[][] toSoapModels(Vehiculo[][] models) {
		VehiculoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VehiculoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VehiculoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VehiculoSoap[] toSoapModels(List<Vehiculo> models) {
		List<VehiculoSoap> soapModels = new ArrayList<VehiculoSoap>(
			models.size());

		for (Vehiculo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VehiculoSoap[soapModels.size()]);
	}

	public VehiculoSoap() {
	}

	public long getPrimaryKey() {
		return _vehiculoId;
	}

	public void setPrimaryKey(long pk) {
		setVehiculoId(pk);
	}

	public long getVehiculoId() {
		return _vehiculoId;
	}

	public void setVehiculoId(long vehiculoId) {
		_vehiculoId = vehiculoId;
	}

	public String getVehiculo() {
		return _vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		_vehiculo = vehiculo;
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

	private long _vehiculoId;
	private String _vehiculo;
	private boolean _estado;

}