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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Cliente service. Represents a row in the &quot;dbsystem_Cliente&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Cliente
 * @generated
 */
@ProviderType
public interface ClienteModel extends BaseModel<Cliente> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cliente model instance should use the {@link Cliente} interface instead.
	 */

	/**
	 * Returns the primary key of this cliente.
	 *
	 * @return the primary key of this cliente
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cliente.
	 *
	 * @param primaryKey the primary key of this cliente
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cliente ID of this cliente.
	 *
	 * @return the cliente ID of this cliente
	 */
	public long getClienteId();

	/**
	 * Sets the cliente ID of this cliente.
	 *
	 * @param clienteId the cliente ID of this cliente
	 */
	public void setClienteId(long clienteId);

	/**
	 * Returns the group ID of this cliente.
	 *
	 * @return the group ID of this cliente
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this cliente.
	 *
	 * @param groupId the group ID of this cliente
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the tipo documento of this cliente.
	 *
	 * @return the tipo documento of this cliente
	 */
	public long getTipoDocumento();

	/**
	 * Sets the tipo documento of this cliente.
	 *
	 * @param tipoDocumento the tipo documento of this cliente
	 */
	public void setTipoDocumento(long tipoDocumento);

	/**
	 * Returns the numero documento of this cliente.
	 *
	 * @return the numero documento of this cliente
	 */
	@AutoEscape
	public String getNumeroDocumento();

	/**
	 * Sets the numero documento of this cliente.
	 *
	 * @param numeroDocumento the numero documento of this cliente
	 */
	public void setNumeroDocumento(String numeroDocumento);

	/**
	 * Returns the nombres of this cliente.
	 *
	 * @return the nombres of this cliente
	 */
	@AutoEscape
	public String getNombres();

	/**
	 * Sets the nombres of this cliente.
	 *
	 * @param nombres the nombres of this cliente
	 */
	public void setNombres(String nombres);

	/**
	 * Returns the apellidos of this cliente.
	 *
	 * @return the apellidos of this cliente
	 */
	@AutoEscape
	public String getApellidos();

	/**
	 * Sets the apellidos of this cliente.
	 *
	 * @param apellidos the apellidos of this cliente
	 */
	public void setApellidos(String apellidos);

	/**
	 * Returns the celular of this cliente.
	 *
	 * @return the celular of this cliente
	 */
	@AutoEscape
	public String getCelular();

	/**
	 * Sets the celular of this cliente.
	 *
	 * @param celular the celular of this cliente
	 */
	public void setCelular(String celular);

	/**
	 * Returns the email of this cliente.
	 *
	 * @return the email of this cliente
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this cliente.
	 *
	 * @param email the email of this cliente
	 */
	public void setEmail(String email);

	/**
	 * Returns the estado of this cliente.
	 *
	 * @return the estado of this cliente
	 */
	public boolean getEstado();

	/**
	 * Returns <code>true</code> if this cliente is estado.
	 *
	 * @return <code>true</code> if this cliente is estado; <code>false</code> otherwise
	 */
	public boolean isEstado();

	/**
	 * Sets whether this cliente is estado.
	 *
	 * @param estado the estado of this cliente
	 */
	public void setEstado(boolean estado);

}