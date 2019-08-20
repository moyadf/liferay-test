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
 * Provides a wrapper for {@link ClienteVehiculoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClienteVehiculoLocalService
 * @generated
 */
@ProviderType
public class ClienteVehiculoLocalServiceWrapper
	implements ClienteVehiculoLocalService,
			   ServiceWrapper<ClienteVehiculoLocalService> {

	public ClienteVehiculoLocalServiceWrapper(
		ClienteVehiculoLocalService clienteVehiculoLocalService) {

		_clienteVehiculoLocalService = clienteVehiculoLocalService;
	}

	/**
	 * Adds the cliente vehiculo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was added
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		addClienteVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
				clienteVehiculo) {

		return _clienteVehiculoLocalService.addClienteVehiculo(clienteVehiculo);
	}

	/**
	 * Creates a new cliente vehiculo with the primary key. Does not add the cliente vehiculo to the database.
	 *
	 * @param clienteVehiculoId the primary key for the new cliente vehiculo
	 * @return the new cliente vehiculo
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		createClienteVehiculo(long clienteVehiculoId) {

		return _clienteVehiculoLocalService.createClienteVehiculo(
			clienteVehiculoId);
	}

	/**
	 * Deletes the cliente vehiculo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		deleteClienteVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
				clienteVehiculo) {

		return _clienteVehiculoLocalService.deleteClienteVehiculo(
			clienteVehiculo);
	}

	/**
	 * Deletes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws PortalException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
			deleteClienteVehiculo(long clienteVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clienteVehiculoLocalService.deleteClienteVehiculo(
			clienteVehiculoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clienteVehiculoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clienteVehiculoLocalService.dynamicQuery();
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

		return _clienteVehiculoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _clienteVehiculoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _clienteVehiculoLocalService.dynamicQuery(
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

		return _clienteVehiculoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clienteVehiculoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		fetchClienteVehiculo(long clienteVehiculoId) {

		return _clienteVehiculoLocalService.fetchClienteVehiculo(
			clienteVehiculoId);
	}

	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo>
		findByClienteId(long clienteId) {

		return _clienteVehiculoLocalService.findByClienteId(clienteId);
	}

	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		findByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId) {

		return _clienteVehiculoLocalService.
			findByClienteIdConcesionarioIdVehiculoId(
				clienteId, concesionarioId, vehiculoId);
	}

	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo>
		findByVehiculoId(long vehiculoId) {

		return _clienteVehiculoLocalService.findByVehiculoId(vehiculoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clienteVehiculoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cliente vehiculo with the primary key.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws PortalException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
			getClienteVehiculo(long clienteVehiculoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clienteVehiculoLocalService.getClienteVehiculo(
			clienteVehiculoId);
	}

	/**
	 * Returns a range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of cliente vehiculos
	 */
	@Override
	public java.util.List<com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo>
		getClienteVehiculos(int start, int end) {

		return _clienteVehiculoLocalService.getClienteVehiculos(start, end);
	}

	/**
	 * Returns the number of cliente vehiculos.
	 *
	 * @return the number of cliente vehiculos
	 */
	@Override
	public int getClienteVehiculosCount() {
		return _clienteVehiculoLocalService.getClienteVehiculosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clienteVehiculoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clienteVehiculoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clienteVehiculoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cliente vehiculo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was updated
	 */
	@Override
	public com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
		updateClienteVehiculo(
			com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo
				clienteVehiculo) {

		return _clienteVehiculoLocalService.updateClienteVehiculo(
			clienteVehiculo);
	}

	@Override
	public ClienteVehiculoLocalService getWrappedService() {
		return _clienteVehiculoLocalService;
	}

	@Override
	public void setWrappedService(
		ClienteVehiculoLocalService clienteVehiculoLocalService) {

		_clienteVehiculoLocalService = clienteVehiculoLocalService;
	}

	private ClienteVehiculoLocalService _clienteVehiculoLocalService;

}