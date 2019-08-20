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

import com.dbsystem.cotizatuvehiculo.model.Vehiculo;

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
 * The persistence utility for the vehiculo service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.VehiculoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VehiculoPersistence
 * @generated
 */
@ProviderType
public class VehiculoUtil {

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
	public static void clearCache(Vehiculo vehiculo) {
		getPersistence().clearCache(vehiculo);
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
	public static Map<Serializable, Vehiculo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Vehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vehiculo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Vehiculo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vehiculo update(Vehiculo vehiculo) {
		return getPersistence().update(vehiculo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vehiculo update(
		Vehiculo vehiculo, ServiceContext serviceContext) {

		return getPersistence().update(vehiculo, serviceContext);
	}

	/**
	 * Caches the vehiculo in the entity cache if it is enabled.
	 *
	 * @param vehiculo the vehiculo
	 */
	public static void cacheResult(Vehiculo vehiculo) {
		getPersistence().cacheResult(vehiculo);
	}

	/**
	 * Caches the vehiculos in the entity cache if it is enabled.
	 *
	 * @param vehiculos the vehiculos
	 */
	public static void cacheResult(List<Vehiculo> vehiculos) {
		getPersistence().cacheResult(vehiculos);
	}

	/**
	 * Creates a new vehiculo with the primary key. Does not add the vehiculo to the database.
	 *
	 * @param vehiculoId the primary key for the new vehiculo
	 * @return the new vehiculo
	 */
	public static Vehiculo create(long vehiculoId) {
		return getPersistence().create(vehiculoId);
	}

	/**
	 * Removes the vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo that was removed
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	public static Vehiculo remove(long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchVehiculoException {

		return getPersistence().remove(vehiculoId);
	}

	public static Vehiculo updateImpl(Vehiculo vehiculo) {
		return getPersistence().updateImpl(vehiculo);
	}

	/**
	 * Returns the vehiculo with the primary key or throws a <code>NoSuchVehiculoException</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	public static Vehiculo findByPrimaryKey(long vehiculoId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchVehiculoException {

		return getPersistence().findByPrimaryKey(vehiculoId);
	}

	/**
	 * Returns the vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo, or <code>null</code> if a vehiculo with the primary key could not be found
	 */
	public static Vehiculo fetchByPrimaryKey(long vehiculoId) {
		return getPersistence().fetchByPrimaryKey(vehiculoId);
	}

	/**
	 * Returns all the vehiculos.
	 *
	 * @return the vehiculos
	 */
	public static List<Vehiculo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @return the range of vehiculos
	 */
	public static List<Vehiculo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vehiculos
	 */
	public static List<Vehiculo> findAll(
		int start, int end, OrderByComparator<Vehiculo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vehiculos
	 */
	public static List<Vehiculo> findAll(
		int start, int end, OrderByComparator<Vehiculo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the vehiculos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vehiculos.
	 *
	 * @return the number of vehiculos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VehiculoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VehiculoPersistence, VehiculoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VehiculoPersistence.class);

		ServiceTracker<VehiculoPersistence, VehiculoPersistence>
			serviceTracker =
				new ServiceTracker<VehiculoPersistence, VehiculoPersistence>(
					bundle.getBundleContext(), VehiculoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}