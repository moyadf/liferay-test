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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Concesionario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Concesionario
 * @generated
 */
@ProviderType
public class ConcesionarioWrapper
	extends BaseModelWrapper<Concesionario>
	implements Concesionario, ModelWrapper<Concesionario> {

	public ConcesionarioWrapper(Concesionario concesionario) {
		super(concesionario);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("concesionarioId", getConcesionarioId());
		attributes.put("ciudadId", getCiudadId());
		attributes.put("concesionario", getConcesionario());
		attributes.put("estado", isEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long concesionarioId = (Long)attributes.get("concesionarioId");

		if (concesionarioId != null) {
			setConcesionarioId(concesionarioId);
		}

		Long ciudadId = (Long)attributes.get("ciudadId");

		if (ciudadId != null) {
			setCiudadId(ciudadId);
		}

		String concesionario = (String)attributes.get("concesionario");

		if (concesionario != null) {
			setConcesionario(concesionario);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	 * Returns the ciudad ID of this concesionario.
	 *
	 * @return the ciudad ID of this concesionario
	 */
	@Override
	public long getCiudadId() {
		return model.getCiudadId();
	}

	/**
	 * Returns the concesionario of this concesionario.
	 *
	 * @return the concesionario of this concesionario
	 */
	@Override
	public String getConcesionario() {
		return model.getConcesionario();
	}

	/**
	 * Returns the concesionario ID of this concesionario.
	 *
	 * @return the concesionario ID of this concesionario
	 */
	@Override
	public long getConcesionarioId() {
		return model.getConcesionarioId();
	}

	/**
	 * Returns the estado of this concesionario.
	 *
	 * @return the estado of this concesionario
	 */
	@Override
	public boolean getEstado() {
		return model.getEstado();
	}

	/**
	 * Returns the primary key of this concesionario.
	 *
	 * @return the primary key of this concesionario
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this concesionario is estado.
	 *
	 * @return <code>true</code> if this concesionario is estado; <code>false</code> otherwise
	 */
	@Override
	public boolean isEstado() {
		return model.isEstado();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ciudad ID of this concesionario.
	 *
	 * @param ciudadId the ciudad ID of this concesionario
	 */
	@Override
	public void setCiudadId(long ciudadId) {
		model.setCiudadId(ciudadId);
	}

	/**
	 * Sets the concesionario of this concesionario.
	 *
	 * @param concesionario the concesionario of this concesionario
	 */
	@Override
	public void setConcesionario(String concesionario) {
		model.setConcesionario(concesionario);
	}

	/**
	 * Sets the concesionario ID of this concesionario.
	 *
	 * @param concesionarioId the concesionario ID of this concesionario
	 */
	@Override
	public void setConcesionarioId(long concesionarioId) {
		model.setConcesionarioId(concesionarioId);
	}

	/**
	 * Sets whether this concesionario is estado.
	 *
	 * @param estado the estado of this concesionario
	 */
	@Override
	public void setEstado(boolean estado) {
		model.setEstado(estado);
	}

	/**
	 * Sets the primary key of this concesionario.
	 *
	 * @param primaryKey the primary key of this concesionario
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ConcesionarioWrapper wrap(Concesionario concesionario) {
		return new ConcesionarioWrapper(concesionario);
	}

}