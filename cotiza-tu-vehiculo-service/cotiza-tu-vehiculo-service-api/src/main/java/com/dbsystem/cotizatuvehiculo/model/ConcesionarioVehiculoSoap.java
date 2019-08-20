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
public class ConcesionarioVehiculoSoap implements Serializable {

	public static ConcesionarioVehiculoSoap toSoapModel(
		ConcesionarioVehiculo model) {

		ConcesionarioVehiculoSoap soapModel = new ConcesionarioVehiculoSoap();

		soapModel.setConcesionarioVehiculoId(
			model.getConcesionarioVehiculoId());
		soapModel.setConcesionarioId(model.getConcesionarioId());
		soapModel.setVehiculoId(model.getVehiculoId());

		return soapModel;
	}

	public static ConcesionarioVehiculoSoap[] toSoapModels(
		ConcesionarioVehiculo[] models) {

		ConcesionarioVehiculoSoap[] soapModels =
			new ConcesionarioVehiculoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConcesionarioVehiculoSoap[][] toSoapModels(
		ConcesionarioVehiculo[][] models) {

		ConcesionarioVehiculoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ConcesionarioVehiculoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConcesionarioVehiculoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConcesionarioVehiculoSoap[] toSoapModels(
		List<ConcesionarioVehiculo> models) {

		List<ConcesionarioVehiculoSoap> soapModels =
			new ArrayList<ConcesionarioVehiculoSoap>(models.size());

		for (ConcesionarioVehiculo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ConcesionarioVehiculoSoap[soapModels.size()]);
	}

	public ConcesionarioVehiculoSoap() {
	}

	public long getPrimaryKey() {
		return _concesionarioVehiculoId;
	}

	public void setPrimaryKey(long pk) {
		setConcesionarioVehiculoId(pk);
	}

	public long getConcesionarioVehiculoId() {
		return _concesionarioVehiculoId;
	}

	public void setConcesionarioVehiculoId(long concesionarioVehiculoId) {
		_concesionarioVehiculoId = concesionarioVehiculoId;
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

	private long _concesionarioVehiculoId;
	private long _concesionarioId;
	private long _vehiculoId;

}