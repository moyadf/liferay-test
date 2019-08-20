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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.Vehiculo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VehiculoUtil
 * @generated
 */
@ProviderType
public interface VehiculoPersistence extends BasePersistence<Vehiculo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VehiculoUtil} to access the vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the vehiculo in the entity cache if it is enabled.
	 *
	 * @param vehiculo the vehiculo
	 */
	public void cacheResult(Vehiculo vehiculo);

	/**
	 * Caches the vehiculos in the entity cache if it is enabled.
	 *
	 * @param vehiculos the vehiculos
	 */
	public void cacheResult(java.util.List<Vehiculo> vehiculos);

	/**
	 * Creates a new vehiculo with the primary key. Does not add the vehiculo to the database.
	 *
	 * @param vehiculoId the primary key for the new vehiculo
	 * @return the new vehiculo
	 */
	public Vehiculo create(long vehiculoId);

	/**
	 * Removes the vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo that was removed
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	public Vehiculo remove(long vehiculoId) throws NoSuchVehiculoException;

	public Vehiculo updateImpl(Vehiculo vehiculo);

	/**
	 * Returns the vehiculo with the primary key or throws a <code>NoSuchVehiculoException</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	public Vehiculo findByPrimaryKey(long vehiculoId)
		throws NoSuchVehiculoException;

	/**
	 * Returns the vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo, or <code>null</code> if a vehiculo with the primary key could not be found
	 */
	public Vehiculo fetchByPrimaryKey(long vehiculoId);

	/**
	 * Returns all the vehiculos.
	 *
	 * @return the vehiculos
	 */
	public java.util.List<Vehiculo> findAll();

	/**
	 * Returns a range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @return the range of vehiculos
	 */
	public java.util.List<Vehiculo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vehiculos
	 */
	public java.util.List<Vehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vehiculo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehiculos
	 * @param end the upper bound of the range of vehiculos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vehiculos
	 */
	public java.util.List<Vehiculo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vehiculo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the vehiculos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vehiculos.
	 *
	 * @return the number of vehiculos
	 */
	public int countAll();

}