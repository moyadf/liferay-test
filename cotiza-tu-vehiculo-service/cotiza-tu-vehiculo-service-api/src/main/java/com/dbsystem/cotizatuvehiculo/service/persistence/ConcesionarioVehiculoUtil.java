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

package com.dbsystem.cotizatuvehiculo.service.persistence;

import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the concesionario vehiculo service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.ConcesionarioVehiculoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculoPersistence
 * @generated
 */
@ProviderType
public class ConcesionarioVehiculoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ConcesionarioVehiculo concesionarioVehiculo) {
		getPersistence().clearCache(concesionarioVehiculo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ConcesionarioVehiculo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConcesionarioVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConcesionarioVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConcesionarioVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConcesionarioVehiculo update(
		ConcesionarioVehiculo concesionarioVehiculo) {

		return getPersistence().update(concesionarioVehiculo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConcesionarioVehiculo update(
		ConcesionarioVehiculo concesionarioVehiculo,
		ServiceContext serviceContext) {

		return getPersistence().update(concesionarioVehiculo, serviceContext);
	}

	/**
	 * Returns all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId) {

		return getPersistence().findByConcesionarioId(concesionarioId);
	}

	/**
	 * Returns a range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end) {

		return getPersistence().findByConcesionarioId(
			concesionarioId, start, end);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().findByConcesionarioId(
			concesionarioId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByConcesionarioId(
			concesionarioId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo findByConcesionarioId_First(
			long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByConcesionarioId_First(
			concesionarioId, orderByComparator);
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByConcesionarioId_First(
		long concesionarioId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().fetchByConcesionarioId_First(
			concesionarioId, orderByComparator);
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo findByConcesionarioId_Last(
			long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByConcesionarioId_Last(
			concesionarioId, orderByComparator);
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByConcesionarioId_Last(
		long concesionarioId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().fetchByConcesionarioId_Last(
			concesionarioId, orderByComparator);
	}

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public static ConcesionarioVehiculo[] findByConcesionarioId_PrevAndNext(
			long concesionarioVehiculoId, long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByConcesionarioId_PrevAndNext(
			concesionarioVehiculoId, concesionarioId, orderByComparator);
	}

	/**
	 * Removes all the concesionario vehiculos where concesionarioId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 */
	public static void removeByConcesionarioId(long concesionarioId) {
		getPersistence().removeByConcesionarioId(concesionarioId);
	}

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the number of matching concesionario vehiculos
	 */
	public static int countByConcesionarioId(long concesionarioId) {
		return getPersistence().countByConcesionarioId(concesionarioId);
	}

	/**
	 * Returns all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId) {

		return getPersistence().findByVehiculoId(vehiculoId);
	}

	/**
	 * Returns a range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end) {

		return getPersistence().findByVehiculoId(vehiculoId, start, end);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().findByVehiculoId(
			vehiculoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVehiculoId(
			vehiculoId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo findByVehiculoId_First(
			long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByVehiculoId_First(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByVehiculoId_First(
		long vehiculoId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().fetchByVehiculoId_First(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo findByVehiculoId_Last(
			long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByVehiculoId_Last(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByVehiculoId_Last(
		long vehiculoId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().fetchByVehiculoId_Last(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public static ConcesionarioVehiculo[] findByVehiculoId_PrevAndNext(
			long concesionarioVehiculoId, long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByVehiculoId_PrevAndNext(
			concesionarioVehiculoId, vehiculoId, orderByComparator);
	}

	/**
	 * Removes all the concesionario vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	public static void removeByVehiculoId(long vehiculoId) {
		getPersistence().removeByVehiculoId(vehiculoId);
	}

	/**
	 * Returns the number of concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	public static int countByVehiculoId(long vehiculoId) {
		return getPersistence().countByVehiculoId(vehiculoId);
	}

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo findByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId);
	}

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId) {

		return getPersistence().fetchByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId);
	}

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public static ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId, boolean retrieveFromCache) {

		return getPersistence().fetchByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId, retrieveFromCache);
	}

	/**
	 * Removes the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the concesionario vehiculo that was removed
	 */
	public static ConcesionarioVehiculo removeByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().removeByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId);
	}

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	public static int countByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId) {

		return getPersistence().countByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId);
	}

	/**
	 * Caches the concesionario vehiculo in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 */
	public static void cacheResult(
		ConcesionarioVehiculo concesionarioVehiculo) {

		getPersistence().cacheResult(concesionarioVehiculo);
	}

	/**
	 * Caches the concesionario vehiculos in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculos the concesionario vehiculos
	 */
	public static void cacheResult(
		List<ConcesionarioVehiculo> concesionarioVehiculos) {

		getPersistence().cacheResult(concesionarioVehiculos);
	}

	/**
	 * Creates a new concesionario vehiculo with the primary key. Does not add the concesionario vehiculo to the database.
	 *
	 * @param concesionarioVehiculoId the primary key for the new concesionario vehiculo
	 * @return the new concesionario vehiculo
	 */
	public static ConcesionarioVehiculo create(long concesionarioVehiculoId) {
		return getPersistence().create(concesionarioVehiculoId);
	}

	/**
	 * Removes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public static ConcesionarioVehiculo remove(long concesionarioVehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().remove(concesionarioVehiculoId);
	}

	public static ConcesionarioVehiculo updateImpl(
		ConcesionarioVehiculo concesionarioVehiculo) {

		return getPersistence().updateImpl(concesionarioVehiculo);
	}

	/**
	 * Returns the concesionario vehiculo with the primary key or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public static ConcesionarioVehiculo findByPrimaryKey(
			long concesionarioVehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioVehiculoException {

		return getPersistence().findByPrimaryKey(concesionarioVehiculoId);
	}

	/**
	 * Returns the concesionario vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo, or <code>null</code> if a concesionario vehiculo with the primary key could not be found
	 */
	public static ConcesionarioVehiculo fetchByPrimaryKey(
		long concesionarioVehiculoId) {

		return getPersistence().fetchByPrimaryKey(concesionarioVehiculoId);
	}

	/**
	 * Returns all the concesionario vehiculos.
	 *
	 * @return the concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findAll(
		int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of concesionario vehiculos
	 */
	public static List<ConcesionarioVehiculo> findAll(
		int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the concesionario vehiculos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of concesionario vehiculos.
	 *
	 * @return the number of concesionario vehiculos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConcesionarioVehiculoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConcesionarioVehiculoPersistence, ConcesionarioVehiculoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConcesionarioVehiculoPersistence.class);

		ServiceTracker
			<ConcesionarioVehiculoPersistence, ConcesionarioVehiculoPersistence>
				serviceTracker =
					new ServiceTracker
						<ConcesionarioVehiculoPersistence,
						 ConcesionarioVehiculoPersistence>(
							 bundle.getBundleContext(),
							 ConcesionarioVehiculoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}