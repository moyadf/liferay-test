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

import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing ConcesionarioVehiculo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ConcesionarioVehiculoCacheModel
	implements CacheModel<ConcesionarioVehiculo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConcesionarioVehiculoCacheModel)) {
			return false;
		}

		ConcesionarioVehiculoCacheModel concesionarioVehiculoCacheModel =
			(ConcesionarioVehiculoCacheModel)obj;

		if (concesionarioVehiculoId ==
				concesionarioVehiculoCacheModel.concesionarioVehiculoId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, concesionarioVehiculoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{concesionarioVehiculoId=");
		sb.append(concesionarioVehiculoId);
		sb.append(", concesionarioId=");
		sb.append(concesionarioId);
		sb.append(", vehiculoId=");
		sb.append(vehiculoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConcesionarioVehiculo toEntityModel() {
		ConcesionarioVehiculoImpl concesionarioVehiculoImpl =
			new ConcesionarioVehiculoImpl();

		concesionarioVehiculoImpl.setConcesionarioVehiculoId(
			concesionarioVehiculoId);
		concesionarioVehiculoImpl.setConcesionarioId(concesionarioId);
		concesionarioVehiculoImpl.setVehiculoId(vehiculoId);

		concesionarioVehiculoImpl.resetOriginalValues();

		return concesionarioVehiculoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		concesionarioVehiculoId = objectInput.readLong();

		concesionarioId = objectInput.readLong();

		vehiculoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(concesionarioVehiculoId);

		objectOutput.writeLong(concesionarioId);

		objectOutput.writeLong(vehiculoId);
	}

	public long concesionarioVehiculoId;
	public long concesionarioId;
	public long vehiculoId;

}