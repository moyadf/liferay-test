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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchConcesionarioVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;
import com.dbsystem.cotizatuvehiculo.service.base.ConcesionarioVehiculoLocalServiceBaseImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioVehiculoUtil;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the concesionario vehiculo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioVehiculoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculoLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo",
	service = AopService.class
)
public class ConcesionarioVehiculoLocalServiceImpl
	extends ConcesionarioVehiculoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioVehiculoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.ConcesionarioVehiculoLocalServiceUtil</code>.
	 */
	
	public ConcesionarioVehiculo findByConcesionarioIdVehiculoId(long concesionarioId, long vehiculoId){
		try {
			return ConcesionarioVehiculoUtil.findByConcesionarioIdVehiculoId(concesionarioId, vehiculoId);
		} catch (NoSuchConcesionarioVehiculoException e) {
			return null;
		}
	}
	
	public List<ConcesionarioVehiculo> findByVehiculoId(long vehiculoId){
		return ConcesionarioVehiculoUtil.findByVehiculoId(vehiculoId);
	}
	
	public List<ConcesionarioVehiculo> findByConcesionarioId(long concesionarioId){
		return ConcesionarioVehiculoUtil.findByConcesionarioId(concesionarioId);
	}
}