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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Concesionario service. Represents a row in the &quot;dbsystem_Concesionario&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioModel
 * @generated
 */
@ImplementationClassName(
	"com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioImpl"
)
@ProviderType
public interface Concesionario extends ConcesionarioModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Concesionario, Long>
		CONCESIONARIO_ID_ACCESSOR = new Accessor<Concesionario, Long>() {

			@Override
			public Long get(Concesionario concesionario) {
				return concesionario.getConcesionarioId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Concesionario> getTypeClass() {
				return Concesionario.class;
			}

		};

}