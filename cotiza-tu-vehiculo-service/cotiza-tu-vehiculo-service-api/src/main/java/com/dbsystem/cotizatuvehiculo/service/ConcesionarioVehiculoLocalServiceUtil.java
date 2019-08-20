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

package com.dbsystem.cotizatuvehiculo.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ConcesionarioVehiculo. This utility wraps
 * <code>com.dbsystem.cotizatuvehiculo.service.impl.ConcesionarioVehiculoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculoLocalService
 * @generated
 */
@ProviderType
public class ConcesionarioVehiculoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dbsystem.cotizatuvehiculo.service.impl.ConcesionarioVehiculoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the concesionario vehiculo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was added
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		addConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return getService().addConcesionarioVehiculo(concesionarioVehiculo);
	}

	/**
	 * Creates a new concesionario vehiculo with the primary key. Does not add the concesionario vehiculo to the database.
	 *
	 * @param concesionarioVehiculoId the primary key for the new concesionario vehiculo
	 * @return the new concesionario vehiculo
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		createConcesionarioVehiculo(long concesionarioVehiculoId) {

		return getService().createConcesionarioVehiculo(
			concesionarioVehiculoId);
	}

	/**
	 * Deletes the concesionario vehiculo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		deleteConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return getService().deleteConcesionarioVehiculo(concesionarioVehiculo);
	}

	/**
	 * Deletes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws PortalException if a concesionario vehiculo with the primary key could not be found
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
			deleteConcesionarioVehiculo(long concesionarioVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteConcesionarioVehiculo(
			concesionarioVehiculoId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		fetchConcesionarioVehiculo(long concesionarioVehiculoId) {

		return getService().fetchConcesionarioVehiculo(concesionarioVehiculoId);
	}

	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			findByConcesionarioId(long concesionarioId) {

		return getService().findByConcesionarioId(concesionarioId);
	}

	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		findByConcesionarioIdVehiculoId(long concesionarioId, long vehiculoId) {

		return getService().findByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId);
	}

	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			findByVehiculoId(long vehiculoId) {

		return getService().findByVehiculoId(vehiculoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the concesionario vehiculo with the primary key.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws PortalException if a concesionario vehiculo with the primary key could not be found
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
			getConcesionarioVehiculo(long concesionarioVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getConcesionarioVehiculo(concesionarioVehiculoId);
	}

	/**
	 * Returns a range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of concesionario vehiculos
	 */
	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			getConcesionarioVehiculos(int start, int end) {

		return getService().getConcesionarioVehiculos(start, end);
	}

	/**
	 * Returns the number of concesionario vehiculos.
	 *
	 * @return the number of concesionario vehiculos
	 */
	public static int getConcesionarioVehiculosCount() {
		return getService().getConcesionarioVehiculosCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the concesionario vehiculo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was updated
	 */
	public static com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		updateConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return getService().updateConcesionarioVehiculo(concesionarioVehiculo);
	}

	public static ConcesionarioVehiculoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConcesionarioVehiculoLocalService, ConcesionarioVehiculoLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConcesionarioVehiculoLocalService.class);

		ServiceTracker
			<ConcesionarioVehiculoLocalService,
			 ConcesionarioVehiculoLocalService> serviceTracker =
				new ServiceTracker
					<ConcesionarioVehiculoLocalService,
					 ConcesionarioVehiculoLocalService>(
						 bundle.getBundleContext(),
						 ConcesionarioVehiculoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}