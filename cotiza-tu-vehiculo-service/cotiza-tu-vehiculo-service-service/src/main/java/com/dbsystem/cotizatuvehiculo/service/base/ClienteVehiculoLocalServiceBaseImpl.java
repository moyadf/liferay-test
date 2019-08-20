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

import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;
import com.dbsystem.cotizatuvehiculo.service.ClienteVehiculoLocalService;
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
 * Provides the base implementation for the cliente vehiculo local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dbsystem.cotizatuvehiculo.service.impl.ClienteVehiculoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dbsystem.cotizatuvehiculo.service.impl.ClienteVehiculoLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class ClienteVehiculoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ClienteVehiculoLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ClienteVehiculoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.ClienteVehiculoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cliente vehiculo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ClienteVehiculo addClienteVehiculo(ClienteVehiculo clienteVehiculo) {
		clienteVehiculo.setNew(true);

		return clienteVehiculoPersistence.update(clienteVehiculo);
	}

	/**
	 * Creates a new cliente vehiculo with the primary key. Does not add the cliente vehiculo to the database.
	 *
	 * @param clienteVehiculoId the primary key for the new cliente vehiculo
	 * @return the new cliente vehiculo
	 */
	@Override
	@Transactional(enabled = false)
	public ClienteVehiculo createClienteVehiculo(long clienteVehiculoId) {
		return clienteVehiculoPersistence.create(clienteVehiculoId);
	}

	/**
	 * Deletes the cliente vehiculo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 * @throws PortalException if a cliente vehiculo with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ClienteVehiculo deleteClienteVehiculo(long clienteVehiculoId)
		throws PortalException {

		return clienteVehiculoPersistence.remove(clienteVehiculoId);
	}

	/**
	 * Deletes the cliente vehiculo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ClienteVehiculo deleteClienteVehiculo(
		ClienteVehiculo clienteVehiculo) {

		return clienteVehiculoPersistence.remove(clienteVehiculo);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ClienteVehiculo.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return clienteVehiculoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return clienteVehiculoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return clienteVehiculoPersistence.findWithDynamicQuery(
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
		return clienteVehiculoPersistence.countWithDynamicQuery(dynamicQuery);
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

		return clienteVehiculoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ClienteVehiculo fetchClienteVehiculo(long clienteVehiculoId) {
		return clienteVehiculoPersistence.fetchByPrimaryKey(clienteVehiculoId);
	}

	/**
	 * Returns the cliente vehiculo with the primary key.
	 *
	 * @param clienteVehiculoId the primary key of the cliente vehiculo
	 * @return the cliente vehiculo
	 * @throws PortalException if a cliente vehiculo with the primary key could not be found
	 */
	@Override
	public ClienteVehiculo getClienteVehiculo(long clienteVehiculoId)
		throws PortalException {

		return clienteVehiculoPersistence.findByPrimaryKey(clienteVehiculoId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(clienteVehiculoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ClienteVehiculo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("clienteVehiculoId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			clienteVehiculoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ClienteVehiculo.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"clienteVehiculoId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(clienteVehiculoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ClienteVehiculo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("clienteVehiculoId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return clienteVehiculoLocalService.deleteClienteVehiculo(
			(ClienteVehiculo)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return clienteVehiculoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cliente vehiculos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.ClienteVehiculoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cliente vehiculos
	 * @param end the upper bound of the range of cliente vehiculos (not inclusive)
	 * @return the range of cliente vehiculos
	 */
	@Override
	public List<ClienteVehiculo> getClienteVehiculos(int start, int end) {
		return clienteVehiculoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cliente vehiculos.
	 *
	 * @return the number of cliente vehiculos
	 */
	@Override
	public int getClienteVehiculosCount() {
		return clienteVehiculoPersistence.countAll();
	}

	/**
	 * Updates the cliente vehiculo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param clienteVehiculo the cliente vehiculo
	 * @return the cliente vehiculo that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ClienteVehiculo updateClienteVehiculo(
		ClienteVehiculo clienteVehiculo) {

		return clienteVehiculoPersistence.update(clienteVehiculo);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ClienteVehiculoLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		clienteVehiculoLocalService = (ClienteVehiculoLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ClienteVehiculoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ClienteVehiculo.class;
	}

	protected String getModelClassName() {
		return ClienteVehiculo.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = clienteVehiculoPersistence.getDataSource();

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

	@Reference
	protected ClientePersistence clientePersistence;

	protected ClienteVehiculoLocalService clienteVehiculoLocalService;

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