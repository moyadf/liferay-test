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

import com.dbsystem.cotizatuvehiculo.model.Ciudades;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Ciudades in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CiudadesCacheModel
	implements CacheModel<Ciudades>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CiudadesCacheModel)) {
			return false;
		}

		CiudadesCacheModel ciudadesCacheModel = (CiudadesCacheModel)obj;

		if (ciudadId == ciudadesCacheModel.ciudadId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ciudadId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ciudadId=");
		sb.append(ciudadId);
		sb.append(", ciudad=");
		sb.append(ciudad);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ciudades toEntityModel() {
		CiudadesImpl ciudadesImpl = new CiudadesImpl();

		ciudadesImpl.setCiudadId(ciudadId);

		if (ciudad == null) {
			ciudadesImpl.setCiudad("");
		}
		else {
			ciudadesImpl.setCiudad(ciudad);
		}

		ciudadesImpl.setEstado(estado);

		ciudadesImpl.resetOriginalValues();

		return ciudadesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ciudadId = objectInput.readLong();
		ciudad = objectInput.readUTF();

		estado = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ciudadId);

		if (ciudad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ciudad);
		}

		objectOutput.writeBoolean(estado);
	}

	public long ciudadId;
	public String ciudad;
	public boolean estado;

}