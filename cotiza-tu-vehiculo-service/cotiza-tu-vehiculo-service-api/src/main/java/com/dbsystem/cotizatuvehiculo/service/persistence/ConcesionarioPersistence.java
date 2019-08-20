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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchConcesionarioException;
import com.dbsystem.cotizatuvehiculo.model.Concesionario;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the concesionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcesionarioUtil
 * @generated
 */
@ProviderType
public interface ConcesionarioPersistence
	extends BasePersistence<Concesionario> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConcesionarioUtil} to access the concesionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadId(long ciudadId);

	/**
	 * Returns a range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end);

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public Concesionario findByCiudadId_First(
			long ciudadId,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public Concesionario fetchByCiudadId_First(
		long ciudadId,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public Concesionario findByCiudadId_Last(
			long ciudadId,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public Concesionario fetchByCiudadId_Last(
		long ciudadId,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns the concesionarios before and after the current concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param concesionarioId the primary key of the current concesionario
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public Concesionario[] findByCiudadId_PrevAndNext(
			long concesionarioId, long ciudadId,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Removes all the concesionarios where ciudadId = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 */
	public void removeByCiudadId(long ciudadId);

	/**
	 * Returns the number of concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the number of matching concesionarios
	 */
	public int countByCiudadId(long ciudadId);

	/**
	 * Returns all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado);

	/**
	 * Returns a range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end);

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching concesionarios
	 */
	public java.util.List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public Concesionario findByCiudadIdEstado_First(
			long ciudadId, boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public Concesionario fetchByCiudadIdEstado_First(
		long ciudadId, boolean estado,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	public Concesionario findByCiudadIdEstado_Last(
			long ciudadId, boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	public Concesionario fetchByCiudadIdEstado_Last(
		long ciudadId, boolean estado,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns the concesionarios before and after the current concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param concesionarioId the primary key of the current concesionario
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public Concesionario[] findByCiudadIdEstado_PrevAndNext(
			long concesionarioId, long ciudadId, boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
				orderByComparator)
		throws NoSuchConcesionarioException;

	/**
	 * Removes all the concesionarios where ciudadId = &#63; and estado = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 */
	public void removeByCiudadIdEstado(long ciudadId, boolean estado);

	/**
	 * Returns the number of concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the number of matching concesionarios
	 */
	public int countByCiudadIdEstado(long ciudadId, boolean estado);

	/**
	 * Caches the concesionario in the entity cache if it is enabled.
	 *
	 * @param concesionario the concesionario
	 */
	public void cacheResult(Concesionario concesionario);

	/**
	 * Caches the concesionarios in the entity cache if it is enabled.
	 *
	 * @param concesionarios the concesionarios
	 */
	public void cacheResult(java.util.List<Concesionario> concesionarios);

	/**
	 * Creates a new concesionario with the primary key. Does not add the concesionario to the database.
	 *
	 * @param concesionarioId the primary key for the new concesionario
	 * @return the new concesionario
	 */
	public Concesionario create(long concesionarioId);

	/**
	 * Removes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public Concesionario remove(long concesionarioId)
		throws NoSuchConcesionarioException;

	public Concesionario updateImpl(Concesionario concesionario);

	/**
	 * Returns the concesionario with the primary key or throws a <code>NoSuchConcesionarioException</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	public Concesionario findByPrimaryKey(long concesionarioId)
		throws NoSuchConcesionarioException;

	/**
	 * Returns the concesionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario, or <code>null</code> if a concesionario with the primary key could not be found
	 */
	public Concesionario fetchByPrimaryKey(long concesionarioId);

	/**
	 * Returns all the concesionarios.
	 *
	 * @return the concesionarios
	 */
	public java.util.List<Concesionario> findAll();

	/**
	 * Returns a range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @return the range of concesionarios
	 */
	public java.util.List<Concesionario> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concesionarios
	 */
	public java.util.List<Concesionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator);

	/**
	 * Returns an ordered range of all the concesionarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConcesionarioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of concesionarios
	 * @param end the upper bound of the range of concesionarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of concesionarios
	 */
	public java.util.List<Concesionario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Concesionario>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the concesionarios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of concesionarios.
	 *
	 * @return the number of concesionarios
	 */
	public int countAll();

}