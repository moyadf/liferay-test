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

import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing ClienteVehiculo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ClienteVehiculoCacheModel
	implements CacheModel<ClienteVehiculo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClienteVehiculoCacheModel)) {
			return false;
		}

		ClienteVehiculoCacheModel clienteVehiculoCacheModel =
			(ClienteVehiculoCacheModel)obj;

		if (clienteVehiculoId == clienteVehiculoCacheModel.clienteVehiculoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clienteVehiculoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{clienteVehiculoId=");
		sb.append(clienteVehiculoId);
		sb.append(", clienteId=");
		sb.append(clienteId);
		sb.append(", concesionarioId=");
		sb.append(concesionarioId);
		sb.append(", vehiculoId=");
		sb.append(vehiculoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClienteVehiculo toEntityModel() {
		ClienteVehiculoImpl clienteVehiculoImpl = new ClienteVehiculoImpl();

		clienteVehiculoImpl.setClienteVehiculoId(clienteVehiculoId);
		clienteVehiculoImpl.setClienteId(clienteId);
		clienteVehiculoImpl.setConcesionarioId(concesionarioId);
		clienteVehiculoImpl.setVehiculoId(vehiculoId);

		clienteVehiculoImpl.resetOriginalValues();

		return clienteVehiculoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clienteVehiculoId = objectInput.readLong();

		clienteId = objectInput.readLong();

		concesionarioId = objectInput.readLong();

		vehiculoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(clienteVehiculoId);

		objectOutput.writeLong(clienteId);

		objectOutput.writeLong(concesionarioId);

		objectOutput.writeLong(vehiculoId);
	}

	public long clienteVehiculoId;
	public long clienteId;
	public long concesionarioId;
	public long vehiculoId;

}