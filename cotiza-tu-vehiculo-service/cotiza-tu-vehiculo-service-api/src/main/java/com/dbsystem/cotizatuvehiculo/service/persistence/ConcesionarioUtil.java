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

import com.dbsystem.cotizatuvehiculo.model.Concesionario;

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
 * The persistence utility for the concesionario service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.ConcesionarioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioPersistence
 * @generated
 */
@ProviderType
public class ConcesionarioUtil {

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
	public static void clearCache(Concesionario concesionario) {
		getPersistence().clearCache(concesionario);
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
	public static Map<Serializable, Concesionario> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Concesionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Concesionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Concesionario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Concesionario update(Concesionario concesionario) {
		return getPersistence().update(concesionario);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Concesionario update(
		Concesionario concesionario, ServiceContext serviceContext) {

		return getPersistence().update(concesionario, serviceContext);
	}

	/**
	 * Returns all the concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the matching concesionarios
	 */
	public static List<Concesionario> findByCiudadId(long ciudadId) {
		return getPersistence().findByCiudadId(ciudadId);
	}

	/**
	 * Returns a range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end) {

		return getPersistence().findByCiudadId(ciudadId, start, end);
	}

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().findByCiudadId(
			ciudadId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		OrderByComparator<Concesionario> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCiudadId(
			ciudadId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public static Concesionario findByCiudadId_First(
			long ciudadId, OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadId_First(
			ciudadId, orderByComparator);
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public static Concesionario fetchByCiudadId_First(
		long ciudadId, OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().fetchByCiudadId_First(
			ciudadId, orderByComparator);
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public static Concesionario findByCiudadId_Last(
			long ciudadId, OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadId_Last(
			ciudadId, orderByComparator);
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public static Concesionario fetchByCiudadId_Last(
		long ciudadId, OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().fetchByCiudadId_Last(
			ciudadId, orderByComparator);
	}

	/**
	 * Returns the concesionarios before and after the current concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param concesionarioId the primary key of the current concesionario
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public static Concesionario[] findByCiudadId_PrevAndNext(
			long concesionarioId, long ciudadId,
			OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadId_PrevAndNext(
			concesionarioId, ciudadId, orderByComparator);
	}

	/**
	 * Removes all the concesionarios where ciudadId = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 */
	public static void removeByCiudadId(long ciudadId) {
		getPersistence().removeByCiudadId(ciudadId);
	}

	/**
	 * Returns the number of concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the number of matching concesionarios
	 */
	public static int countByCiudadId(long ciudadId) {
		return getPersistence().countByCiudadId(ciudadId);
	}

	/**
	 * Returns all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the matching concesionarios
	 */
	public static List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado) {

		return getPersistence().findByCiudadIdEstado(ciudadId, estado);
	}

	/**
	 * Returns a range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end) {

		return getPersistence().findByCiudadIdEstado(
			ciudadId, estado, start, end);
	}

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().findByCiudadIdEstado(
			ciudadId, estado, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionarios
	 */
	public static List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		OrderByComparator<Concesionario> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCiudadIdEstado(
			ciudadId, estado, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public static Concesionario findByCiudadIdEstado_First(
			long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadIdEstado_First(
			ciudadId, estado, orderByComparator);
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public static Concesionario fetchByCiudadIdEstado_First(
		long ciudadId, boolean estado,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().fetchByCiudadIdEstado_First(
			ciudadId, estado, orderByComparator);
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public static Concesionario findByCiudadIdEstado_Last(
			long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadIdEstado_Last(
			ciudadId, estado, orderByComparator);
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public static Concesionario fetchByCiudadIdEstado_Last(
		long ciudadId, boolean estado,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().fetchByCiudadIdEstado_Last(
			ciudadId, estado, orderByComparator);
	}

	/**
	 * Returns the concesionarios before and after the current concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param concesionarioId the primary key of the current concesionario
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public static Concesionario[] findByCiudadIdEstado_PrevAndNext(
			long concesionarioId, long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByCiudadIdEstado_PrevAndNext(
			concesionarioId, ciudadId, estado, orderByComparator);
	}

	/**
	 * Removes all the concesionarios where ciudadId = &#63; and estado = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 */
	public static void removeByCiudadIdEstado(long ciudadId, boolean estado) {
		getPersistence().removeByCiudadIdEstado(ciudadId, estado);
	}

	/**
	 * Returns the number of concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the number of matching concesionarios
	 */
	public static int countByCiudadIdEstado(long ciudadId, boolean estado) {
		return getPersistence().countByCiudadIdEstado(ciudadId, estado);
	}

	/**
	 * Caches the concesionario in the entity cache if it is enabled.
	 *
	 * @param concesionario the concesionario
	 */
	public static void cacheResult(Concesionario concesionario) {
		getPersistence().cacheResult(concesionario);
	}

	/**
	 * Caches the concesionarios in the entity cache if it is enabled.
	 *
	 * @param concesionarios the concesionarios
	 */
	public static void cacheResult(List<Concesionario> concesionarios) {
		getPersistence().cacheResult(concesionarios);
	}

	/**
	 * Creates a new concesionario with the primary key. Does not add the concesionario to the database.
	 *
	 * @param concesionarioId the primary key for the new concesionario
	 * @return the new concesionario
	 */
	public static Concesionario create(long concesionarioId) {
		return getPersistence().create(concesionarioId);
	}

	/**
	 * Removes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public static Concesionario remove(long concesionarioId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().remove(concesionarioId);
	}

	public static Concesionario updateImpl(Concesionario concesionario) {
		return getPersistence().updateImpl(concesionario);
	}

	/**
	 * Returns the concesionario with the primary key or throws a <code>NoSuchConcesionarioException</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public static Concesionario findByPrimaryKey(long concesionarioId)
		throws com.dbsystem.cotizatuvehiculo.exception.
			NoSuchConcesionarioException {

		return getPersistence().findByPrimaryKey(concesionarioId);
	}

	/**
	 * Returns the concesionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario, or <code>null</code> if a concesionario with the primary key could not be found
	 */
	public static Concesionario fetchByPrimaryKey(long concesionarioId) {
		return getPersistence().fetchByPrimaryKey(concesionarioId);
	}

	/**
	 * Returns all the concesionarios.
	 *
	 * @return the concesionarios
	 */
	public static List<Concesionario> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of concesionarios
	 */
	public static List<Concesionario> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concesionarios
	 */
	public static List<Concesionario> findAll(
		int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of concesionarios
	 */
	public static List<Concesionario> findAll(
		int start, int end, OrderByComparator<Concesionario> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the concesionarios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of concesionarios.
	 *
	 * @return the number of concesionarios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConcesionarioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConcesionarioPersistence, ConcesionarioPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ConcesionarioPersistence.class);

		ServiceTracker<ConcesionarioPersistence, ConcesionarioPersistence>
			serviceTracker =
				new ServiceTracker
					<ConcesionarioPersistence, ConcesionarioPersistence>(
						bundle.getBundleContext(),
						ConcesionarioPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}