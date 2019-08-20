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
 * This class is a wrapper for {@link Cliente}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Cliente
 * @generated
 */
@ProviderType
public class ClienteWrapper
	extends BaseModelWrapper<Cliente>
	implements Cliente, ModelWrapper<Cliente> {

	public ClienteWrapper(Cliente cliente) {
		super(cliente);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clienteId", getClienteId());
		attributes.put("groupId", getGroupId());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("celular", getCelular());
		attributes.put("email", getEmail());
		attributes.put("estado", isEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clienteId = (Long)attributes.get("clienteId");

		if (clienteId != null) {
			setClienteId(clienteId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long tipoDocumento = (Long)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numeroDocumento = (String)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String celular = (String)attributes.get("celular");

		if (celular != null) {
			setCelular(celular);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	 * Returns the apellidos of this cliente.
	 *
	 * @return the apellidos of this cliente
	 */
	@Override
	public String getApellidos() {
		return model.getApellidos();
	}

	/**
	 * Returns the celular of this cliente.
	 *
	 * @return the celular of this cliente
	 */
	@Override
	public String getCelular() {
		return model.getCelular();
	}

	/**
	 * Returns the cliente ID of this cliente.
	 *
	 * @return the cliente ID of this cliente
	 */
	@Override
	public long getClienteId() {
		return model.getClienteId();
	}

	/**
	 * Returns the email of this cliente.
	 *
	 * @return the email of this cliente
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the estado of this cliente.
	 *
	 * @return the estado of this cliente
	 */
	@Override
	public boolean getEstado() {
		return model.getEstado();
	}

	/**
	 * Returns the group ID of this cliente.
	 *
	 * @return the group ID of this cliente
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the nombres of this cliente.
	 *
	 * @return the nombres of this cliente
	 */
	@Override
	public String getNombres() {
		return model.getNombres();
	}

	/**
	 * Returns the numero documento of this cliente.
	 *
	 * @return the numero documento of this cliente
	 */
	@Override
	public String getNumeroDocumento() {
		return model.getNumeroDocumento();
	}

	/**
	 * Returns the primary key of this cliente.
	 *
	 * @return the primary key of this cliente
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo documento of this cliente.
	 *
	 * @return the tipo documento of this cliente
	 */
	@Override
	public long getTipoDocumento() {
		return model.getTipoDocumento();
	}

	/**
	 * Returns <code>true</code> if this cliente is estado.
	 *
	 * @return <code>true</code> if this cliente is estado; <code>false</code> otherwise
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
	 * Sets the apellidos of this cliente.
	 *
	 * @param apellidos the apellidos of this cliente
	 */
	@Override
	public void setApellidos(String apellidos) {
		model.setApellidos(apellidos);
	}

	/**
	 * Sets the celular of this cliente.
	 *
	 * @param celular the celular of this cliente
	 */
	@Override
	public void setCelular(String celular) {
		model.setCelular(celular);
	}

	/**
	 * Sets the cliente ID of this cliente.
	 *
	 * @param clienteId the cliente ID of this cliente
	 */
	@Override
	public void setClienteId(long clienteId) {
		model.setClienteId(clienteId);
	}

	/**
	 * Sets the email of this cliente.
	 *
	 * @param email the email of this cliente
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets whether this cliente is estado.
	 *
	 * @param estado the estado of this cliente
	 */
	@Override
	public void setEstado(boolean estado) {
		model.setEstado(estado);
	}

	/**
	 * Sets the group ID of this cliente.
	 *
	 * @param groupId the group ID of this cliente
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the nombres of this cliente.
	 *
	 * @param nombres the nombres of this cliente
	 */
	@Override
	public void setNombres(String nombres) {
		model.setNombres(nombres);
	}

	/**
	 * Sets the numero documento of this cliente.
	 *
	 * @param numeroDocumento the numero documento of this cliente
	 */
	@Override
	public void setNumeroDocumento(String numeroDocumento) {
		model.setNumeroDocumento(numeroDocumento);
	}

	/**
	 * Sets the primary key of this cliente.
	 *
	 * @param primaryKey the primary key of this cliente
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo documento of this cliente.
	 *
	 * @param tipoDocumento the tipo documento of this cliente
	 */
	@Override
	public void setTipoDocumento(long tipoDocumento) {
		model.setTipoDocumento(tipoDocumento);
	}

	@Override
	protected ClienteWrapper wrap(Cliente cliente) {
		return new ClienteWrapper(cliente);
	}

}