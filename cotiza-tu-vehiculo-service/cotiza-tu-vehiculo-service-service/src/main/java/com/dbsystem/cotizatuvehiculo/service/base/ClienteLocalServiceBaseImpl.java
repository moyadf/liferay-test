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

package com.dbsystem.cotizatuvehiculo.service.base;

import com.dbsystem.cotizatuvehiculo.model.Cliente;
import com.dbsystem.cotizatuvehiculo.service.ClienteLocalService;
import com.dbsystem.cotizatuvehiculo.service.persistence.CiudadesPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.ClientePersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.ClienteVehiculoPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.ConcesionarioVehiculoPersistence;
import com.dbsystem.cotizatuvehiculo.service.persistence.VehiculoPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cliente local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dbsystem.cotizatuvehiculo.service.impl.ClienteLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dbsystem.cotizatuvehiculo.service.impl.ClienteLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class ClienteLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ClienteLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ClienteLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.ClienteLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cliente to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cliente the cliente
	 * @return the cliente that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cliente addCliente(Cliente cliente) {
		cliente.setNew(true);

		return clientePersistence.update(cliente);
	}

	/**
	 * Creates a new cliente with the primary key. Does not add the cliente to the database.
	 *
	 * @param clienteId the primary key for the new cliente
	 * @return the new cliente
	 */
	@Override
	@Transactional(enabled = false)
	public Cliente createCliente(long clienteId) {
		return clientePersistence.create(clienteId);
	}

	/**
	 * Deletes the cliente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente that was removed
	 * @throws PortalException if a cliente with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cliente deleteCliente(long clienteId) throws PortalException {
		return clientePersistence.remove(clienteId);
	}

	/**
	 * Deletes the cliente from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cliente the cliente
	 * @return the cliente that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cliente deleteCliente(Cliente cliente) {
		return clientePersistence.remove(cliente);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Cliente.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return clientePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return clientePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return clientePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return clientePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return clientePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Cliente fetchCliente(long clienteId) {
		return clientePersistence.fetchByPrimaryKey(clienteId);
	}

	/**
	 * Returns the cliente with the primary key.
	 *
	 * @param clienteId the primary key of the cliente
	 * @return the cliente
	 * @throws PortalException if a cliente with the primary key could not be found
	 */
	@Override
	public Cliente getCliente(long clienteId) throws PortalException {
		return clientePersistence.findByPrimaryKey(clienteId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(clienteLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cliente.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("clienteId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			clienteLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Cliente.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("clienteId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(clienteLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cliente.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("clienteId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return clienteLocalService.deleteCliente((Cliente)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return clientePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the clientes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clientes
	 * @param end the upper bound of the range of clientes (not inclusive)
	 * @return the range of clientes
	 */
	@Override
	public List<Cliente> getClientes(int start, int end) {
		return clientePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of clientes.
	 *
	 * @return the number of clientes
	 */
	@Override
	public int getClientesCount() {
		return clientePersistence.countAll();
	}

	/**
	 * Updates the cliente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cliente the cliente
	 * @return the cliente that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clientePersistence.update(cliente);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ClienteLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		clienteLocalService = (ClienteLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ClienteLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Cliente.class;
	}

	protected String getModelClassName() {
		return Cliente.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = clientePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected CiudadesPersistence ciudadesPersistence;

	protected ClienteLocalService clienteLocalService;

	@Reference
	protected ClientePersistence clientePersistence;

	@Reference
	protected ClienteVehiculoPersistence clienteVehiculoPersistence;

	@Reference
	protected ConcesionarioPersistence concesionarioPersistence;

	@Reference
	protected ConcesionarioVehiculoPersistence concesionarioVehiculoPersistence;

	@Reference
	protected VehiculoPersistence vehiculoPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}