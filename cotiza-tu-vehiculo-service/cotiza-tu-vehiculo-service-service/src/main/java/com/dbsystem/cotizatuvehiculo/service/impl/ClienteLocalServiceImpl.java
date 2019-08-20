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

package com.dbsystem.cotizatuvehiculo.service.impl;

import com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException;
import com.dbsystem.cotizatuvehiculo.model.Cliente;
import com.dbsystem.cotizatuvehiculo.service.base.ClienteLocalServiceBaseImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ClienteUtil;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the cliente local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dbsystem.cotizatuvehiculo.service.ClienteLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dbsystem.cotizatuvehiculo.model.Cliente",
	service = AopService.class
)
public class ClienteLocalServiceImpl extends ClienteLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dbsystem.cotizatuvehiculo.service.ClienteLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.ClienteLocalServiceUtil</code>.
	 */
	public Cliente findByIdentificacion(long tipoDocumento, String numeroDocumento) {
		try {
			return ClienteUtil.findByIdentificacion(tipoDocumento, numeroDocumento);
		} catch (NoSuchClienteException e) {
			return null;
		}
	}
}