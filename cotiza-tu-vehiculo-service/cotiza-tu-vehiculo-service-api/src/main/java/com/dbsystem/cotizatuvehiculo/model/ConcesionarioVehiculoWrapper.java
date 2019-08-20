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
 * This class is a wrapper for {@link ConcesionarioVehiculo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculo
 * @generated
 */
@ProviderType
public class ConcesionarioVehiculoWrapper
	extends BaseModelWrapper<ConcesionarioVehiculo>
	implements ConcesionarioVehiculo, ModelWrapper<ConcesionarioVehiculo> {

	public ConcesionarioVehiculoWrapper(
		ConcesionarioVehiculo concesionarioVehiculo) {

		super(concesionarioVehiculo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("concesionarioVehiculoId", getConcesionarioVehiculoId());
		attributes.put("concesionarioId", getConcesionarioId());
		attributes.put("vehiculoId", getVehiculoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long concesionarioVehiculoId = (Long)attributes.get(
			"concesionarioVehiculoId");

		if (concesionarioVehiculoId != null) {
			setConcesionarioVehiculoId(concesionarioVehiculoId);
		}

		Long concesionarioId = (Long)attributes.get("concesionarioId");

		if (concesionarioId != null) {
			setConcesionarioId(concesionarioId);
		}

		Long vehiculoId = (Long)attributes.get("vehiculoId");

		if (vehiculoId != null) {
			setVehiculoId(vehiculoId);
		}
	}

	/**
	 * Returns the concesionario ID of this concesionario vehiculo.
	 *
	 * @return the concesionario ID of this concesionario vehiculo
	 */
	@Override
	public long getConcesionarioId() {
		return model.getConcesionarioId();
	}

	/**
	 * Returns the concesionario vehiculo ID of this concesionario vehiculo.
	 *
	 * @return the concesionario vehiculo ID of this concesionario vehiculo
	 */
	@Override
	public long getConcesionarioVehiculoId() {
		return model.getConcesionarioVehiculoId();
	}

	/**
	 * Returns the primary key of this concesionario vehiculo.
	 *
	 * @return the primary key of this concesionario vehiculo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the vehiculo ID of this concesionario vehiculo.
	 *
	 * @return the vehiculo ID of this concesionario vehiculo
	 */
	@Override
	public long getVehiculoId() {
		return model.getVehiculoId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the concesionario ID of this concesionario vehiculo.
	 *
	 * @param concesionarioId the concesionario ID of this concesionario vehiculo
	 */
	@Override
	public void setConcesionarioId(long concesionarioId) {
		model.setConcesionarioId(concesionarioId);
	}

	/**
	 * Sets the concesionario vehiculo ID of this concesionario vehiculo.
	 *
	 * @param concesionarioVehiculoId the concesionario vehiculo ID of this concesionario vehiculo
	 */
	@Override
	public void setConcesionarioVehiculoId(long concesionarioVehiculoId) {
		model.setConcesionarioVehiculoId(concesionarioVehiculoId);
	}

	/**
	 * Sets the primary key of this concesionario vehiculo.
	 *
	 * @param primaryKey the primary key of this concesionario vehiculo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the vehiculo ID of this concesionario vehiculo.
	 *
	 * @param vehiculoId the vehiculo ID of this concesionario vehiculo
	 */
	@Override
	public void setVehiculoId(long vehiculoId) {
		model.setVehiculoId(vehiculoId);
	}

	@Override
	protected ConcesionarioVehiculoWrapper wrap(
		ConcesionarioVehiculo concesionarioVehiculo) {

		return new ConcesionarioVehiculoWrapper(concesionarioVehiculo);
	}

}