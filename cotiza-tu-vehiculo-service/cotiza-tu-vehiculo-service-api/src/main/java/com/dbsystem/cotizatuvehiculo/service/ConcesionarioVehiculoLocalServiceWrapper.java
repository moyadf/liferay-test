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
 * Provides a wrapper for {@link ConcesionarioVehiculoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculoLocalService
 * @generated
 */
@ProviderType
public class ConcesionarioVehiculoLocalServiceWrapper
	implements ConcesionarioVehiculoLocalService,
			   ServiceWrapper<ConcesionarioVehiculoLocalService> {

	public ConcesionarioVehiculoLocalServiceWrapper(
		ConcesionarioVehiculoLocalService concesionarioVehiculoLocalService) {

		_concesionarioVehiculoLocalService = concesionarioVehiculoLocalService;
	}

	/**
	 * Adds the concesionario vehiculo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was added
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		addConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return _concesionarioVehiculoLocalService.addConcesionarioVehiculo(
			concesionarioVehiculo);
	}

	/**
	 * Creates a new concesionario vehiculo with the primary key. Does not add the concesionario vehiculo to the database.
	 *
	 * @param concesionarioVehiculoId the primary key for the new concesionario vehiculo
	 * @return the new concesionario vehiculo
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		createConcesionarioVehiculo(long concesionarioVehiculoId) {

		return _concesionarioVehiculoLocalService.createConcesionarioVehiculo(
			concesionarioVehiculoId);
	}

	/**
	 * Deletes the concesionario vehiculo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		deleteConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return _concesionarioVehiculoLocalService.deleteConcesionarioVehiculo(
			concesionarioVehiculo);
	}

	/**
	 * Deletes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws PortalException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
			deleteConcesionarioVehiculo(long concesionarioVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioVehiculoLocalService.deleteConcesionarioVehiculo(
			concesionarioVehiculoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioVehiculoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _concesionarioVehiculoLocalService.dynamicQuery();
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

		return _concesionarioVehiculoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _concesionarioVehiculoLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _concesionarioVehiculoLocalService.dynamicQuery(
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

		return _concesionarioVehiculoLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _concesionarioVehiculoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		fetchConcesionarioVehiculo(long concesionarioVehiculoId) {

		return _concesionarioVehiculoLocalService.fetchConcesionarioVehiculo(
			concesionarioVehiculoId);
	}

	@Override
	public java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			findByConcesionarioId(long concesionarioId) {

		return _concesionarioVehiculoLocalService.findByConcesionarioId(
			concesionarioId);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		findByConcesionarioIdVehiculoId(long concesionarioId, long vehiculoId) {

		return _concesionarioVehiculoLocalService.
			findByConcesionarioIdVehiculoId(concesionarioId, vehiculoId);
	}

	@Override
	public java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			findByVehiculoId(long vehiculoId) {

		return _concesionarioVehiculoLocalService.findByVehiculoId(vehiculoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _concesionarioVehiculoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the concesionario vehiculo with the primary key.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws PortalException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
			getConcesionarioVehiculo(long concesionarioVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioVehiculoLocalService.getConcesionarioVehiculo(
			concesionarioVehiculoId);
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
	@Override
	public java.util.List
		<com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo>
			getConcesionarioVehiculos(int start, int end) {

		return _concesionarioVehiculoLocalService.getConcesionarioVehiculos(
			start, end);
	}

	/**
	 * Returns the number of concesionario vehiculos.
	 *
	 * @return the number of concesionario vehiculos
	 */
	@Override
	public int getConcesionarioVehiculosCount() {
		return _concesionarioVehiculoLocalService.
			getConcesionarioVehiculosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _concesionarioVehiculoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _concesionarioVehiculoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _concesionarioVehiculoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the concesionario vehiculo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 * @return the concesionario vehiculo that was updated
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
		updateConcesionarioVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo
				concesionarioVehiculo) {

		return _concesionarioVehiculoLocalService.updateConcesionarioVehiculo(
			concesionarioVehiculo);
	}

	@Override
	public ConcesionarioVehiculoLocalService getWrappedService() {
		return _concesionarioVehiculoLocalService;
	}

	@Override
	public void setWrappedService(
		ConcesionarioVehiculoLocalService concesionarioVehiculoLocalService) {

		_concesionarioVehiculoLocalService = concesionarioVehiculoLocalService;
	}

	private ConcesionarioVehiculoLocalService
		_concesionarioVehiculoLocalService;

}