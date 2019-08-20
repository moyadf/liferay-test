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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchConcesionarioVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the concesionario vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioVehiculoUtil
 * @generated
 */
@ProviderType
public interface ConcesionarioVehiculoPersistence
	extends BasePersistence<ConcesionarioVehiculo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConcesionarioVehiculoUtil} to access the concesionario vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId);

	/**
	 * Returns a range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end);

	/**
	 * Returns an ordered range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param concesionarioId the concesionario ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo findByConcesionarioId_First(
			long concesionarioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByConcesionarioId_First(
		long concesionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo findByConcesionarioId_Last(
			long concesionarioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByConcesionarioId_Last(
		long concesionarioId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public ConcesionarioVehiculo[] findByConcesionarioId_PrevAndNext(
			long concesionarioVehiculoId, long concesionarioId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Removes all the concesionario vehiculos where concesionarioId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 */
	public void removeByConcesionarioId(long concesionarioId);

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the number of matching concesionario vehiculos
	 */
	public int countByConcesionarioId(long concesionarioId);

	/**
	 * Returns all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId);

	/**
	 * Returns a range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end);

	/**
	 * Returns an ordered range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo findByVehiculoId_First(
			long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByVehiculoId_First(
		long vehiculoId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo findByVehiculoId_Last(
			long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByVehiculoId_Last(
		long vehiculoId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public ConcesionarioVehiculo[] findByVehiculoId_PrevAndNext(
			long concesionarioVehiculoId, long vehiculoId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Removes all the concesionario vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	public void removeByVehiculoId(long vehiculoId);

	/**
	 * Returns the number of concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	public int countByVehiculoId(long vehiculoId);

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo findByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId);

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	public ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId, boolean retrieveFromCache);

	/**
	 * Removes the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the concesionario vehiculo that was removed
	 */
	public ConcesionarioVehiculo removeByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	public int countByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId);

	/**
	 * Caches the concesionario vehiculo in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 */
	public void cacheResult(ConcesionarioVehiculo concesionarioVehiculo);

	/**
	 * Caches the concesionario vehiculos in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculos the concesionario vehiculos
	 */
	public void cacheResult(
		java.util.List<ConcesionarioVehiculo> concesionarioVehiculos);

	/**
	 * Creates a new concesionario vehiculo with the primary key. Does not add the concesionario vehiculo to the database.
	 *
	 * @param concesionarioVehiculoId the primary key for the new concesionario vehiculo
	 * @return the new concesionario vehiculo
	 */
	public ConcesionarioVehiculo create(long concesionarioVehiculoId);

	/**
	 * Removes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public ConcesionarioVehiculo remove(long concesionarioVehiculoId)
		throws NoSuchConcesionarioVehiculoException;

	public ConcesionarioVehiculo updateImpl(
		ConcesionarioVehiculo concesionarioVehiculo);

	/**
	 * Returns the concesionario vehiculo with the primary key or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	public ConcesionarioVehiculo findByPrimaryKey(long concesionarioVehiculoId)
		throws NoSuchConcesionarioVehiculoException;

	/**
	 * Returns the concesionario vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo, or <code>null</code> if a concesionario vehiculo with the primary key could not be found
	 */
	public ConcesionarioVehiculo fetchByPrimaryKey(
		long concesionarioVehiculoId);

	/**
	 * Returns all the concesionario vehiculos.
	 *
	 * @return the concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findAll();

	/**
	 * Returns a range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @return the range of concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionario vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionario vehiculos
	 * @param end the upper bound of the range of concesionario vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of concesionario vehiculos
	 */
	public java.util.List<ConcesionarioVehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcesionarioVehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the concesionario vehiculos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of concesionario vehiculos.
	 *
	 * @return the number of concesionario vehiculos
	 */
	public int countAll();

}