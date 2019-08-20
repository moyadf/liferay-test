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
 * This class is a wrapper for {@link Vehiculo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vehiculo
 * @generated
 */
@ProviderType
public class VehiculoWrapper
	extends BaseModelWrapper<Vehiculo>
	implements Vehiculo, ModelWrapper<Vehiculo> {

	public VehiculoWrapper(Vehiculo vehiculo) {
		super(vehiculo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vehiculoId", getVehiculoId());
		attributes.put("vehiculo", getVehiculo());
		attributes.put("estado", isEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vehiculoId = (Long)attributes.get("vehiculoId");

		if (vehiculoId != null) {
			setVehiculoId(vehiculoId);
		}

		String vehiculo = (String)attributes.get("vehiculo");

		if (vehiculo != null) {
			setVehiculo(vehiculo);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	 * Returns the estado of this vehiculo.
	 *
	 * @return the estado of this vehiculo
	 */
	@Override
	public boolean getEstado() {
		return model.getEstado();
	}

	/**
	 * Returns the primary key of this vehiculo.
	 *
	 * @return the primary key of this vehiculo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the vehiculo of this vehiculo.
	 *
	 * @return the vehiculo of this vehiculo
	 */
	@Override
	public String getVehiculo() {
		return model.getVehiculo();
	}

	/**
	 * Returns the vehiculo ID of this vehiculo.
	 *
	 * @return the vehiculo ID of this vehiculo
	 */
	@Override
	public long getVehiculoId() {
		return model.getVehiculoId();
	}

	/**
	 * Returns <code>true</code> if this vehiculo is estado.
	 *
	 * @return <code>true</code> if this vehiculo is estado; <code>false</code> otherwise
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
	 * Sets whether this vehiculo is estado.
	 *
	 * @param estado the estado of this vehiculo
	 */
	@Override
	public void setEstado(boolean estado) {
		model.setEstado(estado);
	}

	/**
	 * Sets the primary key of this vehiculo.
	 *
	 * @param primaryKey the primary key of this vehiculo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the vehiculo of this vehiculo.
	 *
	 * @param vehiculo the vehiculo of this vehiculo
	 */
	@Override
	public void setVehiculo(String vehiculo) {
		model.setVehiculo(vehiculo);
	}

	/**
	 * Sets the vehiculo ID of this vehiculo.
	 *
	 * @param vehiculoId the vehiculo ID of this vehiculo
	 */
	@Override
	public void setVehiculoId(long vehiculoId) {
		model.setVehiculoId(vehiculoId);
	}

	@Override
	protected VehiculoWrapper wrap(Vehiculo vehiculo) {
		return new VehiculoWrapper(vehiculo);
	}

}