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

import com.dbsystem.cotizatuvehiculo.model.Vehiculo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Vehiculo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VehiculoCacheModel
	implements CacheModel<Vehiculo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VehiculoCacheModel)) {
			return false;
		}

		VehiculoCacheModel vehiculoCacheModel = (VehiculoCacheModel)obj;

		if (vehiculoId == vehiculoCacheModel.vehiculoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, vehiculoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{vehiculoId=");
		sb.append(vehiculoId);
		sb.append(", vehiculo=");
		sb.append(vehiculo);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vehiculo toEntityModel() {
		VehiculoImpl vehiculoImpl = new VehiculoImpl();

		vehiculoImpl.setVehiculoId(vehiculoId);

		if (vehiculo == null) {
			vehiculoImpl.setVehiculo("");
		}
		else {
			vehiculoImpl.setVehiculo(vehiculo);
		}

		vehiculoImpl.setEstado(estado);

		vehiculoImpl.resetOriginalValues();

		return vehiculoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vehiculoId = objectInput.readLong();
		vehiculo = objectInput.readUTF();

		estado = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(vehiculoId);

		if (vehiculo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehiculo);
		}

		objectOutput.writeBoolean(estado);
	}

	public long vehiculoId;
	public String vehiculo;
	public boolean estado;

}