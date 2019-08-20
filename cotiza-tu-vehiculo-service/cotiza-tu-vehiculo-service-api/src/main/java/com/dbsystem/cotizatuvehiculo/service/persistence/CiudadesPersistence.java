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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException;
import com.dbsystem.cotizatuvehiculo.model.Ciudades;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ciudades service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CiudadesUtil
 * @generated
 */
@ProviderType
public interface CiudadesPersistence extends BasePersistence<Ciudades> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CiudadesUtil} to access the ciudades persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the matching ciudadeses
	 */
	public java.util.List<Ciudades> findByEstado(boolean estado);

	/**
	 * Returns a range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of matching ciudadeses
	 */
	public java.util.List<Ciudades> findByEstado(
		boolean estado, int start, int end);

	/**
	 * Returns an ordered range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ciudadeses
	 */
	public java.util.List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ciudadeses where estado = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param estado the estado
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ciudadeses
	 */
	public java.util.List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	public Ciudades findByEstado_First(
			boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
				orderByComparator)
		throws NoSuchCiudadesException;

	/**
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	public Ciudades fetchByEstado_First(
		boolean estado,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator);

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	public Ciudades findByEstado_Last(
			boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
				orderByComparator)
		throws NoSuchCiudadesException;

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	public Ciudades fetchByEstado_Last(
		boolean estado,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator);

	/**
	 * Returns the ciudadeses before and after the current ciudades in the ordered set where estado = &#63;.
	 *
	 * @param ciudadId the primary key of the current ciudades
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public Ciudades[] findByEstado_PrevAndNext(
			long ciudadId, boolean estado,
			com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
				orderByComparator)
		throws NoSuchCiudadesException;

	/**
	 * Removes all the ciudadeses where estado = &#63; from the database.
	 *
	 * @param estado the estado
	 */
	public void removeByEstado(boolean estado);

	/**
	 * Returns the number of ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the number of matching ciudadeses
	 */
	public int countByEstado(boolean estado);

	/**
	 * Caches the ciudades in the entity cache if it is enabled.
	 *
	 * @param ciudades the ciudades
	 */
	public void cacheResult(Ciudades ciudades);

	/**
	 * Caches the ciudadeses in the entity cache if it is enabled.
	 *
	 * @param ciudadeses the ciudadeses
	 */
	public void cacheResult(java.util.List<Ciudades> ciudadeses);

	/**
	 * Creates a new ciudades with the primary key. Does not add the ciudades to the database.
	 *
	 * @param ciudadId the primary key for the new ciudades
	 * @return the new ciudades
	 */
	public Ciudades create(long ciudadId);

	/**
	 * Removes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public Ciudades remove(long ciudadId) throws NoSuchCiudadesException;

	public Ciudades updateImpl(Ciudades ciudades);

	/**
	 * Returns the ciudades with the primary key or throws a <code>NoSuchCiudadesException</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	public Ciudades findByPrimaryKey(long ciudadId)
		throws NoSuchCiudadesException;

	/**
	 * Returns the ciudades with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades, or <code>null</code> if a ciudades with the primary key could not be found
	 */
	public Ciudades fetchByPrimaryKey(long ciudadId);

	/**
	 * Returns all the ciudadeses.
	 *
	 * @return the ciudadeses
	 */
	public java.util.List<Ciudades> findAll();

	/**
	 * Returns a range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of ciudadeses
	 */
	public java.util.List<Ciudades> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ciudadeses
	 */
	public java.util.List<Ciudades> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ciudadeses
	 */
	public java.util.List<Ciudades> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ciudades>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ciudadeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ciudadeses.
	 *
	 * @return the number of ciudadeses
	 */
	public int countAll();

}