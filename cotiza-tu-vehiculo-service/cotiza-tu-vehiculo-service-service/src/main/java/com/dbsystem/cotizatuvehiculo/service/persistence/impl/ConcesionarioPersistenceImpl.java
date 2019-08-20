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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchConcesionarioException;
import com.dbsystem.cotizatuvehiculo.model.Concesionario;
import com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioPersistence;
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
 * The persistence implementation for the concesionario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConcesionarioPersistence.class)
@ProviderType
public class ConcesionarioPersistenceImpl
	extends BasePersistenceImpl<Concesionario>
	implements ConcesionarioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConcesionarioUtil</code> to access the concesionario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConcesionarioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCiudadId;
	private FinderPath _finderPathWithoutPaginationFindByCiudadId;
	private FinderPath _finderPathCountByCiudadId;

	/**
	 * Returns all the concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the matching concesionarios
	 */
	@Override
	public List<Concesionario> findByCiudadId(long ciudadId) {
		return findByCiudadId(
			ciudadId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end) {

		return findByCiudadId(ciudadId, start, end, null);
	}

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
	@Override
	public List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return findByCiudadId(ciudadId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Concesionario> findByCiudadId(
		long ciudadId, int start, int end,
		OrderByComparator<Concesionario> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCiudadId;
			finderArgs = new Object[] {ciudadId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCiudadId;
			finderArgs = new Object[] {ciudadId, start, end, orderByComparator};
		}

		List<Concesionario> list = null;

		if (retrieveFromCache) {
			list = (List<Concesionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Concesionario concesionario : list) {
					if ((ciudadId != concesionario.getCiudadId())) {
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

			query.append(_SQL_SELECT_CONCESIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CIUDADID_CIUDADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ConcesionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ciudadId);

				if (!pagination) {
					list = (List<Concesionario>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Concesionario>)QueryUtil.list(
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
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	@Override
	public Concesionario findByCiudadId_First(
			long ciudadId, OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = fetchByCiudadId_First(
			ciudadId, orderByComparator);

		if (concesionario != null) {
			return concesionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ciudadId=");
		msg.append(ciudadId);

		msg.append("}");

		throw new NoSuchConcesionarioException(msg.toString());
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	@Override
	public Concesionario fetchByCiudadId_First(
		long ciudadId, OrderByComparator<Concesionario> orderByComparator) {

		List<Concesionario> list = findByCiudadId(
			ciudadId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	@Override
	public Concesionario findByCiudadId_Last(
			long ciudadId, OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = fetchByCiudadId_Last(
			ciudadId, orderByComparator);

		if (concesionario != null) {
			return concesionario;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ciudadId=");
		msg.append(ciudadId);

		msg.append("}");

		throw new NoSuchConcesionarioException(msg.toString());
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	@Override
	public Concesionario fetchByCiudadId_Last(
		long ciudadId, OrderByComparator<Concesionario> orderByComparator) {

		int count = countByCiudadId(ciudadId);

		if (count == 0) {
			return null;
		}

		List<Concesionario> list = findByCiudadId(
			ciudadId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concesionarios before and after the current concesionario in the ordered set where ciudadId = &#63;.
	 *
	 * @param concesionarioId the primary key of the current concesionario
	 * @param ciudadId the ciudad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario[] findByCiudadId_PrevAndNext(
			long concesionarioId, long ciudadId,
			OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = findByPrimaryKey(concesionarioId);

		Session session = null;

		try {
			session = openSession();

			Concesionario[] array = new ConcesionarioImpl[3];

			array[0] = getByCiudadId_PrevAndNext(
				session, concesionario, ciudadId, orderByComparator, true);

			array[1] = concesionario;

			array[2] = getByCiudadId_PrevAndNext(
				session, concesionario, ciudadId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Concesionario getByCiudadId_PrevAndNext(
		Session session, Concesionario concesionario, long ciudadId,
		OrderByComparator<Concesionario> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONCESIONARIO_WHERE);

		query.append(_FINDER_COLUMN_CIUDADID_CIUDADID_2);

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
			query.append(ConcesionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ciudadId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concesionario)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Concesionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concesionarios where ciudadId = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 */
	@Override
	public void removeByCiudadId(long ciudadId) {
		for (Concesionario concesionario :
				findByCiudadId(
					ciudadId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(concesionario);
		}
	}

	/**
	 * Returns the number of concesionarios where ciudadId = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @return the number of matching concesionarios
	 */
	@Override
	public int countByCiudadId(long ciudadId) {
		FinderPath finderPath = _finderPathCountByCiudadId;

		Object[] finderArgs = new Object[] {ciudadId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONCESIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CIUDADID_CIUDADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ciudadId);

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

	private static final String _FINDER_COLUMN_CIUDADID_CIUDADID_2 =
		"concesionario.ciudadId = ?";

	private FinderPath _finderPathWithPaginationFindByCiudadIdEstado;
	private FinderPath _finderPathWithoutPaginationFindByCiudadIdEstado;
	private FinderPath _finderPathCountByCiudadIdEstado;

	/**
	 * Returns all the concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the matching concesionarios
	 */
	@Override
	public List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado) {

		return findByCiudadIdEstado(
			ciudadId, estado, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end) {

		return findByCiudadIdEstado(ciudadId, estado, start, end, null);
	}

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
	@Override
	public List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return findByCiudadIdEstado(
			ciudadId, estado, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Concesionario> findByCiudadIdEstado(
		long ciudadId, boolean estado, int start, int end,
		OrderByComparator<Concesionario> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCiudadIdEstado;
			finderArgs = new Object[] {ciudadId, estado};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCiudadIdEstado;
			finderArgs = new Object[] {
				ciudadId, estado, start, end, orderByComparator
			};
		}

		List<Concesionario> list = null;

		if (retrieveFromCache) {
			list = (List<Concesionario>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Concesionario concesionario : list) {
					if ((ciudadId != concesionario.getCiudadId()) ||
						(estado != concesionario.isEstado())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CONCESIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CIUDADIDESTADO_CIUDADID_2);

			query.append(_FINDER_COLUMN_CIUDADIDESTADO_ESTADO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ConcesionarioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ciudadId);

				qPos.add(estado);

				if (!pagination) {
					list = (List<Concesionario>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Concesionario>)QueryUtil.list(
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
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	@Override
	public Concesionario findByCiudadIdEstado_First(
			long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = fetchByCiudadIdEstado_First(
			ciudadId, estado, orderByComparator);

		if (concesionario != null) {
			return concesionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ciudadId=");
		msg.append(ciudadId);

		msg.append(", estado=");
		msg.append(estado);

		msg.append("}");

		throw new NoSuchConcesionarioException(msg.toString());
	}

	/**
	 * Returns the first concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	@Override
	public Concesionario fetchByCiudadIdEstado_First(
		long ciudadId, boolean estado,
		OrderByComparator<Concesionario> orderByComparator) {

		List<Concesionario> list = findByCiudadIdEstado(
			ciudadId, estado, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario
	 * @throws NoSuchConcesionarioException if a matching concesionario could not be found
	 */
	@Override
	public Concesionario findByCiudadIdEstado_Last(
			long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = fetchByCiudadIdEstado_Last(
			ciudadId, estado, orderByComparator);

		if (concesionario != null) {
			return concesionario;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ciudadId=");
		msg.append(ciudadId);

		msg.append(", estado=");
		msg.append(estado);

		msg.append("}");

		throw new NoSuchConcesionarioException(msg.toString());
	}

	/**
	 * Returns the last concesionario in the ordered set where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario, or <code>null</code> if a matching concesionario could not be found
	 */
	@Override
	public Concesionario fetchByCiudadIdEstado_Last(
		long ciudadId, boolean estado,
		OrderByComparator<Concesionario> orderByComparator) {

		int count = countByCiudadIdEstado(ciudadId, estado);

		if (count == 0) {
			return null;
		}

		List<Concesionario> list = findByCiudadIdEstado(
			ciudadId, estado, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Concesionario[] findByCiudadIdEstado_PrevAndNext(
			long concesionarioId, long ciudadId, boolean estado,
			OrderByComparator<Concesionario> orderByComparator)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = findByPrimaryKey(concesionarioId);

		Session session = null;

		try {
			session = openSession();

			Concesionario[] array = new ConcesionarioImpl[3];

			array[0] = getByCiudadIdEstado_PrevAndNext(
				session, concesionario, ciudadId, estado, orderByComparator,
				true);

			array[1] = concesionario;

			array[2] = getByCiudadIdEstado_PrevAndNext(
				session, concesionario, ciudadId, estado, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Concesionario getByCiudadIdEstado_PrevAndNext(
		Session session, Concesionario concesionario, long ciudadId,
		boolean estado, OrderByComparator<Concesionario> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CONCESIONARIO_WHERE);

		query.append(_FINDER_COLUMN_CIUDADIDESTADO_CIUDADID_2);

		query.append(_FINDER_COLUMN_CIUDADIDESTADO_ESTADO_2);

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
			query.append(ConcesionarioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ciudadId);

		qPos.add(estado);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concesionario)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Concesionario> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concesionarios where ciudadId = &#63; and estado = &#63; from the database.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 */
	@Override
	public void removeByCiudadIdEstado(long ciudadId, boolean estado) {
		for (Concesionario concesionario :
				findByCiudadIdEstado(
					ciudadId, estado, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(concesionario);
		}
	}

	/**
	 * Returns the number of concesionarios where ciudadId = &#63; and estado = &#63;.
	 *
	 * @param ciudadId the ciudad ID
	 * @param estado the estado
	 * @return the number of matching concesionarios
	 */
	@Override
	public int countByCiudadIdEstado(long ciudadId, boolean estado) {
		FinderPath finderPath = _finderPathCountByCiudadIdEstado;

		Object[] finderArgs = new Object[] {ciudadId, estado};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONCESIONARIO_WHERE);

			query.append(_FINDER_COLUMN_CIUDADIDESTADO_CIUDADID_2);

			query.append(_FINDER_COLUMN_CIUDADIDESTADO_ESTADO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ciudadId);

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

	private static final String _FINDER_COLUMN_CIUDADIDESTADO_CIUDADID_2 =
		"concesionario.ciudadId = ? AND ";

	private static final String _FINDER_COLUMN_CIUDADIDESTADO_ESTADO_2 =
		"concesionario.estado = ?";

	public ConcesionarioPersistenceImpl() {
		setModelClass(Concesionario.class);

		setModelImplClass(ConcesionarioImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the concesionario in the entity cache if it is enabled.
	 *
	 * @param concesionario the concesionario
	 */
	@Override
	public void cacheResult(Concesionario concesionario) {
		entityCache.putResult(
			entityCacheEnabled, ConcesionarioImpl.class,
			concesionario.getPrimaryKey(), concesionario);

		concesionario.resetOriginalValues();
	}

	/**
	 * Caches the concesionarios in the entity cache if it is enabled.
	 *
	 * @param concesionarios the concesionarios
	 */
	@Override
	public void cacheResult(List<Concesionario> concesionarios) {
		for (Concesionario concesionario : concesionarios) {
			if (entityCache.getResult(
					entityCacheEnabled, ConcesionarioImpl.class,
					concesionario.getPrimaryKey()) == null) {

				cacheResult(concesionario);
			}
			else {
				concesionario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all concesionarios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConcesionarioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the concesionario.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Concesionario concesionario) {
		entityCache.removeResult(
			entityCacheEnabled, ConcesionarioImpl.class,
			concesionario.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Concesionario> concesionarios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Concesionario concesionario : concesionarios) {
			entityCache.removeResult(
				entityCacheEnabled, ConcesionarioImpl.class,
				concesionario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new concesionario with the primary key. Does not add the concesionario to the database.
	 *
	 * @param concesionarioId the primary key for the new concesionario
	 * @return the new concesionario
	 */
	@Override
	public Concesionario create(long concesionarioId) {
		Concesionario concesionario = new ConcesionarioImpl();

		concesionario.setNew(true);
		concesionario.setPrimaryKey(concesionarioId);

		return concesionario;
	}

	/**
	 * Removes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario remove(long concesionarioId)
		throws NoSuchConcesionarioException {

		return remove((Serializable)concesionarioId);
	}

	/**
	 * Removes the concesionario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the concesionario
	 * @return the concesionario that was removed
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario remove(Serializable primaryKey)
		throws NoSuchConcesionarioException {

		Session session = null;

		try {
			session = openSession();

			Concesionario concesionario = (Concesionario)session.get(
				ConcesionarioImpl.class, primaryKey);

			if (concesionario == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConcesionarioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(concesionario);
		}
		catch (NoSuchConcesionarioException nsee) {
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
	protected Concesionario removeImpl(Concesionario concesionario) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(concesionario)) {
				concesionario = (Concesionario)session.get(
					ConcesionarioImpl.class, concesionario.getPrimaryKeyObj());
			}

			if (concesionario != null) {
				session.delete(concesionario);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (concesionario != null) {
			clearCache(concesionario);
		}

		return concesionario;
	}

	@Override
	public Concesionario updateImpl(Concesionario concesionario) {
		boolean isNew = concesionario.isNew();

		if (!(concesionario instanceof ConcesionarioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(concesionario.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					concesionario);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in concesionario proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Concesionario implementation " +
					concesionario.getClass());
		}

		ConcesionarioModelImpl concesionarioModelImpl =
			(ConcesionarioModelImpl)concesionario;

		Session session = null;

		try {
			session = openSession();

			if (concesionario.isNew()) {
				session.save(concesionario);

				concesionario.setNew(false);
			}
			else {
				concesionario = (Concesionario)session.merge(concesionario);
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
			Object[] args = new Object[] {concesionarioModelImpl.getCiudadId()};

			finderCache.removeResult(_finderPathCountByCiudadId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCiudadId, args);

			args = new Object[] {
				concesionarioModelImpl.getCiudadId(),
				concesionarioModelImpl.isEstado()
			};

			finderCache.removeResult(_finderPathCountByCiudadIdEstado, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCiudadIdEstado, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((concesionarioModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCiudadId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					concesionarioModelImpl.getOriginalCiudadId()
				};

				finderCache.removeResult(_finderPathCountByCiudadId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCiudadId, args);

				args = new Object[] {concesionarioModelImpl.getCiudadId()};

				finderCache.removeResult(_finderPathCountByCiudadId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCiudadId, args);
			}

			if ((concesionarioModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCiudadIdEstado.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					concesionarioModelImpl.getOriginalCiudadId(),
					concesionarioModelImpl.getOriginalEstado()
				};

				finderCache.removeResult(
					_finderPathCountByCiudadIdEstado, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCiudadIdEstado, args);

				args = new Object[] {
					concesionarioModelImpl.getCiudadId(),
					concesionarioModelImpl.isEstado()
				};

				finderCache.removeResult(
					_finderPathCountByCiudadIdEstado, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCiudadIdEstado, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ConcesionarioImpl.class,
			concesionario.getPrimaryKey(), concesionario, false);

		concesionario.resetOriginalValues();

		return concesionario;
	}

	/**
	 * Returns the concesionario with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the concesionario
	 * @return the concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConcesionarioException {

		Concesionario concesionario = fetchByPrimaryKey(primaryKey);

		if (concesionario == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConcesionarioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return concesionario;
	}

	/**
	 * Returns the concesionario with the primary key or throws a <code>NoSuchConcesionarioException</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario
	 * @throws NoSuchConcesionarioException if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario findByPrimaryKey(long concesionarioId)
		throws NoSuchConcesionarioException {

		return findByPrimaryKey((Serializable)concesionarioId);
	}

	/**
	 * Returns the concesionario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioId the primary key of the concesionario
	 * @return the concesionario, or <code>null</code> if a concesionario with the primary key could not be found
	 */
	@Override
	public Concesionario fetchByPrimaryKey(long concesionarioId) {
		return fetchByPrimaryKey((Serializable)concesionarioId);
	}

	/**
	 * Returns all the concesionarios.
	 *
	 * @return the concesionarios
	 */
	@Override
	public List<Concesionario> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Concesionario> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Concesionario> findAll(
		int start, int end,
		OrderByComparator<Concesionario> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Concesionario> findAll(
		int start, int end, OrderByComparator<Concesionario> orderByComparator,
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

		List<Concesionario> list = null;

		if (retrieveFromCache) {
			list = (List<Concesionario>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONCESIONARIO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONCESIONARIO;

				if (pagination) {
					sql = sql.concat(ConcesionarioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Concesionario>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Concesionario>)QueryUtil.list(
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
	 * Removes all the concesionarios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Concesionario concesionario : findAll()) {
			remove(concesionario);
		}
	}

	/**
	 * Returns the number of concesionarios.
	 *
	 * @return the number of concesionarios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONCESIONARIO);

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
		return "concesionarioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONCESIONARIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConcesionarioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the concesionario persistence.
	 */
	@Activate
	public void activate() {
		ConcesionarioModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ConcesionarioModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCiudadId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCiudadId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCiudadId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCiudadId",
			new String[] {Long.class.getName()},
			ConcesionarioModelImpl.CIUDADID_COLUMN_BITMASK);

		_finderPathCountByCiudadId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCiudadId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCiudadIdEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCiudadIdEstado",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCiudadIdEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ConcesionarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCiudadIdEstado",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			ConcesionarioModelImpl.CIUDADID_COLUMN_BITMASK |
			ConcesionarioModelImpl.ESTADO_COLUMN_BITMASK);

		_finderPathCountByCiudadIdEstado = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCiudadIdEstado",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ConcesionarioImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.Concesionario"),
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

	private static final String _SQL_SELECT_CONCESIONARIO =
		"SELECT concesionario FROM Concesionario concesionario";

	private static final String _SQL_SELECT_CONCESIONARIO_WHERE =
		"SELECT concesionario FROM Concesionario concesionario WHERE ";

	private static final String _SQL_COUNT_CONCESIONARIO =
		"SELECT COUNT(concesionario) FROM Concesionario concesionario";

	private static final String _SQL_COUNT_CONCESIONARIO_WHERE =
		"SELECT COUNT(concesionario) FROM Concesionario concesionario WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "concesionario.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Concesionario exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Concesionario exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConcesionarioPersistenceImpl.class);

}