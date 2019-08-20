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

import com.dbsystem.cotizatuvehiculo.exception.NoSuchClienteException;
import com.dbsystem.cotizatuvehiculo.model.Cliente;
import com.dbsystem.cotizatuvehiculo.model.impl.ClienteImpl;
import com.dbsystem.cotizatuvehiculo.model.impl.ClienteModelImpl;
import com.dbsystem.cotizatuvehiculo.service.persistence.ClientePersistence;
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
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cliente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClientePersistence.class)
@ProviderType
public class ClientePersistenceImpl
	extends BasePersistenceImpl<Cliente> implements ClientePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClienteUtil</code> to access the cliente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClienteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByIdentificacion;
	private FinderPath _finderPathCountByIdentificacion;

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente
	 * @throws NoSuchClienteException if a matching cliente could not be found
	 */
	@Override
	public Cliente findByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws NoSuchClienteException {

		Cliente cliente = fetchByIdentificacion(tipoDocumento, numeroDocumento);

		if (cliente == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tipoDocumento=");
			msg.append(tipoDocumento);

			msg.append(", numeroDocumento=");
			msg.append(numeroDocumento);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchClienteException(msg.toString());
		}

		return cliente;
	}

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	@Override
	public Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento) {

		return fetchByIdentificacion(tipoDocumento, numeroDocumento, true);
	}

	/**
	 * Returns the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cliente, or <code>null</code> if a matching cliente could not be found
	 */
	@Override
	public Cliente fetchByIdentificacion(
		long tipoDocumento, String numeroDocumento, boolean retrieveFromCache) {

		numeroDocumento = Objects.toString(numeroDocumento, "");

		Object[] finderArgs = new Object[] {tipoDocumento, numeroDocumento};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByIdentificacion, finderArgs, this);
		}

		if (result instanceof Cliente) {
			Cliente cliente = (Cliente)result;

			if ((tipoDocumento != cliente.getTipoDocumento()) ||
				!Objects.equals(
					numeroDocumento, cliente.getNumeroDocumento())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_IDENTIFICACION_TIPODOCUMENTO_2);

			boolean bindNumeroDocumento = false;

			if (numeroDocumento.isEmpty()) {
				query.append(_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_3);
			}
			else {
				bindNumeroDocumento = true;

				query.append(_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipoDocumento);

				if (bindNumeroDocumento) {
					qPos.add(numeroDocumento);
				}

				List<Cliente> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByIdentificacion, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ClientePersistenceImpl.fetchByIdentificacion(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Cliente cliente = list.get(0);

					result = cliente;

					cacheResult(cliente);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByIdentificacion, finderArgs);

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
			return (Cliente)result;
		}
	}

	/**
	 * Removes the cliente where tipoDocumento = &#63; and numeroDocumento = &#63; from the database.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the cliente that was removed
	 */
	@Override
	public Cliente removeByIdentificacion(
			long tipoDocumento, String numeroDocumento)
		throws NoSuchClienteException {

		Cliente cliente = findByIdentificacion(tipoDocumento, numeroDocumento);

		return remove(cliente);
	}

	/**
	 * Returns the number of clientes where tipoDocumento = &#63; and numeroDocumento = &#63;.
	 *
	 * @param tipoDocumento the tipo documento
	 * @param numeroDocumento the numero documento
	 * @return the number of matching clientes
	 */
	@Override
	public int countByIdentificacion(
		long tipoDocumento, String numeroDocumento) {

		numeroDocumento = Objects.toString(numeroDocumento, "");

		FinderPath finderPath = _finderPathCountByIdentificacion;

		Object[] finderArgs = new Object[] {tipoDocumento, numeroDocumento};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLIENTE_WHERE);

			query.append(_FINDER_COLUMN_IDENTIFICACION_TIPODOCUMENTO_2);

			boolean bindNumeroDocumento = false;

			if (numeroDocumento.isEmpty()) {
				query.append(_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_3);
			}
			else {
				bindNumeroDocumento = true;

				query.append(_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipoDocumento);

				if (bindNumeroDocumento) {
					qPos.add(numeroDocumento);
				}

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

	private static final String _FINDER_COLUMN_IDENTIFICACION_TIPODOCUMENTO_2 =
		"cliente.tipoDocumento = ? AND ";

	private static final String
		_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_2 =
			"cliente.numeroDocumento = ?";

	private static final String
		_FINDER_COLUMN_IDENTIFICACION_NUMERODOCUMENTO_3 =
			"(cliente.numeroDocumento IS NULL OR cliente.numeroDocumento = '')";

	public ClientePersistenceImpl() {
		setModelClass(Cliente.class);

		setModelImplClass(ClienteImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cliente in the entity cache if it is enabled.
	 *
	 * @param cliente the cliente
	 */
	@Override
	public void cacheResult(Cliente cliente) {
		entityCache.putResult(
			entityCacheEnabled, ClienteImpl.class, cliente.getPrimaryKey(),
			cliente);

		finderCache.putResult(
			_finderPathFetchByIdentificacion,
			new Object[] {
				cliente.getTipoDocumento(), cliente.getNumeroDocumento()
			},
			cliente);

		cliente.resetOriginalValues();
	}

	/**
	 * Caches the clientes in the entity cache if it is enabled.
	 *
	 * @param clientes the clientes
	 */
	@Override
	public void cacheResult(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			if (entityCache.getResult(
					entityCacheEnabled, ClienteImpl.class,
					cliente.getPrimaryKey()) == null) {

				cacheResult(cliente);
			}
			else {
				cliente.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clientes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClienteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cliente.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cliente cliente) {
		entityCache.removeResult(
			entityCacheEnabled, ClienteImpl.class, cliente.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ClienteModelImpl)cliente, true);
	}

	@Override
	public void clearCache(List<Cliente> clientes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cliente cliente : clientes) {
			entityCache.removeResult(
				entityCacheEnabled, ClienteImpl.class, cliente.getPrimaryKey());

			clearUniqueFindersCache((ClienteModelImpl)cliente, true);
		}
	}

	protected void cacheUniqueFindersCache(ClienteModelImpl clienteModelImpl) {
		Object[] args = new Object[] {
			clienteModelImpl.getTipoDocumento(),
			clienteModelImpl.getNumeroDocumento()
		};

		finderCache.putResult(
			_finderPathCountByIdentificacion, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByIdentificacion, args, clienteModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ClienteModelImpl clienteModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				clienteModelImpl.getTipoDocumento(),
				clienteModelImpl.getNumeroDocumento()
			};

			finderCache.removeResult(_finderPathCountByIdentificacion, args);
			finderCache.removeResult(_finderPathFetchByIdentificacion, args);
		}

		if ((clienteModelImpl.getColumnBitmask() &
			 _finderPathFetchByIdentificacion.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				clienteModelImpl.getOriginalTipoDocumento(),
				clienteModelImpl.getOriginalNumeroDocumento()
			};

			finderCache.removeResult(_finderPathCountByIdentificacion, args);
			finderCache.removeResult(_finderPathFetchByIdentificacion, args);
		}
	}

	/**
	 * Creates a new cliente with the primary key. Does not add the cliente to the database.
	 *
	 * @param clienteId the primary key for the new cliente
	 * @return the new cliente
	 */
	@Override
	public Cliente create(long clienteId) {
		Cliente cliente = new ClienteImpl();

		cliente.setNew(true);
		cliente.setPrimaryKey(clienteId);

		return cliente;
	}

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente remove(long clienteId) throws NoSuchClienteException {
		return remove((Serializable)clienteId);
	}

	/**
	 * Removes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente remove(Serializable primaryKey)
		throws NoSuchClienteException {

		Session session = null;

		try {
			session = openSession();

			Cliente cliente = (Cliente)session.get(
				ClienteImpl.class, primaryKey);

			if (cliente == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClienteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cliente);
		}
		catch (NoSuchClienteException nsee) {
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
	protected Cliente removeImpl(Cliente cliente) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cliente)) {
				cliente = (Cliente)session.get(
					ClienteImpl.class, cliente.getPrimaryKeyObj());
			}

			if (cliente != null) {
				session.delete(cliente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cliente != null) {
			clearCache(cliente);
		}

		return cliente;
	}

	@Override
	public Cliente updateImpl(Cliente cliente) {
		boolean isNew = cliente.isNew();

		if (!(cliente instanceof ClienteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cliente.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cliente);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cliente proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Cliente implementation " +
					cliente.getClass());
		}

		ClienteModelImpl clienteModelImpl = (ClienteModelImpl)cliente;

		Session session = null;

		try {
			session = openSession();

			if (cliente.isNew()) {
				session.save(cliente);

				cliente.setNew(false);
			}
			else {
				cliente = (Cliente)session.merge(cliente);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, ClienteImpl.class, cliente.getPrimaryKey(),
			cliente, false);

		clearUniqueFindersCache(clienteModelImpl, false);
		cacheUniqueFindersCache(clienteModelImpl);

		cliente.resetOriginalValues();

		return cliente;
	}

	/**
	 * Returns the cliente with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cliente
	 * @return the cliente
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClienteException {

		Cliente cliente = fetchByPrimaryKey(primaryKey);

		if (cliente == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClienteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cliente;
	}

	/**
	 * Returns the cliente with the primary key or throws a <code>NoSuchClienteException</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente
	 * @throws NoSuchClienteException if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente findByPrimaryKey(long clienteId)
		throws NoSuchClienteException {

		return findByPrimaryKey((Serializable)clienteId);
	}

	/**
	 * Returns the cliente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente, or <code>null</code> if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente fetchByPrimaryKey(long clienteId) {
		return fetchByPrimaryKey((Serializable)clienteId);
	}

	/**
	 * Returns all the clientes.
	 *
	 * @return the clientes
	 */
	@Override
	public List<Cliente> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of clientes
	 */
	@Override
	public List<Cliente> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clientes
	 */
	@Override
	public List<Cliente> findAll(
		int start, int end, OrderByComparator<Cliente> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of clientes
	 */
	@Override
	public List<Cliente> findAll(
		int start, int end, OrderByComparator<Cliente> orderByComparator,
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

		List<Cliente> list = null;

		if (retrieveFromCache) {
			list = (List<Cliente>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLIENTE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTE;

				if (pagination) {
					sql = sql.concat(ClienteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cliente>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Cliente>)QueryUtil.list(
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
	 * Removes all the clientes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Cliente cliente : findAll()) {
			remove(cliente);
		}
	}

	/**
	 * Returns the number of clientes.
	 *
	 * @return the number of clientes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLIENTE);

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
		return "clienteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLIENTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClienteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cliente persistence.
	 */
	@Activate
	public void activate() {
		ClienteModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ClienteModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByIdentificacion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ClienteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIdentificacion",
			new String[] {Long.class.getName(), String.class.getName()},
			ClienteModelImpl.TIPODOCUMENTO_COLUMN_BITMASK |
			ClienteModelImpl.NUMERODOCUMENTO_COLUMN_BITMASK);

		_finderPathCountByIdentificacion = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdentificacion",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ClienteImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.dbsystem.cotizatuvehiculo.model.Cliente"),
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

	private static final String _SQL_SELECT_CLIENTE =
		"SELECT cliente FROM Cliente cliente";

	private static final String _SQL_SELECT_CLIENTE_WHERE =
		"SELECT cliente FROM Cliente cliente WHERE ";

	private static final String _SQL_COUNT_CLIENTE =
		"SELECT COUNT(cliente) FROM Cliente cliente";

	private static final String _SQL_COUNT_CLIENTE_WHERE =
		"SELECT COUNT(cliente) FROM Cliente cliente WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cliente.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Cliente exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Cliente exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClientePersistenceImpl.class);

}