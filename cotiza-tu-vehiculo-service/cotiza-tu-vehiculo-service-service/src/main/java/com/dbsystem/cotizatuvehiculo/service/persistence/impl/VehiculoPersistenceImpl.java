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

package com.dbsystem.cotizatuvehiculo.service.persistence.impl;

import com.dbsystem.cotizatuvehiculo.exception.NoSuchVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.Vehiculo;
import com.dbsystem.cotizatuvehiculo.model.impl.VehiculoImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.VehiculoModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.VehiculoPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.impl.constants.dbsystemPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VehiculoPersistence.class)
@ProviderType
public class VehiculoPersistenceImpl
	extends BasePersistenceImpl<Vehiculo> implements VehiculoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VehiculoUtil</code> to access the vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VehiculoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public VehiculoPersistenceImpl() {
		setModelClass(Vehiculo.class);

		setModelImplClass(VehiculoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the vehiculo in the entity cache if it is enabled.
	 *
	 * @param vehiculo the vehiculo
	 */
	@Override
	public void cacheResult(Vehiculo vehiculo) {
		entityCache.putResult(
			entityCacheEnabled, VehiculoImpl.class, vehiculo.getPrimaryKey(),
			vehiculo);

		vehiculo.resetOriginalValues();
	}

	/**
	 * Caches the vehiculos in the entity cache if it is enabled.
	 *
	 * @param vehiculos the vehiculos
	 */
	@Override
	public void cacheResult(List<Vehiculo> vehiculos) {
		for (Vehiculo vehiculo : vehiculos) {
			if (entityCache.getResult(
					entityCacheEnabled, VehiculoImpl.class,
					vehiculo.getPrimaryKey()) == null) {

				cacheResult(vehiculo);
			}
			else {
				vehiculo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vehiculos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VehiculoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vehiculo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vehiculo vehiculo) {
		entityCache.removeResult(
			entityCacheEnabled, VehiculoImpl.class, vehiculo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vehiculo> vehiculos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vehiculo vehiculo : vehiculos) {
			entityCache.removeResult(
				entityCacheEnabled, VehiculoImpl.class,
				vehiculo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vehiculo with the primary key. Does not add the vehiculo to the database.
	 *
	 * @param vehiculoId the primary key for the new vehiculo
	 * @return the new vehiculo
	 */
	@Override
	public Vehiculo create(long vehiculoId) {
		Vehiculo vehiculo = new VehiculoImpl();

		vehiculo.setNew(true);
		vehiculo.setPrimaryKey(vehiculoId);

		return vehiculo;
	}

	/**
	 * Removes the vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo that was removed
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	@Override
	public Vehiculo remove(long vehiculoId) throws NoSuchVehiculoException {
		return remove((Serializable)vehiculoId);
	}

	/**
	 * Removes the vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vehiculo
	 * @return the vehiculo that was removed
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	@Override
	public Vehiculo remove(Serializable primaryKey)
		throws NoSuchVehiculoException {

		Session session = null;

		try {
			session = openSession();

			Vehiculo vehiculo = (Vehiculo)session.get(
				VehiculoImpl.class, primaryKey);

			if (vehiculo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVehiculoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vehiculo);
		}
		catch (NoSuchVehiculoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Vehiculo removeImpl(Vehiculo vehiculo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vehiculo)) {
				vehiculo = (Vehiculo)session.get(
					VehiculoImpl.class, vehiculo.getPrimaryKeyObj());
			}

			if (vehiculo != null) {
				session.delete(vehiculo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vehiculo != null) {
			clearCache(vehiculo);
		}

		return vehiculo;
	}

	@Override
	public Vehiculo updateImpl(Vehiculo vehiculo) {
		boolean isNew = vehiculo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vehiculo.isNew()) {
				session.save(vehiculo);

				vehiculo.setNew(false);
			}
			else {
				vehiculo = (Vehiculo)session.merge(vehiculo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, VehiculoImpl.class, vehiculo.getPrimaryKey(),
			vehiculo, false);

		vehiculo.resetOriginalValues();

		return vehiculo;
	}

	/**
	 * Returns the vehiculo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vehiculo
	 * @return the vehiculo
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	@Override
	public Vehiculo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVehiculoException {

		Vehiculo vehiculo = fetchByPrimaryKey(primaryKey);

		if (vehiculo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVehiculoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vehiculo;
	}

	/**
	 * Returns the vehiculo with the primary key or throws a <code>NoSuchVehiculoException</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo
	 * @throws NoSuchVehiculoException if a vehiculo with the primary key could not be found
	 */
	@Override
	public Vehiculo findByPrimaryKey(long vehiculoId)
		throws NoSuchVehiculoException {

		return findByPrimaryKey((Serializable)vehiculoId);
	}

	/**
	 * Returns the vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vehiculoId the primary key of the vehiculo
	 * @return the vehiculo, or <code>null</code> if a vehiculo with the primary key could not be found
	 */
	@Override
	public Vehiculo fetchByPrimaryKey(long vehiculoId) {
		return fetchByPrimaryKey((Serializable)vehiculoId);
	}

	/**
	 * Returns all the vehiculos.
	 *
	 * @return the vehiculos
	 */
	@Override
	public List<Vehiculo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Vehiculo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Vehiculo> findAll(
		int start, int end, OrderByComparator<Vehiculo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Vehiculo> findAll(
		int start, int end, OrderByComparator<Vehiculo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Vehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<Vehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VEHICULO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VEHICULO;

				if (pagination) {
					sql = sql.concat(VehiculoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vehiculo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vehiculos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vehiculo vehiculo : findAll()) {
			remove(vehiculo);
		}
	}

	/**
	 * Returns the number of vehiculos.
	 *
	 * @return the number of vehiculos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VEHICULO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "vehiculoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VEHICULO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VehiculoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vehiculo persistence.
	 */
	@Activate
	public void activate() {
		VehiculoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		VehiculoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(VehiculoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = dbsystemPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.Vehiculo"),
			true);
	}

	@Override
	@Reference(
		target = dbsystemPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = dbsystemPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VEHICULO =
		"SELECT vehiculo FROM Vehiculo vehiculo";

	private static final String _SQL_COUNT_VEHICULO =
		"SELECT COUNT(vehiculo) FROM Vehiculo vehiculo";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vehiculo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Vehiculo exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		VehiculoPersistenceImpl.class);

}