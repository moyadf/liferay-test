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
public class ConcesionarioSoap implements Serializable {

	public static ConcesionarioSoap toSoapModel(Concesionario model) {
		ConcesionarioSoap soapModel = new ConcesionarioSoap();

		soapModel.setConcesionarioId(model.getConcesionarioId());
		soapModel.setCiudadId(model.getCiudadId());
		soapModel.setConcesionario(model.getConcesionario());
		soapModel.setEstado(model.isEstado());

		return soapModel;
	}

	public static ConcesionarioSoap[] toSoapModels(Concesionario[] models) {
		ConcesionarioSoap[] soapModels = new ConcesionarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConcesionarioSoap[][] toSoapModels(Concesionario[][] models) {
		ConcesionarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConcesionarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConcesionarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConcesionarioSoap[] toSoapModels(List<Concesionario> models) {
		List<ConcesionarioSoap> soapModels = new ArrayList<ConcesionarioSoap>(
			models.size());

		for (Concesionario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConcesionarioSoap[soapModels.size()]);
	}

	public ConcesionarioSoap() {
	}

	public long getPrimaryKey() {
		return _concesionarioId;
	}

	public void setPrimaryKey(long pk) {
		setConcesionarioId(pk);
	}

	public long getConcesionarioId() {
		return _concesionarioId;
	}

	public void setConcesionarioId(long concesionarioId) {
		_concesionarioId = concesionarioId;
	}

	public long getCiudadId() {
		return _ciudadId;
	}

	public void setCiudadId(long ciudadId) {
		_ciudadId = ciudadId;
	}

	public String getConcesionario() {
		return _concesionario;
	}

	public void setConcesionario(String concesionario) {
		_concesionario = concesionario;
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

	private long _concesionarioId;
	private long _ciudadId;
	private String _concesionario;
	private boolean _estado;

}