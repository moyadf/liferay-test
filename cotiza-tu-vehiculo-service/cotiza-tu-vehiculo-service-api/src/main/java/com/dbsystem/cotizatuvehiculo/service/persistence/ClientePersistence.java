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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException;
import com.dbsystem.cotizatuvehiculo.model.Cliente;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cliente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteUtil
 * @generated
 */
@ProviderType
public interface ClientePersistence extends BasePersistence<Cliente> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClienteUtil} to access the cliente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente
	 * @throws NoSuchClienteException if a matching cliente could not be found
	 */
	public Cliente findByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws NoSuchClienteException;

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	public Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento);

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	public Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento, boolean retrieveFromCache);

	/**
	 * Removes the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; from the database.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the cliente that was removed
	 */
	public Cliente removeByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws NoSuchClienteException;

	/**
	 * Returns the number of clientes where tipoDocumento = &#63; and numeroDocumento = &#63;.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the number of matching clientes
	 */
	public int countByIdentificacion(
		long tipoDocumento, String numeroDocumento);

	/**
	 * Caches the cliente in the entity cache if it is enabled.
	 *
	 * @param cliente the cliente
	 */
	public void cacheResult(Cliente cliente);

	/**
	 * Caches the clientes in the entity cache if it is enabled.
	 *
	 * @param clientes the clientes
	 */
	public void cacheResult(java.util.List<Cliente> clientes);

	/**
	 * Creates a new cliente with the primary key. Does not add the cliente to the database.
	 *
	 * @param clienteId the primary key for the new cliente
	 * @return the new cliente
	 */
	public Cliente create(long clienteId);

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	public Cliente remove(long clienteId) throws NoSuchClienteException;

	public Cliente updateImpl(Cliente cliente);

	/**
	 * Returns the cliente with the primary key or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	public Cliente findByPrimaryKey(long clienteId)
		throws NoSuchClienteException;

	/**
	 * Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	 */
	public Cliente fetchByPrimaryKey(long clienteId);

	/**
	 * Returns all the clientes.
	 *
	 * @return the clientes
	 */
	public java.util.List<Cliente> findAll();

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
	public java.util.List<Cliente> findAll(int start, int end);

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
	public java.util.List<Cliente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cliente>
			orderByComparator);

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
	public java.util.List<Cliente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cliente>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the clientes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clientes.
	 *
	 * @return the number of clientes
	 */
	public int countAll();

}