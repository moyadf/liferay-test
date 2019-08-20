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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CiudadesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CiudadesLocalService
 * @generated
 */
@ProviderType
public class CiudadesLocalServiceWrapper
	implements CiudadesLocalService, ServiceWrapper<CiudadesLocalService> {

	public CiudadesLocalServiceWrapper(
		CiudadesLocalService ciudadesLocalService) {

		_ciudadesLocalService = ciudadesLocalService;
	}

	/**
	 * Adds the ciudades to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was added
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades addCiudades(
		com.dbsystem.cotizatuvehiculo.model.Ciudades ciudades) {

		return _ciudadesLocalService.addCiudades(ciudades);
	}

	/**
	 * Creates a new ciudades with the primary key. Does not add the ciudades to the database.
	 *
	 * @param ciudadId the primary key for the new ciudades
	 * @return the new ciudades
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades createCiudades(
		long ciudadId) {

		return _ciudadesLocalService.createCiudades(ciudadId);
	}

	/**
	 * Deletes the ciudades from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was removed
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades deleteCiudades(
		com.dbsystem.cotizatuvehiculo.model.Ciudades ciudades) {

		return _ciudadesLocalService.deleteCiudades(ciudades);
	}

	/**
	 * Deletes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws PortalException if a ciudades with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades deleteCiudades(
			long ciudadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ciudadesLocalService.deleteCiudades(ciudadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ciudadesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ciudadesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ciudadesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ciudadesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ciudadesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ciudadesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ciudadesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades fetchCiudades(
		long ciudadId) {

		return _ciudadesLocalService.fetchCiudades(ciudadId);
	}

	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Ciudades>
		findByEstado(boolean estado) {

		return _ciudadesLocalService.findByEstado(estado);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ciudadesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ciudades with the primary key.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades
	 * @throws PortalException if a ciudades with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades getCiudades(
			long ciudadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ciudadesLocalService.getCiudades(ciudadId);
	}

	/**
	 * Returns a range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of ciudadeses
	 */
	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Ciudades>
		getCiudadeses(int start, int end) {

		return _ciudadesLocalService.getCiudadeses(start, end);
	}

	/**
	 * Returns the number of ciudadeses.
	 *
	 * @return the number of ciudadeses
	 */
	@Override
	public int getCiudadesesCount() {
		return _ciudadesLocalService.getCiudadesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ciudadesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ciudadesLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ciudadesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ciudades in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was updated
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Ciudades updateCiudades(
		com.dbsystem.cotizatuvehiculo.model.Ciudades ciudades) {

		return _ciudadesLocalService.updateCiudades(ciudades);
	}

	@Override
	public CiudadesLocalService getWrappedService() {
		return _ciudadesLocalService;
	}

	@Override
	public void setWrappedService(CiudadesLocalService ciudadesLocalService) {
		_ciudadesLocalService = ciudadesLocalService;
	}

	private CiudadesLocalService _ciudadesLocalService;

}