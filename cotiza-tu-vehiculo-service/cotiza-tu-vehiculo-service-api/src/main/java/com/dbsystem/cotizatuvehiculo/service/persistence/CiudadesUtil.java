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

import com.dbsystem.cotizatuvehiculo.model.Ciudades;

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
 * The persistence utility for the ciudades service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.CiudadesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CiudadesPersistence
 * @generated
 */
@ProviderType
public class CiudadesUtil {

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
	public static void clearCache(Ciudades ciudades) {
		getPersistence().clearCache(ciudades);
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
	public static Map<Serializable, Ciudades> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ciudades> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ciudades> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ciudades> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ciudades> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ciudades update(Ciudades ciudades) {
		return getPersistence().update(ciudades);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ciudades update(
		Ciudades ciudades, ServiceContext serviceContext) {

		return getPersistence().update(ciudades, serviceContext);
	}

	/**
	 * Returns all the ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the matching ciudadeses
	 */
	public static List<Ciudades> findByEstado(boolean estado) {
		return getPersistence().findByEstado(estado);
	}

	/**
	 * Returns a range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of matching ciudadeses
	 */
	public static List<Ciudades> findByEstado(
		boolean estado, int start, int end) {

		return getPersistence().findByEstado(estado, start, end);
	}

	/**
	 * Returns an ordered range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ciudadeses
	 */
	public static List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		OrderByComparator<Ciudades> orderByComparator) {

		return getPersistence().findByEstado(
			estado, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ciudadeses
	 */
	public static List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		OrderByComparator<Ciudades> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByEstado(
			estado, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	public static Ciudades findByEstado_First(
			boolean estado, OrderByComparator<Ciudades> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException {

		return getPersistence().findByEstado_First(estado, orderByComparator);
	}

	/**
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	public static Ciudades fetchByEstado_First(
		boolean estado, OrderByComparator<Ciudades> orderByComparator) {

		return getPersistence().fetchByEstado_First(estado, orderByComparator);
	}

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	public static Ciudades findByEstado_Last(
			boolean estado, OrderByComparator<Ciudades> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException {

		return getPersistence().findByEstado_Last(estado, orderByComparator);
	}

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	public static Ciudades fetchByEstado_Last(
		boolean estado, OrderByComparator<Ciudades> orderByComparator) {

		return getPersistence().fetchByEstado_Last(estado, orderByComparator);
	}

	/**
	 * Returns the ciudadeses before and after the current ciudades in the ordered set where estado = &#63;.
	 *
	 * @param ciudadId the primary key of the current ciudades
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public static Ciudades[] findByEstado_PrevAndNext(
			long ciudadId, boolean estado,
			OrderByComparator<Ciudades> orderByComparator)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException {

		return getPersistence().findByEstado_PrevAndNext(
			ciudadId, estado, orderByComparator);
	}

	/**
	 * Removes all the ciudadeses where estado = &#63; from the database.
	 *
	 * @param estado the estado
	 */
	public static void removeByEstado(boolean estado) {
		getPersistence().removeByEstado(estado);
	}

	/**
	 * Returns the number of ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the number of matching ciudadeses
	 */
	public static int countByEstado(boolean estado) {
		return getPersistence().countByEstado(estado);
	}

	/**
	 * Caches the ciudades in the entity cache if it is enabled.
	 *
	 * @param ciudades the ciudades
	 */
	public static void cacheResult(Ciudades ciudades) {
		getPersistence().cacheResult(ciudades);
	}

	/**
	 * Caches the ciudadeses in the entity cache if it is enabled.
	 *
	 * @param ciudadeses the ciudadeses
	 */
	public static void cacheResult(List<Ciudades> ciudadeses) {
		getPersistence().cacheResult(ciudadeses);
	}

	/**
	 * Creates a new ciudades with the primary key. Does not add the ciudades to the database.
	 *
	 * @param ciudadId the primary key for the new ciudades
	 * @return the new ciudades
	 */
	public static Ciudades create(long ciudadId) {
		return getPersistence().create(ciudadId);
	}

	/**
	 * Removes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public static Ciudades remove(long ciudadId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException {

		return getPersistence().remove(ciudadId);
	}

	public static Ciudades updateImpl(Ciudades ciudades) {
		return getPersistence().updateImpl(ciudades);
	}

	/**
	 * Returns the ciudades with the primary key or throws a <code>NoSuchCiudadesException</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public static Ciudades findByPrimaryKey(long ciudadId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException {

		return getPersistence().findByPrimaryKey(ciudadId);
	}

	/**
	 * Returns the ciudades with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades, or <code>null</code> if a ciudades with the primary key could not be found
	 */
	public static Ciudades fetchByPrimaryKey(long ciudadId) {
		return getPersistence().fetchByPrimaryKey(ciudadId);
	}

	/**
	 * Returns all the ciudadeses.
	 *
	 * @return the ciudadeses
	 */
	public static List<Ciudades> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of ciudadeses
	 */
	public static List<Ciudades> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ciudadeses
	 */
	public static List<Ciudades> findAll(
		int start, int end, OrderByComparator<Ciudades> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ciudadeses
	 */
	public static List<Ciudades> findAll(
		int start, int end, OrderByComparator<Ciudades> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the ciudadeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ciudadeses.
	 *
	 * @return the number of ciudadeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CiudadesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CiudadesPersistence, CiudadesPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CiudadesPersistence.class);

		ServiceTracker<CiudadesPersistence, CiudadesPersistence>
			serviceTracker =
				new ServiceTracker<CiudadesPersistence, CiudadesPersistence>(
					bundle.getBundleContext(), CiudadesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}