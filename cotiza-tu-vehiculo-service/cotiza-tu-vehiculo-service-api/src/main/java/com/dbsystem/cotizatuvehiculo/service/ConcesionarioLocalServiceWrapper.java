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
 * Provides a wrapper for {@link ConcesionarioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioLocalService
 * @generated
 */
@ProviderType
public class ConcesionarioLocalServiceWrapper
	implements ConcesionarioLocalService,
			   ServiceWrapper<ConcesionarioLocalService> {

	public ConcesionarioLocalServiceWrapper(
		ConcesionarioLocalService concesionarioLocalService) {

		_concesionarioLocalService = concesionarioLocalService;
	}

	/**
	 * Adds the concesionario to the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was added
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario addConcesionario(
		com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return _concesionarioLocalService.addConcesionario(concesionario);
	}

	/**
	 * Creates a new concesionario with the primary key. Does not add the concesionario to the database.
	 *
	 * @param concesionarioId the primary key for the new concesionario
	 * @return the new concesionario
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario
		createConcesionario(long concesionarioId) {

		return _concesionarioLocalService.createConcesionario(concesionarioId);
	}

	/**
	 * Deletes the concesionario from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was removed
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario
		deleteConcesionario(
			com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return _concesionarioLocalService.deleteConcesionario(concesionario);
	}

	/**
	 * Deletes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws PortalException if a concesionario with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario
			deleteConcesionario(long concesionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioLocalService.deleteConcesionario(concesionarioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _concesionarioLocalService.dynamicQuery();
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

		return _concesionarioLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _concesionarioLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _concesionarioLocalService.dynamicQuery(
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

		return _concesionarioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _concesionarioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario fetchConcesionario(
		long concesionarioId) {

		return _concesionarioLocalService.fetchConcesionario(concesionarioId);
	}

	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Concesionario>
		findByCiudadId(long ciudadId) {

		return _concesionarioLocalService.findByCiudadId(ciudadId);
	}

	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Concesionario>
		findByCiudadIdEstado(long ciudadId, boolean estado) {

		return _concesionarioLocalService.findByCiudadIdEstado(
			ciudadId, estado);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _concesionarioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the concesionario with the primary key.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario
	 * @throws PortalException if a concesionario with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario getConcesionario(
			long concesionarioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioLocalService.getConcesionario(concesionarioId);
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
	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Concesionario>
		getConcesionarios(int start, int end) {

		return _concesionarioLocalService.getConcesionarios(start, end);
	}

	/**
	 * Returns the number of concesionarios.
	 *
	 * @return the number of concesionarios
	 */
	@Override
	public int getConcesionariosCount() {
		return _concesionarioLocalService.getConcesionariosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _concesionarioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _concesionarioLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the concesionario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param concesionario the concesionario
	 * @return the concesionario that was updated
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Concesionario
		updateConcesionario(
			com.dbsystem.cotizatuvehiculo.model.Concesionario concesionario) {

		return _concesionarioLocalService.updateConcesionario(concesionario);
	}

	@Override
	public ConcesionarioLocalService getWrappedService() {
		return _concesionarioLocalService;
	}

	@Override
	public void setWrappedService(
		ConcesionarioLocalService concesionarioLocalService) {

		_concesionarioLocalService = concesionarioLocalService;
	}

	private ConcesionarioLocalService _concesionarioLocalService;

}