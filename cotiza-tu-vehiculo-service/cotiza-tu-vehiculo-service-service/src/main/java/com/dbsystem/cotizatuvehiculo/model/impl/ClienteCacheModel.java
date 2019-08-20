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

package com.dbsystem.cotizatuvehiculo.model.impl;

import com.dbsystem.cotizatuvehiculo.model.Cliente;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Cliente in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ClienteCacheModel implements CacheModel<Cliente>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClienteCacheModel)) {
			return false;
		}

		ClienteCacheModel clienteCacheModel = (ClienteCacheModel)obj;

		if (clienteId == clienteCacheModel.clienteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clienteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{clienteId=");
		sb.append(clienteId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", nombres=");
		sb.append(nombres);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", celular=");
		sb.append(celular);
		sb.append(", email=");
		sb.append(email);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cliente toEntityModel() {
		ClienteImpl clienteImpl = new ClienteImpl();

		clienteImpl.setClienteId(clienteId);
		clienteImpl.setGroupId(groupId);
		clienteImpl.setTipoDocumento(tipoDocumento);

		if (numeroDocumento == null) {
			clienteImpl.setNumeroDocumento("");
		}
		else {
			clienteImpl.setNumeroDocumento(numeroDocumento);
		}

		if (nombres == null) {
			clienteImpl.setNombres("");
		}
		else {
			clienteImpl.setNombres(nombres);
		}

		if (apellidos == null) {
			clienteImpl.setApellidos("");
		}
		else {
			clienteImpl.setApellidos(apellidos);
		}

		if (celular == null) {
			clienteImpl.setCelular("");
		}
		else {
			clienteImpl.setCelular(celular);
		}

		if (email == null) {
			clienteImpl.setEmail("");
		}
		else {
			clienteImpl.setEmail(email);
		}

		clienteImpl.setEstado(estado);

		clienteImpl.resetOriginalValues();

		return clienteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clienteId = objectInput.readLong();

		groupId = objectInput.readLong();

		tipoDocumento = objectInput.readLong();
		numeroDocumento = objectInput.readUTF();
		nombres = objectInput.readUTF();
		apellidos = objectInput.readUTF();
		celular = objectInput.readUTF();
		email = objectInput.readUTF();

		estado = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(clienteId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(tipoDocumento);

		if (numeroDocumento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numeroDocumento);
		}

		if (nombres == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombres);
		}

		if (apellidos == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apellidos);
		}

		if (celular == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(celular);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeBoolean(estado);
	}

	public long clienteId;
	public long groupId;
	public long tipoDocumento;
	public String numeroDocumento;
	public String nombres;
	public String apellidos;
	public String celular;
	public String email;
	public boolean estado;

}