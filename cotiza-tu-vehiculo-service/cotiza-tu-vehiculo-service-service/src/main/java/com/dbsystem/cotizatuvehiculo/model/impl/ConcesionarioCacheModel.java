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

import com.dbsystem.cotizatuvehiculo.model.Concesionario;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Concesionario in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ConcesionarioCacheModel
	implements CacheModel<Concesionario>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConcesionarioCacheModel)) {
			return false;
		}

		ConcesionarioCacheModel concesionarioCacheModel =
			(ConcesionarioCacheModel)obj;

		if (concesionarioId == concesionarioCacheModel.concesionarioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, concesionarioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{concesionarioId=");
		sb.append(concesionarioId);
		sb.append(", ciudadId=");
		sb.append(ciudadId);
		sb.append(", concesionario=");
		sb.append(concesionario);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Concesionario toEntityModel() {
		ConcesionarioImpl concesionarioImpl = new ConcesionarioImpl();

		concesionarioImpl.setConcesionarioId(concesionarioId);
		concesionarioImpl.setCiudadId(ciudadId);

		if (concesionario == null) {
			concesionarioImpl.setConcesionario("");
		}
		else {
			concesionarioImpl.setConcesionario(concesionario);
		}

		concesionarioImpl.setEstado(estado);

		concesionarioImpl.resetOriginalValues();

		return concesionarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		concesionarioId = objectInput.readLong();

		ciudadId = objectInput.readLong();
		concesionario = objectInput.readUTF();

		estado = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(concesionarioId);

		objectOutput.writeLong(ciudadId);

		if (concesionario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(concesionario);
		}

		objectOutput.writeBoolean(estado);
	}

	public long concesionarioId;
	public long ciudadId;
	public String concesionario;
	public boolean estado;

}