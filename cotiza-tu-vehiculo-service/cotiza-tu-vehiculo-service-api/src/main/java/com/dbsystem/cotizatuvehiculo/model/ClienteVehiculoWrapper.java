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
 * This class is a wrapper for {@link ClienteVehiculo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteVehiculo
 * @generated
 */
@ProviderType
public class ClienteVehiculoWrapper
	extends BaseModelWrapper<ClienteVehiculo>
	implements ClienteVehiculo, ModelWrapper<ClienteVehiculo> {

	public ClienteVehiculoWrapper(ClienteVehiculo clienteVehiculo) {
		super(clienteVehiculo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteVehiculoId", getClienteVehiculoId());
		attributes.put("clienteId", getClienteId());
		attributes.put("concesionarioId", getConcesionarioId());
		attributes.put("vehiculoId", getVehiculoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteVehiculoId = (Long)attributes.get("clienteVehiculoId");

		if (clienteVehiculoId != null) {
			setClienteVehiculoId(clienteVehiculoId);
		}

		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
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
	 * Returns the cliente ID of this cliente vehiculo.
	 *
	 * @return the cliente ID of this cliente vehiculo
	 */
	@Override
	public long getClienteId() {
		return model.getClienteId();
	}

	/**
	 * Returns the cliente vehiculo ID of this cliente vehiculo.
	 *
	 * @return the cliente vehiculo ID of this cliente vehiculo
	 */
	@Override
	public long getClienteVehiculoId() {
		return model.getClienteVehiculoId();
	}

	/**
	 * Returns the concesionario ID of this cliente vehiculo.
	 *
	 * @return the concesionario ID of this cliente vehiculo
	 */
	@Override
	public long getConcesionarioId() {
		return model.getConcesionarioId();
	}

	/**
	 * Returns the primary key of this cliente vehiculo.
	 *
	 * @return the primary key of this cliente vehiculo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the vehiculo ID of this cliente vehiculo.
	 *
	 * @return the vehiculo ID of this cliente vehiculo
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
	 * Sets the cliente ID of this cliente vehiculo.
	 *
	 * @param clienteId the cliente ID of this cliente vehiculo
	 */
	@Override
	public void setClienteId(long clienteId) {
		model.setClienteId(clienteId);
	}

	/**
	 * Sets the cliente vehiculo ID of this cliente vehiculo.
	 *
	 * @param clienteVehiculoId the cliente vehiculo ID of this cliente vehiculo
	 */
	@Override
	public void setClienteVehiculoId(long clienteVehiculoId) {
		model.setClienteVehiculoId(clienteVehiculoId);
	}

	/**
	 * Sets the concesionario ID of this cliente vehiculo.
	 *
	 * @param concesionarioId the concesionario ID of this cliente vehiculo
	 */
	@Override
	public void setConcesionarioId(long concesionarioId) {
		model.setConcesionarioId(concesionarioId);
	}

	/**
	 * Sets the primary key of this cliente vehiculo.
	 *
	 * @param primaryKey the primary key of this cliente vehiculo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the vehiculo ID of this cliente vehiculo.
	 *
	 * @param vehiculoId the vehiculo ID of this cliente vehiculo
	 */
	@Override
	public void setVehiculoId(long vehiculoId) {
		model.setVehiculoId(vehiculoId);
	}

	@Override
	protected ClienteVehiculoWrapper wrap(ClienteVehiculo clienteVehiculo) {
		return new ClienteVehiculoWrapper(clienteVehiculo);
	}

}