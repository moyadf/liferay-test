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

import com.dbsystem.cotizatuvehiculo.model.Concesionario;
import com.dbsystem.cotizatuvehiculo.service.base.ConcesionarioLocalServiceBaseImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioUtil;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the concesionario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dbsystem.cotizatuvehiculo.model.Concesionario",
	service = AopService.class
)
public class ConcesionarioLocalServiceImpl
	extends ConcesionarioLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioLocalServiceUtil</code>.
	 */
	
	public List<Concesionario> findByCiudadId(long ciudadId){
		return ConcesionarioUtil.findByCiudadId(ciudadId);
	}
	
	public List<Concesionario> findByCiudadIdEstado(long ciudadId, boolean estado){
		return ConcesionarioUtil.findByCiudadIdEstado(ciudadId, estado);
	}
}