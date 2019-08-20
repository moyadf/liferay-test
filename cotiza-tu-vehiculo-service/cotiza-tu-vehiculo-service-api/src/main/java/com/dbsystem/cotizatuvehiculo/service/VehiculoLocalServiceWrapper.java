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
 * Provides a wrapper for {@link VehiculoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VehiculoLocalService
 * @generated
 */
@ProviderType
public class VehiculoLocalServiceWrapper
	implements VehiculoLocalService, ServiceWrapper<VehiculoLocalService> {

	public VehiculoLocalServiceWrapper(
		VehiculoLocalService vehiculoLocalService) {

		_vehiculoLocalService = vehiculoLocalService;
	}

	/**
	 * Adds the vehiculo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculo the vehiculo
	 * @return the vehiculo that was added
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo addVehiculo(
		com.dbsystem.cotizatuvehiculo.model.Vehiculo vehiculo) {

		return _vehiculoLocalService.addVehiculo(vehiculo);
	}

	/**
	 * Creates a new vehiculo with the primary key. Does not add the vehiculo to the database.
	 *
	 * @param vehiculoId the primary key for the new vehiculo
	 * @return the new vehiculo
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo createVehiculo(
		long vehiculoId) {

		return _vehiculoLocalService.createVehiculo(vehiculoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vehiculoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo that was removed
	 * @throws PortalException if a vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo deleteVehiculo(
			long vehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vehiculoLocalService.deleteVehiculo(vehiculoId);
	}

	/**
	 * Deletes the vehiculo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculo the vehiculo
	 * @return the vehiculo that was removed
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo deleteVehiculo(
		com.dbsystem.cotizatuvehiculo.model.Vehiculo vehiculo) {

		return _vehiculoLocalService.deleteVehiculo(vehiculo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vehiculoLocalService.dynamicQuery();
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

		return _vehiculoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _vehiculoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _vehiculoLocalService.dynamicQuery(
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

		return _vehiculoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _vehiculoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo fetchVehiculo(
		long vehiculoId) {

		return _vehiculoLocalService.fetchVehiculo(vehiculoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vehiculoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vehiculoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vehiculoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vehiculoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vehiculo with the primary key.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo
	 * @throws PortalException if a vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo getVehiculo(
			long vehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vehiculoLocalService.getVehiculo(vehiculoId);
	}

	/**
	 * Returns a range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @return the range of vehiculos
	 */
	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.Vehiculo>
		getVehiculos(int start, int end) {

		return _vehiculoLocalService.getVehiculos(start, end);
	}

	/**
	 * Returns the number of vehiculos.
	 *
	 * @return the number of vehiculos
	 */
	@Override
	public int getVehiculosCount() {
		return _vehiculoLocalService.getVehiculosCount();
	}

	/**
	 * Updates the vehiculo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculo the vehiculo
	 * @return the vehiculo that was updated
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.Vehiculo updateVehiculo(
		com.dbsystem.cotizatuvehiculo.model.Vehiculo vehiculo) {

		return _vehiculoLocalService.updateVehiculo(vehiculo);
	}

	@Override
	public VehiculoLocalService getWrappedService() {
		return _vehiculoLocalService;
	}

	@Override
	public void setWrappedService(VehiculoLocalService vehiculoLocalService) {
		_vehiculoLocalService = vehiculoLocalService;
	}

	private VehiculoLocalService _vehiculoLocalService;

}