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
 * Provides the local service utility for Concesionario. This utility wraps
 * <code>com.dbsystem.cotizatuvehiculo.service.impl.ConcesionarioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioLocalService
 * @generated
 */
@ProviderType
public class ConcesionarioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dbsystem.cotizatuvehiculo.service.impl.ConcesionarioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the concesionario to the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was added
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
		addConcesionario(
			com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return getService().addConcesionario(concesionario);
	}

	/**
	 * Creates a new concesionario with the primary key. Does not add the concesionario to the database.
	 *
	 * @param concesionarioId the primary key for the new concesionario
	 * @return the new concesionario
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
		createConcesionario(long concesionarioId) {

		return getService().createConcesionario(concesionarioId);
	}

	/**
	 * Deletes the concesionario from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was removed
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
		deleteConcesionario(
			com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return getService().deleteConcesionario(concesionario);
	}

	/**
	 * Deletes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws PortalException if a concesionario with the primary key could not be found
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
			deleteConcesionario(long concesionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteConcesionario(concesionarioId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
		fetchConcesionario(long concesionarioId) {

		return getService().fetchConcesionario(concesionarioId);
	}

	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.Concesionario> findByCiudadId(
			long ciudadId) {

		return getService().findByCiudadId(ciudadId);
	}

	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.Concesionario>
			findByCiudadIdEstado(long ciudadId, boolean estado) {

		return getService().findByCiudadIdEstado(ciudadId, estado);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the concesionario with the primary key.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario
	 * @throws PortalException if a concesionario with the primary key could not be found
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
			getConcesionario(long concesionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getConcesionario(concesionarioId);
	}

	/**
	 * Returns a range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of concesionarios
	 */
	public static java.util.List
		<com.dbsystem.cotizatuvehiculo.model.Concesionario> getConcesionarios(
			int start, int end) {

		return getService().getConcesionarios(start, end);
	}

	/**
	 * Returns the number of concesionarios.
	 *
	 * @return the number of concesionarios
	 */
	public static int getConcesionariosCount() {
		return getService().getConcesionariosCount();
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
	 * Updates the concesionario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was updated
	 */
	public static com.dbsystem.cotizatuvehiculo.model.Concesionario
		updateConcesionario(
			com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return getService().updateConcesionario(concesionario);
	}

	public static ConcesionarioLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConcesionarioLocalService, ConcesionarioLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConcesionarioLocalService.class);

		ServiceTracker<ConcesionarioLocalService, ConcesionarioLocalService>
			serviceTracker =
				new ServiceTracker
					<ConcesionarioLocalService, ConcesionarioLocalService>(
						bundle.getBundleContext(),
						ConcesionarioLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}