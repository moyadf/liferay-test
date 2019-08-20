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

import com.dbsystem.cotizatuvehiculo.model.Cliente;

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
 * The persistence utility for the cliente service. This utility wraps <code>com.dbsystem.cotizatuvehiculo.service.persistence.impl.ClientePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientePersistence
 * @generated
 */
@ProviderType
public class ClienteUtil {

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
	public static void clearCache(Cliente cliente) {
		getPersistence().clearCache(cliente);
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
	public static Map<Serializable, Cliente> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cliente> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cliente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cliente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cliente> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cliente update(Cliente cliente) {
		return getPersistence().update(cliente);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cliente update(
		Cliente cliente, ServiceContext serviceContext) {

		return getPersistence().update(cliente, serviceContext);
	}

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente
	 * @throws NoSuchClienteException if a matching cliente could not be found
	 */
	public static Cliente findByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException {

		return getPersistence().findByIdentificacion(
			tipoDocumento, numeroDocumento);
	}

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	public static Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento) {

		return getPersistence().fetchByIdentificacion(
			tipoDocumento, numeroDocumento);
	}

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	public static Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento, boolean retrieveFromCache) {

		return getPersistence().fetchByIdentificacion(
			tipoDocumento, numeroDocumento, retrieveFromCache);
	}

	/**
	 * Removes the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; from the database.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the cliente that was removed
	 */
	public static Cliente removeByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException {

		return getPersistence().removeByIdentificacion(
			tipoDocumento, numeroDocumento);
	}

	/**
	 * Returns the number of clientes where tipoDocumento = &#63; and numeroDocumento = &#63;.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the number of matching clientes
	 */
	public static int countByIdentificacion(
		long tipoDocumento, String numeroDocumento) {

		return getPersistence().countByIdentificacion(
			tipoDocumento, numeroDocumento);
	}

	/**
	 * Caches the cliente in the entity cache if it is enabled.
	 *
	 * @param cliente the cliente
	 */
	public static void cacheResult(Cliente cliente) {
		getPersistence().cacheResult(cliente);
	}

	/**
	 * Caches the clientes in the entity cache if it is enabled.
	 *
	 * @param clientes the clientes
	 */
	public static void cacheResult(List<Cliente> clientes) {
		getPersistence().cacheResult(clientes);
	}

	/**
	 * Creates a new cliente with the primary key. Does not add the cliente to the database.
	 *
	 * @param clienteId the primary key for the new cliente
	 * @return the new cliente
	 */
	public static Cliente create(long clienteId) {
		return getPersistence().create(clienteId);
	}

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	public static Cliente remove(long clienteId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException {

		return getPersistence().remove(clienteId);
	}

	public static Cliente updateImpl(Cliente cliente) {
		return getPersistence().updateImpl(cliente);
	}

	/**
	 * Returns the cliente with the primary key or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	public static Cliente findByPrimaryKey(long clienteId)
		throws com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException {

		return getPersistence().findByPrimaryKey(clienteId);
	}

	/**
	 * Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	 */
	public static Cliente fetchByPrimaryKey(long clienteId) {
		return getPersistence().fetchByPrimaryKey(clienteId);
	}

	/**
	 * Returns all the clientes.
	 *
	 * @return the clientes
	 */
	public static List<Cliente> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of clientes
	 */
	public static List<Cliente> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clientes
	 */
	public static List<Cliente> findAll(
		int start, int end, OrderByComparator<Cliente> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of clientes
	 */
	public static List<Cliente> findAll(
		int start, int end, OrderByComparator<Cliente> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the clientes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clientes.
	 *
	 * @return the number of clientes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClientePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientePersistence, ClientePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClientePersistence.class);

		ServiceTracker<ClientePersistence, ClientePersistence> serviceTracker =
			new ServiceTracker<ClientePersistence, ClientePersistence>(
				bundle.getBundleContext(), ClientePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}