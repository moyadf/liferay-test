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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteVehiculoException;
import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;
import com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ClienteVehiculoPersistence;
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
 * The persistence implementation for the cliente vehiculo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClienteVehiculoPersistence.class)
@ProviderType
public class ClienteVehiculoPersistenceImpl
	extends BasePersistenceImpl<ClienteVehiculo>
	implements ClienteVehiculoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClienteVehiculoUtil</code> to access the cliente vehiculo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClienteVehiculoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByClienteIdConcesionarioIdVehiculoId;
	private FinderPath _finderPathCountByClienteIdConcesionarioIdVehiculoId;

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo findByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo =
			fetchByClienteIdConcesionarioIdVehiculoId(
				clienteId, concesionarioId, vehiculoId);

		if (clienteVehiculo == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("clienteId=");
			msg.append(clienteId);

			msg.append(", concesionarioId=");
			msg.append(concesionarioId);

			msg.append(", vehiculoId=");
			msg.append(vehiculoId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchClienteVehiculoException(msg.toString());
		}

		return clienteVehiculo;
	}

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId) {

		return fetchByClienteIdConcesionarioIdVehiculoId(
			clienteId, concesionarioId, vehiculoId, true);
	}

	/**
	 * Returns the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId,
		boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {
			clienteId, concesionarioId, vehiculoId
		};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByClienteIdConcesionarioIdVehiculoId,
				finderArgs, this);
		}

		if (result instanceof ClienteVehiculo) {
			ClienteVehiculo clienteVehiculo = (ClienteVehiculo)result;

			if ((clienteId != clienteVehiculo.getClienteId()) ||
				(concesionarioId != clienteVehiculo.getConcesionarioId()) ||
				(vehiculoId != clienteVehiculo.getVehiculoId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CLIENTEVEHICULO_WHERE);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CLIENTEID_2);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_VEHICULOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clienteId);

				qPos.add(concesionarioId);

				qPos.add(vehiculoId);

				List<ClienteVehiculo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByClienteIdConcesionarioIdVehiculoId,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ClienteVehiculoPersistenceImpl.fetchByClienteIdConcesionarioIdVehiculoId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ClienteVehiculo clienteVehiculo = list.get(0);

					result = clienteVehiculo;

					cacheResult(clienteVehiculo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByClienteIdConcesionarioIdVehiculoId,
					finderArgs);

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
			return (ClienteVehiculo)result;
		}
	}

	/**
	 * Removes the cliente vehiculo where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the cliente vehiculo that was removed
	 */
	@Override
	public ClienteVehiculo removeByClienteIdConcesionarioIdVehiculoId(
			long clienteId, long concesionarioId, long vehiculoId)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo =
			findByClienteIdConcesionarioIdVehiculoId(
				clienteId, concesionarioId, vehiculoId);

		return remove(clienteVehiculo);
	}

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63; and concesionarioId = &#63; and vehiculoId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param concesionarioId the concesionario ID
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	@Override
	public int countByClienteIdConcesionarioIdVehiculoId(
		long clienteId, long concesionarioId, long vehiculoId) {

		FinderPath finderPath =
			_finderPathCountByClienteIdConcesionarioIdVehiculoId;

		Object[] finderArgs = new Object[] {
			clienteId, concesionarioId, vehiculoId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CLIENTEVEHICULO_WHERE);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CLIENTEID_2);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2);

			query.append(
				_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_VEHICULOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clienteId);

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
		_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CLIENTEID_2 =
			"clienteVehiculo.clienteId = ? AND ";

	private static final String
		_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_CONCESIONARIOID_2 =
			"clienteVehiculo.concesionarioId = ? AND ";

	private static final String
		_FINDER_COLUMN_CLIENTEIDCONCESIONARIOIDVEHICULOID_VEHICULOID_2 =
			"clienteVehiculo.vehiculoId = ?";

	private FinderPath _finderPathWithPaginationFindByClienteId;
	private FinderPath _finderPathWithoutPaginationFindByClienteId;
	private FinderPath _finderPathCountByClienteId;

	/**
	 * Returns all the cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the matching cliente vehiculos
	 */
	@Override
	public List<ClienteVehiculo> findByClienteId(long clienteId) {
		return findByClienteId(
			clienteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end) {

		return findByClienteId(clienteId, start, end, null);
	}

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
	@Override
	public List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return findByClienteId(clienteId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ClienteVehiculo> findByClienteId(
		long clienteId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClienteId;
			finderArgs = new Object[] {clienteId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClienteId;
			finderArgs = new Object[] {
				clienteId, start, end, orderByComparator
			};
		}

		List<ClienteVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ClienteVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClienteVehiculo clienteVehiculo : list) {
					if ((clienteId != clienteVehiculo.getClienteId())) {
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

			query.append(_SQL_SELECT_CLIENTEVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTEID_CLIENTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ClienteVehiculoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clienteId);

				if (!pagination) {
					list = (List<ClienteVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ClienteVehiculo>)QueryUtil.list(
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
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo findByClienteId_First(
			long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = fetchByClienteId_First(
			clienteId, orderByComparator);

		if (clienteVehiculo != null) {
			return clienteVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clienteId=");
		msg.append(clienteId);

		msg.append("}");

		throw new NoSuchClienteVehiculoException(msg.toString());
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByClienteId_First(
		long clienteId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		List<ClienteVehiculo> list = findByClienteId(
			clienteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo findByClienteId_Last(
			long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = fetchByClienteId_Last(
			clienteId, orderByComparator);

		if (clienteVehiculo != null) {
			return clienteVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clienteId=");
		msg.append(clienteId);

		msg.append("}");

		throw new NoSuchClienteVehiculoException(msg.toString());
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByClienteId_Last(
		long clienteId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		int count = countByClienteId(clienteId);

		if (count == 0) {
			return null;
		}

		List<ClienteVehiculo> list = findByClienteId(
			clienteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where clienteId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param clienteId the cliente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo[] findByClienteId_PrevAndNext(
			long clienteVehiculoId, long clienteId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = findByPrimaryKey(clienteVehiculoId);

		Session session = null;

		try {
			session = openSession();

			ClienteVehiculo[] array = new ClienteVehiculoImpl[3];

			array[0] = getByClienteId_PrevAndNext(
				session, clienteVehiculo, clienteId, orderByComparator, true);

			array[1] = clienteVehiculo;

			array[2] = getByClienteId_PrevAndNext(
				session, clienteVehiculo, clienteId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClienteVehiculo getByClienteId_PrevAndNext(
		Session session, ClienteVehiculo clienteVehiculo, long clienteId,
		OrderByComparator<ClienteVehiculo> orderByComparator,
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

		query.append(_SQL_SELECT_CLIENTEVEHICULO_WHERE);

		query.append(_FINDER_COLUMN_CLIENTEID_CLIENTEID_2);

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
			query.append(ClienteVehiculoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clienteId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						clienteVehiculo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ClienteVehiculo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cliente vehiculos where clienteId = &#63; from the database.
	 *
	 * @param clienteId the cliente ID
	 */
	@Override
	public void removeByClienteId(long clienteId) {
		for (ClienteVehiculo clienteVehiculo :
				findByClienteId(
					clienteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clienteVehiculo);
		}
	}

	/**
	 * Returns the number of cliente vehiculos where clienteId = &#63;.
	 *
	 * @param clienteId the cliente ID
	 * @return the number of matching cliente vehiculos
	 */
	@Override
	public int countByClienteId(long clienteId) {
		FinderPath finderPath = _finderPathCountByClienteId;

		Object[] finderArgs = new Object[] {clienteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTEVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_CLIENTEID_CLIENTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clienteId);

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

	private static final String _FINDER_COLUMN_CLIENTEID_CLIENTEID_2 =
		"clienteVehiculo.clienteId = ?";

	private FinderPath _finderPathWithPaginationFindByVehiculoId;
	private FinderPath _finderPathWithoutPaginationFindByVehiculoId;
	private FinderPath _finderPathCountByVehiculoId;

	/**
	 * Returns all the cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the matching cliente vehiculos
	 */
	@Override
	public List<ClienteVehiculo> findByVehiculoId(long vehiculoId) {
		return findByVehiculoId(
			vehiculoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end) {

		return findByVehiculoId(vehiculoId, start, end, null);
	}

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
	@Override
	public List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return findByVehiculoId(
			vehiculoId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ClienteVehiculo> findByVehiculoId(
		long vehiculoId, int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
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

		List<ClienteVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ClienteVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ClienteVehiculo clienteVehiculo : list) {
					if ((vehiculoId != clienteVehiculo.getVehiculoId())) {
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

			query.append(_SQL_SELECT_CLIENTEVEHICULO_WHERE);

			query.append(_FINDER_COLUMN_VEHICULOID_VEHICULOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ClienteVehiculoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehiculoId);

				if (!pagination) {
					list = (List<ClienteVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ClienteVehiculo>)QueryUtil.list(
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
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo findByVehiculoId_First(
			long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = fetchByVehiculoId_First(
			vehiculoId, orderByComparator);

		if (clienteVehiculo != null) {
			return clienteVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiculoId=");
		msg.append(vehiculoId);

		msg.append("}");

		throw new NoSuchClienteVehiculoException(msg.toString());
	}

	/**
	 * Returns the first cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByVehiculoId_First(
		long vehiculoId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		List<ClienteVehiculo> list = findByVehiculoId(
			vehiculoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo findByVehiculoId_Last(
			long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = fetchByVehiculoId_Last(
			vehiculoId, orderByComparator);

		if (clienteVehiculo != null) {
			return clienteVehiculo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiculoId=");
		msg.append(vehiculoId);

		msg.append("}");

		throw new NoSuchClienteVehiculoException(msg.toString());
	}

	/**
	 * Returns the last cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cliente vehiculo, or <code>null</code> if a matching cliente vehiculo could not be found
	 */
	@Override
	public ClienteVehiculo fetchByVehiculoId_Last(
		long vehiculoId, OrderByComparator<ClienteVehiculo> orderByComparator) {

		int count = countByVehiculoId(vehiculoId);

		if (count == 0) {
			return null;
		}

		List<ClienteVehiculo> list = findByVehiculoId(
			vehiculoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cliente vehiculos before and after the current cliente vehiculo in the ordered set where vehiculoId = &#63;.
	 *
	 * @param clienteVehiculoId the primary key of the current cliente vehiculo
	 * @param vehiculoId the vehiculo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo[] findByVehiculoId_PrevAndNext(
			long clienteVehiculoId, long vehiculoId,
			OrderByComparator<ClienteVehiculo> orderByComparator)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = findByPrimaryKey(clienteVehiculoId);

		Session session = null;

		try {
			session = openSession();

			ClienteVehiculo[] array = new ClienteVehiculoImpl[3];

			array[0] = getByVehiculoId_PrevAndNext(
				session, clienteVehiculo, vehiculoId, orderByComparator, true);

			array[1] = clienteVehiculo;

			array[2] = getByVehiculoId_PrevAndNext(
				session, clienteVehiculo, vehiculoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ClienteVehiculo getByVehiculoId_PrevAndNext(
		Session session, ClienteVehiculo clienteVehiculo, long vehiculoId,
		OrderByComparator<ClienteVehiculo> orderByComparator,
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

		query.append(_SQL_SELECT_CLIENTEVEHICULO_WHERE);

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
			query.append(ClienteVehiculoModelImpl.ORDER_BY_JPQL);
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
						clienteVehiculo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ClienteVehiculo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cliente vehiculos where vehiculoId = &#63; from the database.
	 *
	 * @param vehiculoId the vehiculo ID
	 */
	@Override
	public void removeByVehiculoId(long vehiculoId) {
		for (ClienteVehiculo clienteVehiculo :
				findByVehiculoId(
					vehiculoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clienteVehiculo);
		}
	}

	/**
	 * Returns the number of cliente vehiculos where vehiculoId = &#63;.
	 *
	 * @param vehiculoId the vehiculo ID
	 * @return the number of matching cliente vehiculos
	 */
	@Override
	public int countByVehiculoId(long vehiculoId) {
		FinderPath finderPath = _finderPathCountByVehiculoId;

		Object[] finderArgs = new Object[] {vehiculoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTEVEHICULO_WHERE);

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
		"clienteVehiculo.vehiculoId = ?";

	public ClienteVehiculoPersistenceImpl() {
		setModelClass(ClienteVehiculo.class);

		setModelImplClass(ClienteVehiculoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cliente vehiculo in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 */
	@Override
	public void cacheResult(ClienteVehiculo clienteVehiculo) {
		entityCache.putResult(
			entityCacheEnabled, ClienteVehiculoImpl.class,
			clienteVehiculo.getPrimaryKey(), clienteVehiculo);

		finderCache.putResult(
			_finderPathFetchByClienteIdConcesionarioIdVehiculoId,
			new Object[] {
				clienteVehiculo.getClienteId(),
				clienteVehiculo.getConcesionarioId(),
				clienteVehiculo.getVehiculoId()
			},
			clienteVehiculo);

		clienteVehiculo.resetOriginalValues();
	}

	/**
	 * Caches the cliente vehiculos in the entity cache if it is enabled.
	 *
	 * @param clienteVehiculos the cliente vehiculos
	 */
	@Override
	public void cacheResult(List<ClienteVehiculo> clienteVehiculos) {
		for (ClienteVehiculo clienteVehiculo : clienteVehiculos) {
			if (entityCache.getResult(
					entityCacheEnabled, ClienteVehiculoImpl.class,
					clienteVehiculo.getPrimaryKey()) == null) {

				cacheResult(clienteVehiculo);
			}
			else {
				clienteVehiculo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cliente vehiculos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClienteVehiculoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cliente vehiculo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClienteVehiculo clienteVehiculo) {
		entityCache.removeResult(
			entityCacheEnabled, ClienteVehiculoImpl.class,
			clienteVehiculo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ClienteVehiculoModelImpl)clienteVehiculo, true);
	}

	@Override
	public void clearCache(List<ClienteVehiculo> clienteVehiculos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClienteVehiculo clienteVehiculo : clienteVehiculos) {
			entityCache.removeResult(
				entityCacheEnabled, ClienteVehiculoImpl.class,
				clienteVehiculo.getPrimaryKey());

			clearUniqueFindersCache(
				(ClienteVehiculoModelImpl)clienteVehiculo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ClienteVehiculoModelImpl clienteVehiculoModelImpl) {

		Object[] args = new Object[] {
			clienteVehiculoModelImpl.getClienteId(),
			clienteVehiculoModelImpl.getConcesionarioId(),
			clienteVehiculoModelImpl.getVehiculoId()
		};

		finderCache.putResult(
			_finderPathCountByClienteIdConcesionarioIdVehiculoId, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByClienteIdConcesionarioIdVehiculoId, args,
			clienteVehiculoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ClienteVehiculoModelImpl clienteVehiculoModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				clienteVehiculoModelImpl.getClienteId(),
				clienteVehiculoModelImpl.getConcesionarioId(),
				clienteVehiculoModelImpl.getVehiculoId()
			};

			finderCache.removeResult(
				_finderPathCountByClienteIdConcesionarioIdVehiculoId, args);
			finderCache.removeResult(
				_finderPathFetchByClienteIdConcesionarioIdVehiculoId, args);
		}

		if ((clienteVehiculoModelImpl.getColumnBitmask() &
			 _finderPathFetchByClienteIdConcesionarioIdVehiculoId.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				clienteVehiculoModelImpl.getOriginalClienteId(),
				clienteVehiculoModelImpl.getOriginalConcesionarioId(),
				clienteVehiculoModelImpl.getOriginalVehiculoId()
			};

			finderCache.removeResult(
				_finderPathCountByClienteIdConcesionarioIdVehiculoId, args);
			finderCache.removeResult(
				_finderPathFetchByClienteIdConcesionarioIdVehiculoId, args);
		}
	}

	/**
	 * Creates a new cliente vehiculo with the primary key. Does not add the cliente vehiculo to the database.
	 *
	 * @param clienteVehiculoId the primary key for the new cliente vehiculo
	 * @return the new cliente vehiculo
	 */
	@Override
	public ClienteVehiculo create(long clienteVehiculoId) {
		ClienteVehiculo clienteVehiculo = new ClienteVehiculoImpl();

		clienteVehiculo.setNew(true);
		clienteVehiculo.setPrimaryKey(clienteVehiculoId);

		return clienteVehiculo;
	}

	/**
	 * Removes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo remove(long clienteVehiculoId)
		throws NoSuchClienteVehiculoException {

		return remove((Serializable)clienteVehiculoId);
	}

	/**
	 * Removes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo remove(Serializable primaryKey)
		throws NoSuchClienteVehiculoException {

		Session session = null;

		try {
			session = openSession();

			ClienteVehiculo clienteVehiculo = (ClienteVehiculo)session.get(
				ClienteVehiculoImpl.class, primaryKey);

			if (clienteVehiculo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClienteVehiculoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clienteVehiculo);
		}
		catch (NoSuchClienteVehiculoException nsee) {
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
	protected ClienteVehiculo removeImpl(ClienteVehiculo clienteVehiculo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clienteVehiculo)) {
				clienteVehiculo = (ClienteVehiculo)session.get(
					ClienteVehiculoImpl.class,
					clienteVehiculo.getPrimaryKeyObj());
			}

			if (clienteVehiculo != null) {
				session.delete(clienteVehiculo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clienteVehiculo != null) {
			clearCache(clienteVehiculo);
		}

		return clienteVehiculo;
	}

	@Override
	public ClienteVehiculo updateImpl(ClienteVehiculo clienteVehiculo) {
		boolean isNew = clienteVehiculo.isNew();

		if (!(clienteVehiculo instanceof ClienteVehiculoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clienteVehiculo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					clienteVehiculo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clienteVehiculo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ClienteVehiculo implementation " +
					clienteVehiculo.getClass());
		}

		ClienteVehiculoModelImpl clienteVehiculoModelImpl =
			(ClienteVehiculoModelImpl)clienteVehiculo;

		Session session = null;

		try {
			session = openSession();

			if (clienteVehiculo.isNew()) {
				session.save(clienteVehiculo);

				clienteVehiculo.setNew(false);
			}
			else {
				clienteVehiculo = (ClienteVehiculo)session.merge(
					clienteVehiculo);
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
				clienteVehiculoModelImpl.getClienteId()
			};

			finderCache.removeResult(_finderPathCountByClienteId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClienteId, args);

			args = new Object[] {clienteVehiculoModelImpl.getVehiculoId()};

			finderCache.removeResult(_finderPathCountByVehiculoId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVehiculoId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((clienteVehiculoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClienteId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					clienteVehiculoModelImpl.getOriginalClienteId()
				};

				finderCache.removeResult(_finderPathCountByClienteId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClienteId, args);

				args = new Object[] {clienteVehiculoModelImpl.getClienteId()};

				finderCache.removeResult(_finderPathCountByClienteId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClienteId, args);
			}

			if ((clienteVehiculoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVehiculoId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					clienteVehiculoModelImpl.getOriginalVehiculoId()
				};

				finderCache.removeResult(_finderPathCountByVehiculoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVehiculoId, args);

				args = new Object[] {clienteVehiculoModelImpl.getVehiculoId()};

				finderCache.removeResult(_finderPathCountByVehiculoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVehiculoId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ClienteVehiculoImpl.class,
			clienteVehiculo.getPrimaryKey(), clienteVehiculo, false);

		clearUniqueFindersCache(clienteVehiculoModelImpl, false);
		cacheUniqueFindersCache(clienteVehiculoModelImpl);

		clienteVehiculo.resetOriginalValues();

		return clienteVehiculo;
	}

	/**
	 * Returns the cliente vehiculo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClienteVehiculoException {

		ClienteVehiculo clienteVehiculo = fetchByPrimaryKey(primaryKey);

		if (clienteVehiculo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClienteVehiculoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clienteVehiculo;
	}

	/**
	 * Returns the cliente vehiculo with the primary key or throws a <code>NoSuchClienteVehiculoException</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws NoSuchClienteVehiculoException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo findByPrimaryKey(long clienteVehiculoId)
		throws NoSuchClienteVehiculoException {

		return findByPrimaryKey((Serializable)clienteVehiculoId);
	}

	/**
	 * Returns the cliente vehiculo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo, or <code>null</code> if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo fetchByPrimaryKey(long clienteVehiculoId) {
		return fetchByPrimaryKey((Serializable)clienteVehiculoId);
	}

	/**
	 * Returns all the cliente vehiculos.
	 *
	 * @return the cliente vehiculos
	 */
	@Override
	public List<ClienteVehiculo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ClienteVehiculo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ClienteVehiculo> findAll(
		int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ClienteVehiculo> findAll(
		int start, int end,
		OrderByComparator<ClienteVehiculo> orderByComparator,
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

		List<ClienteVehiculo> list = null;

		if (retrieveFromCache) {
			list = (List<ClienteVehiculo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLIENTEVEHICULO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTEVEHICULO;

				if (pagination) {
					sql = sql.concat(ClienteVehiculoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClienteVehiculo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ClienteVehiculo>)QueryUtil.list(
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
	 * Removes all the cliente vehiculos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClienteVehiculo clienteVehiculo : findAll()) {
			remove(clienteVehiculo);
		}
	}

	/**
	 * Returns the number of cliente vehiculos.
	 *
	 * @return the number of cliente vehiculos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLIENTEVEHICULO);

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
		return "clienteVehiculoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENTEVEHICULO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClienteVehiculoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cliente vehiculo persistence.
	 */
	@Activate
	public void activate() {
		ClienteVehiculoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClienteVehiculoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByClienteIdConcesionarioIdVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByClienteIdConcesionarioIdVehiculoId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ClienteVehiculoModelImpl.CLIENTEID_COLUMN_BITMASK |
			ClienteVehiculoModelImpl.CONCESIONARIOID_COLUMN_BITMASK |
			ClienteVehiculoModelImpl.VEHICULOID_COLUMN_BITMASK);

		_finderPathCountByClienteIdConcesionarioIdVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClienteIdConcesionarioIdVehiculoId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByClienteId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClienteId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClienteId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClienteId",
			new String[] {Long.class.getName()},
			ClienteVehiculoModelImpl.CLIENTEID_COLUMN_BITMASK);

		_finderPathCountByClienteId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClienteId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVehiculoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteVehiculoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVehiculoId",
			new String[] {Long.class.getName()},
			ClienteVehiculoModelImpl.VEHICULOID_COLUMN_BITMASK);

		_finderPathCountByVehiculoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVehiculoId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ClienteVehiculoImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo"),
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

	private static final String _SQL_SELECT_CLIENTEVEHICULO =
		"SELECT clienteVehiculo FROM ClienteVehiculo clienteVehiculo";

	private static final String _SQL_SELECT_CLIENTEVEHICULO_WHERE =
		"SELECT clienteVehiculo FROM ClienteVehiculo clienteVehiculo WHERE ";

	private static final String _SQL_COUNT_CLIENTEVEHICULO =
		"SELECT COUNT(clienteVehiculo) FROM ClienteVehiculo clienteVehiculo";

	private static final String _SQL_COUNT_CLIENTEVEHICULO_WHERE =
		"SELECT COUNT(clienteVehiculo) FROM ClienteVehiculo clienteVehiculo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clienteVehiculo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClienteVehiculo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ClienteVehiculo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClienteVehiculoPersistenceImpl.class);

}