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
public class CiudadesSoap implements Serializable {

	public static CiudadesSoap toSoapModel(Ciudades model) {
		CiudadesSoap soapModel = new CiudadesSoap();

		soapModel.setCiudadId(model.getCiudadId());
		soapModel.setCiudad(model.getCiudad());
		soapModel.setEstado(model.isEstado());

		return soapModel;
	}

	public static CiudadesSoap[] toSoapModels(Ciudades[] models) {
		CiudadesSoap[] soapModels = new CiudadesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CiudadesSoap[][] toSoapModels(Ciudades[][] models) {
		CiudadesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CiudadesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CiudadesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CiudadesSoap[] toSoapModels(List<Ciudades> models) {
		List<CiudadesSoap> soapModels = new ArrayList<CiudadesSoap>(
			models.size());

		for (Ciudades model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CiudadesSoap[soapModels.size()]);
	}

	public CiudadesSoap() {
	}

	public long getPrimaryKey() {
		return _ciudadId;
	}

	public void setPrimaryKey(long pk) {
		setCiudadId(pk);
	}

	public long getCiudadId() {
		return _ciudadId;
	}

	public void setCiudadId(long ciudadId) {
		_ciudadId = ciudadId;
	}

	public String getCiudad() {
		return _ciudad;
	}

	public void setCiudad(String ciudad) {
		_ciudad = ciudad;
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

	private long _ciudadId;
	private String _ciudad;
	private boolean _estado;

}