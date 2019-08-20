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
 * This class is a wrapper for {@link Ciudades}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ciudades
 * @generated
 */
@ProviderType
public class CiudadesWrapper
	extends BaseModelWrapper<Ciudades>
	implements Ciudades, ModelWrapper<Ciudades> {

	public CiudadesWrapper(Ciudades ciudades) {
		super(ciudades);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ciudadId", getCiudadId());
		attributes.put("ciudad", getCiudad());
		attributes.put("estado", isEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ciudadId = (Long)attributes.get("ciudadId");

		if (ciudadId != null) {
			setCiudadId(ciudadId);
		}

		String ciudad = (String)attributes.get("ciudad");

		if (ciudad != null) {
			setCiudad(ciudad);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	 * Returns the ciudad of this ciudades.
	 *
	 * @return the ciudad of this ciudades
	 */
	@Override
	public String getCiudad() {
		return model.getCiudad();
	}

	/**
	 * Returns the ciudad ID of this ciudades.
	 *
	 * @return the ciudad ID of this ciudades
	 */
	@Override
	public long getCiudadId() {
		return model.getCiudadId();
	}

	/**
	 * Returns the estado of this ciudades.
	 *
	 * @return the estado of this ciudades
	 */
	@Override
	public boolean getEstado() {
		return model.getEstado();
	}

	/**
	 * Returns the primary key of this ciudades.
	 *
	 * @return the primary key of this ciudades
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this ciudades is estado.
	 *
	 * @return <code>true</code> if this ciudades is estado; <code>false</code> otherwise
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
	 * Sets the ciudad of this ciudades.
	 *
	 * @param ciudad the ciudad of this ciudades
	 */
	@Override
	public void setCiudad(String ciudad) {
		model.setCiudad(ciudad);
	}

	/**
	 * Sets the ciudad ID of this ciudades.
	 *
	 * @param ciudadId the ciudad ID of this ciudades
	 */
	@Override
	public void setCiudadId(long ciudadId) {
		model.setCiudadId(ciudadId);
	}

	/**
	 * Sets whether this ciudades is estado.
	 *
	 * @param estado the estado of this ciudades
	 */
	@Override
	public void setEstado(boolean estado) {
		model.setEstado(estado);
	}

	/**
	 * Sets the primary key of this ciudades.
	 *
	 * @param primaryKey the primary key of this ciudades
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CiudadesWrapper wrap(Ciudades ciudades) {
		return new CiudadesWrapper(ciudades);
	}

}