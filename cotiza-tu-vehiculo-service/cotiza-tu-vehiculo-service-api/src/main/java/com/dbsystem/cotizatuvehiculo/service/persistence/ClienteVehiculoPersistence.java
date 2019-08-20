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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cliente vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteVehiculoUtil
 * @generated
 */
@ProviderType
public interface ClienteVehiculoPersistence
	extends BasePersistence<ClienteVehiculo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClienteVehiculoUtil} to access the cliente vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo findByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId);

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId,
		boolean retrieveFromCache);

	/**
	 * Removes the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the cliente vehiculo that was removed
	 */
	public ClienteVehiculo removeByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	public int countByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId);

	/**
	 * Returns all the cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByClienteId(long clienteId);

	/**
	 * Returns a range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end);

	/**
	 * Returns an ordered range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cliente vehiculos where clienteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clienteId the cliente ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo findByClienteId_First(
			long clienteId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByClienteId_First(
		long clienteId,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo findByClienteId_Last(
			long clienteId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByClienteId_Last(
		long clienteId,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public ClienteVehiculo[] findByClienteId_PrevAndNext(
			long clienteVehiculoId, long clienteId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Removes all the cliente vehiculos where clienteId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 */
	public void removeByClienteId(long clienteId);

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the number of matching cliente vehiculos
	 */
	public int countByClienteId(long clienteId);

	/**
	 * Returns all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByVehiculoId(long vehiculoId);

	/**
	 * Returns a range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end);

	/**
	 * Returns an ordered range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo findByVehiculoId_First(
			long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByVehiculoId_First(
		long vehiculoId,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo findByVehiculoId_Last(
			long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	public ClienteVehiculo fetchByVehiculoId_Last(
		long vehiculoId,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public ClienteVehiculo[] findByVehiculoId_PrevAndNext(
			long clienteVehiculoId, long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
				orderByComparator)
		throws NoSuchClienteVehiculoException;

	/**
	 * Removes all the cliente vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	public void removeByVehiculoId(long vehiculoId);

	/**
	 * Returns the number of cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	public int countByVehiculoId(long vehiculoId);

	/**
	 * Caches the cliente vehiculo in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 */
	public void cacheResult(ClienteVehiculo clienteVehiculo);

	/**
	 * Caches the cliente vehiculos in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculos the cliente vehiculos
	 */
	public void cacheResult(java.util.List<ClienteVehiculo> clienteVehiculos);

	/**
	 * Creates a new cliente vehiculo with the primary key. Does not add the cliente vehiculo to the database.
	 *
	 * @param clienteVehiculoId the primary key for the new cliente vehiculo
	 * @return the new cliente vehiculo
	 */
	public ClienteVehiculo create(long clienteVehiculoId);

	/**
	 * Removes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public ClienteVehiculo remove(long clienteVehiculoId)
		throws NoSuchClienteVehiculoException;

	public ClienteVehiculo updateImpl(ClienteVehiculo clienteVehiculo);

	/**
	 * Returns the cliente vehiculo with the primary key or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	public ClienteVehiculo findByPrimaryKey(long clienteVehiculoId)
		throws NoSuchClienteVehiculoException;

	/**
	 * Returns the cliente vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo, or <code>null</code> if a cliente vehiculo with the primary key could not be found
	 */
	public ClienteVehiculo fetchByPrimaryKey(long clienteVehiculoId);

	/**
	 * Returns all the cliente vehiculos.
	 *
	 * @return the cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findAll();

	/**
	 * Returns a range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cliente vehiculos
	 */
	public java.util.List<ClienteVehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClienteVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the cliente vehiculos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cliente vehiculos.
	 *
	 * @return the number of cliente vehiculos
	 */
	public int countAll();

}