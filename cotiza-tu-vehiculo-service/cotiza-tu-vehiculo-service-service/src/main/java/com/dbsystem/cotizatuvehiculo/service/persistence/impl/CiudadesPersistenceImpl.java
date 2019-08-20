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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchCiudadesException;
import com.dbsystem.cotizatuvehiculo.model.Ciudades;
import com.dbsystem.cotizatuvehiculo.model.impl.CiudadesImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.CiudadesPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.impl.constants.dbsystemPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the ciudades service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CiudadesPersistence.class)
@ProviderType
public class CiudadesPersistenceImpl
	extends BasePersistenceImpl<Ciudades> implements CiudadesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CiudadesUtil</code> to access the ciudades persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CiudadesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEstado;
	private FinderPath _finderPathWithoutPaginationFindByEstado;
	private FinderPath _finderPathCountByEstado;

	/**
	 * Returns all the ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the matching ciudadeses
	 */
	@Override
	public List<Ciudades> findByEstado(boolean estado) {
		return findByEstado(estado, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Ciudades> findByEstado(boolean estado, int start, int end) {
		return findByEstado(estado, start, end, null);
	}

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
	@Override
	public List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		OrderByComparator<Ciudades> orderByComparator) {

		return findByEstado(estado, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Ciudades> findByEstado(
		boolean estado, int start, int end,
		OrderByComparator<Ciudades> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEstado;
			finderArgs = new Object[] {estado};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEstado;
			finderArgs = new Object[] {estado, start, end, orderByComparator};
		}

		List<Ciudades> list = null;

		if (retrieveFromCache) {
			list = (List<Ciudades>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ciudades ciudades : list) {
					if ((estado != ciudades.isEstado())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CIUDADES_WHERE);

			query.append(_FINDER_COLUMN_ESTADO_ESTADO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CiudadesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(estado);

				if (!pagination) {
					list = (List<Ciudades>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Ciudades>)QueryUtil.list(
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
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	@Override
	public Ciudades findByEstado_First(
			boolean estado, OrderByComparator<Ciudades> orderByComparator)
		throws NoSuchCiudadesException {

		Ciudades ciudades = fetchByEstado_First(estado, orderByComparator);

		if (ciudades != null) {
			return ciudades;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estado=");
		msg.append(estado);

		msg.append("}");

		throw new NoSuchCiudadesException(msg.toString());
	}

	/**
	 * Returns the first ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	@Override
	public Ciudades fetchByEstado_First(
		boolean estado, OrderByComparator<Ciudades> orderByComparator) {

		List<Ciudades> list = findByEstado(estado, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades
	 * @throws NoSuchCiudadesException if a matching ciudades could not be found
	 */
	@Override
	public Ciudades findByEstado_Last(
			boolean estado, OrderByComparator<Ciudades> orderByComparator)
		throws NoSuchCiudadesException {

		Ciudades ciudades = fetchByEstado_Last(estado, orderByComparator);

		if (ciudades != null) {
			return ciudades;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estado=");
		msg.append(estado);

		msg.append("}");

		throw new NoSuchCiudadesException(msg.toString());
	}

	/**
	 * Returns the last ciudades in the ordered set where estado = &#63;.
	 *
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ciudades, or <code>null</code> if a matching ciudades could not be found
	 */
	@Override
	public Ciudades fetchByEstado_Last(
		boolean estado, OrderByComparator<Ciudades> orderByComparator) {

		int count = countByEstado(estado);

		if (count == 0) {
			return null;
		}

		List<Ciudades> list = findByEstado(
			estado, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ciudadeses before and after the current ciudades in the ordered set where estado = &#63;.
	 *
	 * @param ciudadId the primary key of the current ciudades
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades[] findByEstado_PrevAndNext(
			long ciudadId, boolean estado,
			OrderByComparator<Ciudades> orderByComparator)
		throws NoSuchCiudadesException {

		Ciudades ciudades = findByPrimaryKey(ciudadId);

		Session session = null;

		try {
			session = openSession();

			Ciudades[] array = new CiudadesImpl[3];

			array[0] = getByEstado_PrevAndNext(
				session, ciudades, estado, orderByComparator, true);

			array[1] = ciudades;

			array[2] = getByEstado_PrevAndNext(
				session, ciudades, estado, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ciudades getByEstado_PrevAndNext(
		Session session, Ciudades ciudades, boolean estado,
		OrderByComparator<Ciudades> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CIUDADES_WHERE);

		query.append(_FINDER_COLUMN_ESTADO_ESTADO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CiudadesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(estado);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ciudades)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Ciudades> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ciudadeses where estado = &#63; from the database.
	 *
	 * @param estado the estado
	 */
	@Override
	public void removeByEstado(boolean estado) {
		for (Ciudades ciudades :
				findByEstado(
					estado, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ciudades);
		}
	}

	/**
	 * Returns the number of ciudadeses where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the number of matching ciudadeses
	 */
	@Override
	public int countByEstado(boolean estado) {
		FinderPath finderPath = _finderPathCountByEstado;

		Object[] finderArgs = new Object[] {estado};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CIUDADES_WHERE);

			query.append(_FINDER_COLUMN_ESTADO_ESTADO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(estado);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ESTADO_ESTADO_2 =
		"ciudades.estado = ?";

	public CiudadesPersistenceImpl() {
		setModelClass(Ciudades.class);

		setModelImplClass(CiudadesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ciudades in the entity cache if it is enabled.
	 *
	 * @param ciudades the ciudades
	 */
	@Override
	public void cacheResult(Ciudades ciudades) {
		entityCache.putResult(
			entityCacheEnabled, CiudadesImpl.class, ciudades.getPrimaryKey(),
			ciudades);

		ciudades.resetOriginalValues();
	}

	/**
	 * Caches the ciudadeses in the entity cache if it is enabled.
	 *
	 * @param ciudadeses the ciudadeses
	 */
	@Override
	public void cacheResult(List<Ciudades> ciudadeses) {
		for (Ciudades ciudades : ciudadeses) {
			if (entityCache.getResult(
					entityCacheEnabled, CiudadesImpl.class,
					ciudades.getPrimaryKey()) == null) {

				cacheResult(ciudades);
			}
			else {
				ciudades.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ciudadeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CiudadesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ciudades.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ciudades ciudades) {
		entityCache.removeResult(
			entityCacheEnabled, CiudadesImpl.class, ciudades.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ciudades> ciudadeses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ciudades ciudades : ciudadeses) {
			entityCache.removeResult(
				entityCacheEnabled, CiudadesImpl.class,
				ciudades.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ciudades with the primary key. Does not add the ciudades to the database.
	 *
	 * @param ciudadId the primary key for the new ciudades
	 * @return the new ciudades
	 */
	@Override
	public Ciudades create(long ciudadId) {
		Ciudades ciudades = new CiudadesImpl();

		ciudades.setNew(true);
		ciudades.setPrimaryKey(ciudadId);

		return ciudades;
	}

	/**
	 * Removes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades remove(long ciudadId) throws NoSuchCiudadesException {
		return remove((Serializable)ciudadId);
	}

	/**
	 * Removes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades remove(Serializable primaryKey)
		throws NoSuchCiudadesException {

		Session session = null;

		try {
			session = openSession();

			Ciudades ciudades = (Ciudades)session.get(
				CiudadesImpl.class, primaryKey);

			if (ciudades == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCiudadesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ciudades);
		}
		catch (NoSuchCiudadesException nsee) {
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
	protected Ciudades removeImpl(Ciudades ciudades) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ciudades)) {
				ciudades = (Ciudades)session.get(
					CiudadesImpl.class, ciudades.getPrimaryKeyObj());
			}

			if (ciudades != null) {
				session.delete(ciudades);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ciudades != null) {
			clearCache(ciudades);
		}

		return ciudades;
	}

	@Override
	public Ciudades updateImpl(Ciudades ciudades) {
		boolean isNew = ciudades.isNew();

		if (!(ciudades instanceof CiudadesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ciudades.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ciudades);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ciudades proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ciudades implementation " +
					ciudades.getClass());
		}

		CiudadesModelImpl ciudadesModelImpl = (CiudadesModelImpl)ciudades;

		Session session = null;

		try {
			session = openSession();

			if (ciudades.isNew()) {
				session.save(ciudades);

				ciudades.setNew(false);
			}
			else {
				ciudades = (Ciudades)session.merge(ciudades);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {ciudadesModelImpl.isEstado()};

			finderCache.removeResult(_finderPathCountByEstado, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEstado, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ciudadesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEstado.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ciudadesModelImpl.getOriginalEstado()
				};

				finderCache.removeResult(_finderPathCountByEstado, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEstado, args);

				args = new Object[] {ciudadesModelImpl.isEstado()};

				finderCache.removeResult(_finderPathCountByEstado, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEstado, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CiudadesImpl.class, ciudades.getPrimaryKey(),
			ciudades, false);

		ciudades.resetOriginalValues();

		return ciudades;
	}

	/**
	 * Returns the ciudades with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ciudades
	 * @return the ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCiudadesException {

		Ciudades ciudades = fetchByPrimaryKey(primaryKey);

		if (ciudades == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCiudadesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ciudades;
	}

	/**
	 * Returns the ciudades with the primary key or throws a <code>NoSuchCiudadesException</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades
	 * @throws NoSuchCiudadesException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades findByPrimaryKey(long ciudadId)
		throws NoSuchCiudadesException {

		return findByPrimaryKey((Serializable)ciudadId);
	}

	/**
	 * Returns the ciudades with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades, or <code>null</code> if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades fetchByPrimaryKey(long ciudadId) {
		return fetchByPrimaryKey((Serializable)ciudadId);
	}

	/**
	 * Returns all the ciudadeses.
	 *
	 * @return the ciudadeses
	 */
	@Override
	public List<Ciudades> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Ciudades> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Ciudades> findAll(
		int start, int end, OrderByComparator<Ciudades> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Ciudades> findAll(
		int start, int end, OrderByComparator<Ciudades> orderByComparator,
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

		List<Ciudades> list = null;

		if (retrieveFromCache) {
			list = (List<Ciudades>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CIUDADES);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CIUDADES;

				if (pagination) {
					sql = sql.concat(CiudadesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Ciudades>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Ciudades>)QueryUtil.list(
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
	 * Removes all the ciudadeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ciudades ciudades : findAll()) {
			remove(ciudades);
		}
	}

	/**
	 * Returns the number of ciudadeses.
	 *
	 * @return the number of ciudadeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CIUDADES);

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
		return "ciudadId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CIUDADES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CiudadesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ciudades persistence.
	 */
	@Activate
	public void activate() {
		CiudadesModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CiudadesModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CiudadesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CiudadesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CiudadesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEstado",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CiudadesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEstado",
			new String[] {Boolean.class.getName()},
			CiudadesModelImpl.ESTADO_COLUMN_BITMASK);

		_finderPathCountByEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEstado",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CiudadesImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.Ciudades"),
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

	private static final String _SQL_SELECT_CIUDADES =
		"SELECT ciudades FROM Ciudades ciudades";

	private static final String _SQL_SELECT_CIUDADES_WHERE =
		"SELECT ciudades FROM Ciudades ciudades WHERE ";

	private static final String _SQL_COUNT_CIUDADES =
		"SELECT COUNT(ciudades) FROM Ciudades ciudades";

	private static final String _SQL_COUNT_CIUDADES_WHERE =
		"SELECT COUNT(ciudades) FROM Ciudades ciudades WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ciudades.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ciudades exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ciudades exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CiudadesPersistenceImpl.class);

}