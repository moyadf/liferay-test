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

import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;

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
 * The persistence utility for the cliente vehiculo service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.ClienteVehiculoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteVehiculoPersistence
 * @generated
 */
@ProviderType
public class ClienteVehiculoUtil {

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
	public static void clearCache(ClienteVehiculo clienteVehiculo) {
		getPersistence().clearCache(clienteVehiculo);
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
	public static Map<Serializable, ClienteVehiculo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ClienteVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClienteVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClienteVehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ClienteVehiculo update(ClienteVehiculo clienteVehiculo) {
		return getPersistence().update(clienteVehiculo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ClienteVehiculo update(
		ClienteVehiculo clienteVehiculo, ServiceContext serviceContext) {

		return getPersistence().update(clienteVehiculo, serviceContext);
	}

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo findByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId);
	}

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId) {

		return getPersistence().fetchByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId);
	}

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId,
		boolean retrieveFromCache) {

		return getPersistence().fetchByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId, retrieveFromCache);
	}

	/**
	 * Removes the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the cliente vehiculo that was removed
	 */
	public static ClienteVehiculo removeByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().removeByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId);
	}

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	public static int countByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId) {

		return getPersistence().countByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId);
	}

	/**
	 * Returns all the cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByClienteId(long clienteId) {
		return getPersistence().findByClienteId(clienteId);
	}

	/**
	 * Returns a range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end) {

		return getPersistence().findByClienteId(clienteId, start, end);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().findByClienteId(
			clienteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByClienteId(
			clienteId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo findByClienteId_First(
			long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByClienteId_First(
			clienteId, orderByComparator);
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByClienteId_First(
		long clienteId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().fetchByClienteId_First(
			clienteId, orderByComparator);
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo findByClienteId_Last(
			long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByClienteId_Last(
			clienteId, orderByComparator);
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByClienteId_Last(
		long clienteId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().fetchByClienteId_Last(
			clienteId, orderByComparator);
	}

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public static ClienteVehiculo[] findByClienteId_PrevAndNext(
			long clienteVehiculoId, long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByClienteId_PrevAndNext(
			clienteVehiculoId, clienteId, orderByComparator);
	}

	/**
	 * Removes all the cliente vehiculos where clienteId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 */
	public static void removeByClienteId(long clienteId) {
		getPersistence().removeByClienteId(clienteId);
	}

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the number of matching cliente vehiculos
	 */
	public static int countByClienteId(long clienteId) {
		return getPersistence().countByClienteId(clienteId);
	}

	/**
	 * Returns all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByVehiculoId(long vehiculoId) {
		return getPersistence().findByVehiculoId(vehiculoId);
	}

	/**
	 * Returns a range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end) {

		return getPersistence().findByVehiculoId(vehiculoId, start, end);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().findByVehiculoId(
			vehiculoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cliente vehiculos
	 */
	public static List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByVehiculoId(
			vehiculoId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo findByVehiculoId_First(
			long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByVehiculoId_First(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByVehiculoId_First(
		long vehiculoId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().fetchByVehiculoId_First(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo findByVehiculoId_Last(
			long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByVehiculoId_Last(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public static ClienteVehiculo fetchByVehiculoId_Last(
		long vehiculoId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().fetchByVehiculoId_Last(
			vehiculoId, orderByComparator);
	}

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public static ClienteVehiculo[] findByVehiculoId_PrevAndNext(
			long clienteVehiculoId, long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByVehiculoId_PrevAndNext(
			clienteVehiculoId, vehiculoId, orderByComparator);
	}

	/**
	 * Removes all the cliente vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	public static void removeByVehiculoId(long vehiculoId) {
		getPersistence().removeByVehiculoId(vehiculoId);
	}

	/**
	 * Returns the number of cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	public static int countByVehiculoId(long vehiculoId) {
		return getPersistence().countByVehiculoId(vehiculoId);
	}

	/**
	 * Caches the cliente vehiculo in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 */
	public static void cacheResult(ClienteVehiculo clienteVehiculo) {
		getPersistence().cacheResult(clienteVehiculo);
	}

	/**
	 * Caches the cliente vehiculos in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculos the cliente vehiculos
	 */
	public static void cacheResult(List<ClienteVehiculo> clienteVehiculos) {
		getPersistence().cacheResult(clienteVehiculos);
	}

	/**
	 * Creates a new cliente vehiculo with the primary key. Does not add the cliente vehiculo to the database.
	 *
	 * @param clienteVehiculoId the primary key for the new cliente vehiculo
	 * @return the new cliente vehiculo
	 */
	public static ClienteVehiculo create(long clienteVehiculoId) {
		return getPersistence().create(clienteVehiculoId);
	}

	/**
	 * Removes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public static ClienteVehiculo remove(long clienteVehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().remove(clienteVehiculoId);
	}

	public static ClienteVehiculo updateImpl(ClienteVehiculo clienteVehiculo) {
		return getPersistence().updateImpl(clienteVehiculo);
	}

	/**
	 * Returns the cliente vehiculo with the primary key or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public static ClienteVehiculo findByPrimaryKey(long clienteVehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchClienteVehiculoException {

		return getPersistence().findByPrimaryKey(clienteVehiculoId);
	}

	/**
	 * Returns the cliente vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo, or <code>null</code> if a cliente vehiculo with the primary key could not be found
	 */
	public static ClienteVehiculo fetchByPrimaryKey(long clienteVehiculoId) {
		return getPersistence().fetchByPrimaryKey(clienteVehiculoId);
	}

	/**
	 * Returns all the cliente vehiculos.
	 *
	 * @return the cliente vehiculos
	 */
	public static List<ClienteVehiculo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of cliente vehiculos
	 */
	public static List<ClienteVehiculo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cliente vehiculos
	 */
	public static List<ClienteVehiculo> findAll(
		int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cliente vehiculos
	 */
	public static List<ClienteVehiculo> findAll(
		int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the cliente vehiculos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cliente vehiculos.
	 *
	 * @return the number of cliente vehiculos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClienteVehiculoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClienteVehiculoPersistence, ClienteVehiculoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClienteVehiculoPersistence.class);

		ServiceTracker<ClienteVehiculoPersistence, ClienteVehiculoPersistence>
			serviceTracker =
				new ServiceTracker
					<ClienteVehiculoPersistence, ClienteVehiculoPersistence>(
						bundle.getBundleContext(),
						ClienteVehiculoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}