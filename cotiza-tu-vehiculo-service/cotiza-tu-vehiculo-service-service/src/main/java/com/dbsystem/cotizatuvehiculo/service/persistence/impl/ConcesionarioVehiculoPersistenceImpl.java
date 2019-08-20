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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchConcesionarioVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo;
import com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioVehiculoImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.ConcesionarioVehiculoModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioVehiculoPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

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
 * The persistence implementation for the concesionario vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConcesionarioVehiculoPersistence.class)
@ProviderType
public class ConcesionarioVehiculoPersistenceImpl
	extends BasePersistenceImpl<ConcesionarioVehiculo>
	implements ConcesionarioVehiculoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConcesionarioVehiculoUtil</code> to access the concesionario vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConcesionarioVehiculoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByConcesionarioId;
	private FinderPath _finderPathWithoutPaginationFindByConcesionarioId;
	private FinderPath _finderPathCountByConcesionarioId;

	/**
	 * Returns all the concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the matching concesionario vehiculos
	 */
	@Override
	public List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId) {

		return findByConcesionarioId(
			concesionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end) {

		return findByConcesionarioId(concesionarioId, start, end, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return findByConcesionarioId(
			concesionarioId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByConcesionarioId(
		long concesionarioId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByConcesionarioId;
			finderArgs = new Object[] {concesionarioId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByConcesionarioId;
			finderArgs = new Object[] {
				concesionarioId, start, end, orderByComparator
			};
		}

		List<ConcesionarioVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ConcesionarioVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConcesionarioVehiculo concesionarioVehiculo : list) {
					if ((concesionarioId !=
							concesionarioVehiculo.getConcesionarioId())) {

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

			query.append(_SQL_SELECT_CONCESIONARIOVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_CONCESIONARIOID_CONCESIONARIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ConcesionarioVehiculoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(concesionarioId);

				if (!pagination) {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
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
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByConcesionarioId_First(
			long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo =
			fetchByConcesionarioId_First(concesionarioId, orderByComparator);

		if (concesionarioVehiculo != null) {
			return concesionarioVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("concesionarioId=");
		msg.append(concesionarioId);

		msg.append("}");

		throw new NoSuchConcesionarioVehiculoException(msg.toString());
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByConcesionarioId_First(
		long concesionarioId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		List<ConcesionarioVehiculo> list = findByConcesionarioId(
			concesionarioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByConcesionarioId_Last(
			long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo =
			fetchByConcesionarioId_Last(concesionarioId, orderByComparator);

		if (concesionarioVehiculo != null) {
			return concesionarioVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("concesionarioId=");
		msg.append(concesionarioId);

		msg.append("}");

		throw new NoSuchConcesionarioVehiculoException(msg.toString());
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByConcesionarioId_Last(
		long concesionarioId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		int count = countByConcesionarioId(concesionarioId);

		if (count == 0) {
			return null;
		}

		List<ConcesionarioVehiculo> list = findByConcesionarioId(
			concesionarioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where concesionarioId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param concesionarioId the concesionario ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo[] findByConcesionarioId_PrevAndNext(
			long concesionarioVehiculoId, long concesionarioId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo = findByPrimaryKey(
			concesionarioVehiculoId);

		Session session = null;

		try {
			session = openSession();

			ConcesionarioVehiculo[] array = new ConcesionarioVehiculoImpl[3];

			array[0] = getByConcesionarioId_PrevAndNext(
				session, concesionarioVehiculo, concesionarioId,
				orderByComparator, true);

			array[1] = concesionarioVehiculo;

			array[2] = getByConcesionarioId_PrevAndNext(
				session, concesionarioVehiculo, concesionarioId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConcesionarioVehiculo getByConcesionarioId_PrevAndNext(
		Session session, ConcesionarioVehiculo concesionarioVehiculo,
		long concesionarioId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONCESIONARIOVEHICULO_WHERE);

		query.append(_FINDER_COLUMN_CONCESIONARIOID_CONCESIONARIOID_2);

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
			query.append(ConcesionarioVehiculoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(concesionarioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concesionarioVehiculo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ConcesionarioVehiculo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concesionario vehiculos where concesionarioId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 */
	@Override
	public void removeByConcesionarioId(long concesionarioId) {
		for (ConcesionarioVehiculo concesionarioVehiculo :
				findByConcesionarioId(
					concesionarioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(concesionarioVehiculo);
		}
	}

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @return the number of matching concesionario vehiculos
	 */
	@Override
	public int countByConcesionarioId(long concesionarioId) {
		FinderPath finderPath = _finderPathCountByConcesionarioId;

		Object[] finderArgs = new Object[] {concesionarioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONCESIONARIOVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_CONCESIONARIOID_CONCESIONARIOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(concesionarioId);

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

	private static final String
		_FINDER_COLUMN_CONCESIONARIOID_CONCESIONARIOID_2 =
			"concesionarioVehiculo.concesionarioId = ?";

	private FinderPath _finderPathWithPaginationFindByVehiculoId;
	private FinderPath _finderPathWithoutPaginationFindByVehiculoId;
	private FinderPath _finderPathCountByVehiculoId;

	/**
	 * Returns all the concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculos
	 */
	@Override
	public List<ConcesionarioVehiculo> findByVehiculoId(long vehiculoId) {
		return findByVehiculoId(
			vehiculoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end) {

		return findByVehiculoId(vehiculoId, start, end, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return findByVehiculoId(
			vehiculoId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVehiculoId;
			finderArgs = new Object[] {vehiculoId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVehiculoId;
			finderArgs = new Object[] {
				vehiculoId, start, end, orderByComparator
			};
		}

		List<ConcesionarioVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ConcesionarioVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConcesionarioVehiculo concesionarioVehiculo : list) {
					if ((vehiculoId != concesionarioVehiculo.getVehiculoId())) {
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

			query.append(_SQL_SELECT_CONCESIONARIOVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_VEHICULOID_VEHICULOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ConcesionarioVehiculoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehiculoId);

				if (!pagination) {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
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
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByVehiculoId_First(
			long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo = fetchByVehiculoId_First(
			vehiculoId, orderByComparator);

		if (concesionarioVehiculo != null) {
			return concesionarioVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiculoId=");
		msg.append(vehiculoId);

		msg.append("}");

		throw new NoSuchConcesionarioVehiculoException(msg.toString());
	}

	/**
	 * Returns the first concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByVehiculoId_First(
		long vehiculoId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		List<ConcesionarioVehiculo> list = findByVehiculoId(
			vehiculoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByVehiculoId_Last(
			long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo = fetchByVehiculoId_Last(
			vehiculoId, orderByComparator);

		if (concesionarioVehiculo != null) {
			return concesionarioVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiculoId=");
		msg.append(vehiculoId);

		msg.append("}");

		throw new NoSuchConcesionarioVehiculoException(msg.toString());
	}

	/**
	 * Returns the last concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByVehiculoId_Last(
		long vehiculoId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		int count = countByVehiculoId(vehiculoId);

		if (count == 0) {
			return null;
		}

		List<ConcesionarioVehiculo> list = findByVehiculoId(
			vehiculoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concesionario vehiculos before and after the current concesionario vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param concesionarioVehiculoId the primary key of the current concesionario vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo[] findByVehiculoId_PrevAndNext(
			long concesionarioVehiculoId, long vehiculoId,
			OrderByComparator<ConcesionarioVehiculo> orderByComparator)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo = findByPrimaryKey(
			concesionarioVehiculoId);

		Session session = null;

		try {
			session = openSession();

			ConcesionarioVehiculo[] array = new ConcesionarioVehiculoImpl[3];

			array[0] = getByVehiculoId_PrevAndNext(
				session, concesionarioVehiculo, vehiculoId, orderByComparator,
				true);

			array[1] = concesionarioVehiculo;

			array[2] = getByVehiculoId_PrevAndNext(
				session, concesionarioVehiculo, vehiculoId, orderByComparator,
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

	protected ConcesionarioVehiculo getByVehiculoId_PrevAndNext(
		Session session, ConcesionarioVehiculo concesionarioVehiculo,
		long vehiculoId,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONCESIONARIOVEHICULO_WHERE);

		query.append(_FINDER_COLUMN_VEHICULOID_VEHICULOID_2);

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
			query.append(ConcesionarioVehiculoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vehiculoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concesionarioVehiculo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ConcesionarioVehiculo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concesionario vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	@Override
	public void removeByVehiculoId(long vehiculoId) {
		for (ConcesionarioVehiculo concesionarioVehiculo :
				findByVehiculoId(
					vehiculoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(concesionarioVehiculo);
		}
	}

	/**
	 * Returns the number of concesionario vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	@Override
	public int countByVehiculoId(long vehiculoId) {
		FinderPath finderPath = _finderPathCountByVehiculoId;

		Object[] finderArgs = new Object[] {vehiculoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONCESIONARIOVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_VEHICULOID_VEHICULOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehiculoId);

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

	private static final String _FINDER_COLUMN_VEHICULOID_VEHICULOID_2 =
		"concesionarioVehiculo.vehiculoId = ?";

	private FinderPath _finderPathFetchByConcesionarioIdVehiculoId;
	private FinderPath _finderPathCountByConcesionarioIdVehiculoId;

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo =
			fetchByConcesionarioIdVehiculoId(concesionarioId, vehiculoId);

		if (concesionarioVehiculo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("concesionarioId=");
			msg.append(concesionarioId);

			msg.append(", vehiculoId=");
			msg.append(vehiculoId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchConcesionarioVehiculoException(msg.toString());
		}

		return concesionarioVehiculo;
	}

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId) {

		return fetchByConcesionarioIdVehiculoId(
			concesionarioId, vehiculoId, true);
	}

	/**
	 * Returns the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching concesionario vehiculo, or <code>null</code> if a matching concesionario vehiculo could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {concesionarioId, vehiculoId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByConcesionarioIdVehiculoId, finderArgs, this);
		}

		if (result instanceof ConcesionarioVehiculo) {
			ConcesionarioVehiculo concesionarioVehiculo =
				(ConcesionarioVehiculo)result;

			if ((concesionarioId !=
					concesionarioVehiculo.getConcesionarioId()) ||
				(vehiculoId != concesionarioVehiculo.getVehiculoId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONCESIONARIOVEHICULO_WHERE);

			query.append(
				_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2);

			query.append(_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_VEHICULOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(concesionarioId);

				qPos.add(vehiculoId);

				List<ConcesionarioVehiculo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByConcesionarioIdVehiculoId, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ConcesionarioVehiculoPersistenceImpl.fetchByConcesionarioIdVehiculoId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ConcesionarioVehiculo concesionarioVehiculo = list.get(0);

					result = concesionarioVehiculo;

					cacheResult(concesionarioVehiculo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByConcesionarioIdVehiculoId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ConcesionarioVehiculo)result;
		}
	}

	/**
	 * Removes the concesionario vehiculo where concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the concesionario vehiculo that was removed
	 */
	@Override
	public ConcesionarioVehiculo removeByConcesionarioIdVehiculoId(
			long concesionarioId, long vehiculoId)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo =
			findByConcesionarioIdVehiculoId(concesionarioId, vehiculoId);

		return remove(concesionarioVehiculo);
	}

	/**
	 * Returns the number of concesionario vehiculos where concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching concesionario vehiculos
	 */
	@Override
	public int countByConcesionarioIdVehiculoId(
		long concesionarioId, long vehiculoId) {

		FinderPath finderPath = _finderPathCountByConcesionarioIdVehiculoId;

		Object[] finderArgs = new Object[] {concesionarioId, vehiculoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONCESIONARIOVEHICULO_WHERE);

			query.append(
				_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2);

			query.append(_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_VEHICULOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(concesionarioId);

				qPos.add(vehiculoId);

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

	private static final String
		_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2 =
			"concesionarioVehiculo.concesionarioId = ? AND ";

	private static final String
		_FINDER_COLUMN_CONCESIONARIOIDVEHICULOID_VEHICULOID_2 =
			"concesionarioVehiculo.vehiculoId = ?";

	public ConcesionarioVehiculoPersistenceImpl() {
		setModelClass(ConcesionarioVehiculo.class);

		setModelImplClass(ConcesionarioVehiculoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the concesionario vehiculo in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculo the concesionario vehiculo
	 */
	@Override
	public void cacheResult(ConcesionarioVehiculo concesionarioVehiculo) {
		entityCache.putResult(
			entityCacheEnabled, ConcesionarioVehiculoImpl.class,
			concesionarioVehiculo.getPrimaryKey(), concesionarioVehiculo);

		finderCache.putResult(
			_finderPathFetchByConcesionarioIdVehiculoId,
			new Object[] {
				concesionarioVehiculo.getConcesionarioId(),
				concesionarioVehiculo.getVehiculoId()
			},
			concesionarioVehiculo);

		concesionarioVehiculo.resetOriginalValues();
	}

	/**
	 * Caches the concesionario vehiculos in the entity cache if it is enabled.
	 *
	 * @param concesionarioVehiculos the concesionario vehiculos
	 */
	@Override
	public void cacheResult(
		List<ConcesionarioVehiculo> concesionarioVehiculos) {

		for (ConcesionarioVehiculo concesionarioVehiculo :
				concesionarioVehiculos) {

			if (entityCache.getResult(
					entityCacheEnabled, ConcesionarioVehiculoImpl.class,
					concesionarioVehiculo.getPrimaryKey()) == null) {

				cacheResult(concesionarioVehiculo);
			}
			else {
				concesionarioVehiculo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all concesionario vehiculos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConcesionarioVehiculoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the concesionario vehiculo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConcesionarioVehiculo concesionarioVehiculo) {
		entityCache.removeResult(
			entityCacheEnabled, ConcesionarioVehiculoImpl.class,
			concesionarioVehiculo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ConcesionarioVehiculoModelImpl)concesionarioVehiculo, true);
	}

	@Override
	public void clearCache(List<ConcesionarioVehiculo> concesionarioVehiculos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConcesionarioVehiculo concesionarioVehiculo :
				concesionarioVehiculos) {

			entityCache.removeResult(
				entityCacheEnabled, ConcesionarioVehiculoImpl.class,
				concesionarioVehiculo.getPrimaryKey());

			clearUniqueFindersCache(
				(ConcesionarioVehiculoModelImpl)concesionarioVehiculo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ConcesionarioVehiculoModelImpl concesionarioVehiculoModelImpl) {

		Object[] args = new Object[] {
			concesionarioVehiculoModelImpl.getConcesionarioId(),
			concesionarioVehiculoModelImpl.getVehiculoId()
		};

		finderCache.putResult(
			_finderPathCountByConcesionarioIdVehiculoId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByConcesionarioIdVehiculoId, args,
			concesionarioVehiculoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ConcesionarioVehiculoModelImpl concesionarioVehiculoModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				concesionarioVehiculoModelImpl.getConcesionarioId(),
				concesionarioVehiculoModelImpl.getVehiculoId()
			};

			finderCache.removeResult(
				_finderPathCountByConcesionarioIdVehiculoId, args);
			finderCache.removeResult(
				_finderPathFetchByConcesionarioIdVehiculoId, args);
		}

		if ((concesionarioVehiculoModelImpl.getColumnBitmask() &
			 _finderPathFetchByConcesionarioIdVehiculoId.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				concesionarioVehiculoModelImpl.getOriginalConcesionarioId(),
				concesionarioVehiculoModelImpl.getOriginalVehiculoId()
			};

			finderCache.removeResult(
				_finderPathCountByConcesionarioIdVehiculoId, args);
			finderCache.removeResult(
				_finderPathFetchByConcesionarioIdVehiculoId, args);
		}
	}

	/**
	 * Creates a new concesionario vehiculo with the primary key. Does not add the concesionario vehiculo to the database.
	 *
	 * @param concesionarioVehiculoId the primary key for the new concesionario vehiculo
	 * @return the new concesionario vehiculo
	 */
	@Override
	public ConcesionarioVehiculo create(long concesionarioVehiculoId) {
		ConcesionarioVehiculo concesionarioVehiculo =
			new ConcesionarioVehiculoImpl();

		concesionarioVehiculo.setNew(true);
		concesionarioVehiculo.setPrimaryKey(concesionarioVehiculoId);

		return concesionarioVehiculo;
	}

	/**
	 * Removes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo remove(long concesionarioVehiculoId)
		throws NoSuchConcesionarioVehiculoException {

		return remove((Serializable)concesionarioVehiculoId);
	}

	/**
	 * Removes the concesionario vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo that was removed
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo remove(Serializable primaryKey)
		throws NoSuchConcesionarioVehiculoException {

		Session session = null;

		try {
			session = openSession();

			ConcesionarioVehiculo concesionarioVehiculo =
				(ConcesionarioVehiculo)session.get(
					ConcesionarioVehiculoImpl.class, primaryKey);

			if (concesionarioVehiculo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConcesionarioVehiculoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(concesionarioVehiculo);
		}
		catch (NoSuchConcesionarioVehiculoException nsee) {
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
	protected ConcesionarioVehiculo removeImpl(
		ConcesionarioVehiculo concesionarioVehiculo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(concesionarioVehiculo)) {
				concesionarioVehiculo = (ConcesionarioVehiculo)session.get(
					ConcesionarioVehiculoImpl.class,
					concesionarioVehiculo.getPrimaryKeyObj());
			}

			if (concesionarioVehiculo != null) {
				session.delete(concesionarioVehiculo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (concesionarioVehiculo != null) {
			clearCache(concesionarioVehiculo);
		}

		return concesionarioVehiculo;
	}

	@Override
	public ConcesionarioVehiculo updateImpl(
		ConcesionarioVehiculo concesionarioVehiculo) {

		boolean isNew = concesionarioVehiculo.isNew();

		if (!(concesionarioVehiculo instanceof
				ConcesionarioVehiculoModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(concesionarioVehiculo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					concesionarioVehiculo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in concesionarioVehiculo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConcesionarioVehiculo implementation " +
					concesionarioVehiculo.getClass());
		}

		ConcesionarioVehiculoModelImpl concesionarioVehiculoModelImpl =
			(ConcesionarioVehiculoModelImpl)concesionarioVehiculo;

		Session session = null;

		try {
			session = openSession();

			if (concesionarioVehiculo.isNew()) {
				session.save(concesionarioVehiculo);

				concesionarioVehiculo.setNew(false);
			}
			else {
				concesionarioVehiculo = (ConcesionarioVehiculo)session.merge(
					concesionarioVehiculo);
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
			Object[] args = new Object[] {
				concesionarioVehiculoModelImpl.getConcesionarioId()
			};

			finderCache.removeResult(_finderPathCountByConcesionarioId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConcesionarioId, args);

			args = new Object[] {
				concesionarioVehiculoModelImpl.getVehiculoId()
			};

			finderCache.removeResult(_finderPathCountByVehiculoId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVehiculoId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((concesionarioVehiculoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConcesionarioId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					concesionarioVehiculoModelImpl.getOriginalConcesionarioId()
				};

				finderCache.removeResult(
					_finderPathCountByConcesionarioId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConcesionarioId, args);

				args = new Object[] {
					concesionarioVehiculoModelImpl.getConcesionarioId()
				};

				finderCache.removeResult(
					_finderPathCountByConcesionarioId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConcesionarioId, args);
			}

			if ((concesionarioVehiculoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVehiculoId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					concesionarioVehiculoModelImpl.getOriginalVehiculoId()
				};

				finderCache.removeResult(_finderPathCountByVehiculoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVehiculoId, args);

				args = new Object[] {
					concesionarioVehiculoModelImpl.getVehiculoId()
				};

				finderCache.removeResult(_finderPathCountByVehiculoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVehiculoId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ConcesionarioVehiculoImpl.class,
			concesionarioVehiculo.getPrimaryKey(), concesionarioVehiculo,
			false);

		clearUniqueFindersCache(concesionarioVehiculoModelImpl, false);
		cacheUniqueFindersCache(concesionarioVehiculoModelImpl);

		concesionarioVehiculo.resetOriginalValues();

		return concesionarioVehiculo;
	}

	/**
	 * Returns the concesionario vehiculo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConcesionarioVehiculoException {

		ConcesionarioVehiculo concesionarioVehiculo = fetchByPrimaryKey(
			primaryKey);

		if (concesionarioVehiculo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConcesionarioVehiculoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return concesionarioVehiculo;
	}

	/**
	 * Returns the concesionario vehiculo with the primary key or throws a <code>NoSuchConcesionarioVehiculoException</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo
	 * @throws NoSuchConcesionarioVehiculoException if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo findByPrimaryKey(long concesionarioVehiculoId)
		throws NoSuchConcesionarioVehiculoException {

		return findByPrimaryKey((Serializable)concesionarioVehiculoId);
	}

	/**
	 * Returns the concesionario vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param concesionarioVehiculoId the primary key of the concesionario vehiculo
	 * @return the concesionario vehiculo, or <code>null</code> if a concesionario vehiculo with the primary key could not be found
	 */
	@Override
	public ConcesionarioVehiculo fetchByPrimaryKey(
		long concesionarioVehiculoId) {

		return fetchByPrimaryKey((Serializable)concesionarioVehiculoId);
	}

	/**
	 * Returns all the concesionario vehiculos.
	 *
	 * @return the concesionario vehiculos
	 */
	@Override
	public List<ConcesionarioVehiculo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findAll(
		int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConcesionarioVehiculo> findAll(
		int start, int end,
		OrderByComparator<ConcesionarioVehiculo> orderByComparator,
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

		List<ConcesionarioVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ConcesionarioVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONCESIONARIOVEHICULO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONCESIONARIOVEHICULO;

				if (pagination) {
					sql = sql.concat(
						ConcesionarioVehiculoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ConcesionarioVehiculo>)QueryUtil.list(
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
	 * Removes all the concesionario vehiculos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConcesionarioVehiculo concesionarioVehiculo : findAll()) {
			remove(concesionarioVehiculo);
		}
	}

	/**
	 * Returns the number of concesionario vehiculos.
	 *
	 * @return the number of concesionario vehiculos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONCESIONARIOVEHICULO);

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
		return "concesionarioVehiculoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONCESIONARIOVEHICULO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConcesionarioVehiculoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the concesionario vehiculo persistence.
	 */
	@Activate
	public void activate() {
		ConcesionarioVehiculoModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		ConcesionarioVehiculoModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByConcesionarioId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConcesionarioId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByConcesionarioId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConcesionarioId",
			new String[] {Long.class.getName()},
			ConcesionarioVehiculoModelImpl.CONCESIONARIOID_COLUMN_BITMASK);

		_finderPathCountByConcesionarioId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConcesionarioId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVehiculoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVehiculoId",
			new String[] {Long.class.getName()},
			ConcesionarioVehiculoModelImpl.VEHICULOID_COLUMN_BITMASK);

		_finderPathCountByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVehiculoId",
			new String[] {Long.class.getName()});

		_finderPathFetchByConcesionarioIdVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConcesionarioVehiculoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByConcesionarioIdVehiculoId",
			new String[] {Long.class.getName(), Long.class.getName()},
			ConcesionarioVehiculoModelImpl.CONCESIONARIOID_COLUMN_BITMASK |
			ConcesionarioVehiculoModelImpl.VEHICULOID_COLUMN_BITMASK);

		_finderPathCountByConcesionarioIdVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConcesionarioIdVehiculoId",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ConcesionarioVehiculoImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.ConcesionarioVehiculo"),
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

	private static final String _SQL_SELECT_CONCESIONARIOVEHICULO =
		"SELECT concesionarioVehiculo FROM ConcesionarioVehiculo concesionarioVehiculo";

	private static final String _SQL_SELECT_CONCESIONARIOVEHICULO_WHERE =
		"SELECT concesionarioVehiculo FROM ConcesionarioVehiculo concesionarioVehiculo WHERE ";

	private static final String _SQL_COUNT_CONCESIONARIOVEHICULO =
		"SELECT COUNT(concesionarioVehiculo) FROM ConcesionarioVehiculo concesionarioVehiculo";

	private static final String _SQL_COUNT_CONCESIONARIOVEHICULO_WHERE =
		"SELECT COUNT(concesionarioVehiculo) FROM ConcesionarioVehiculo concesionarioVehiculo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"concesionarioVehiculo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConcesionarioVehiculo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConcesionarioVehiculo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConcesionarioVehiculoPersistenceImpl.class);

}