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

import com.dbsystem.cotizatuvehiculo.model.Ciudades;
import com.dbsystem.cotizatuvehiculo.service.CiudadesLocalService;
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
 * Provides the base implementation for the ciudades local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dbsystem.cotizatuvehiculo.service.impl.CiudadesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dbsystem.cotizatuvehiculo.service.impl.CiudadesLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class CiudadesLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CiudadesLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CiudadesLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dbsystem.cotizatuvehiculo.service.CiudadesLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ciudades to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ciudades addCiudades(Ciudades ciudades) {
		ciudades.setNew(true);

		return ciudadesPersistence.update(ciudades);
	}

	/**
	 * Creates a new ciudades with the primary key. Does not add the ciudades to the database.
	 *
	 * @param ciudadId the primary key for the new ciudades
	 * @return the new ciudades
	 */
	@Override
	@Transactional(enabled = false)
	public Ciudades createCiudades(long ciudadId) {
		return ciudadesPersistence.create(ciudadId);
	}

	/**
	 * Deletes the ciudades with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades that was removed
	 * @throws PortalException if a ciudades with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ciudades deleteCiudades(long ciudadId) throws PortalException {
		return ciudadesPersistence.remove(ciudadId);
	}

	/**
	 * Deletes the ciudades from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ciudades deleteCiudades(Ciudades ciudades) {
		return ciudadesPersistence.remove(ciudades);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Ciudades.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ciudadesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ciudadesPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return ciudadesPersistence.findWithDynamicQuery(
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
		return ciudadesPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ciudadesPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Ciudades fetchCiudades(long ciudadId) {
		return ciudadesPersistence.fetchByPrimaryKey(ciudadId);
	}

	/**
	 * Returns the ciudades with the primary key.
	 *
	 * @param ciudadId the primary key of the ciudades
	 * @return the ciudades
	 * @throws PortalException if a ciudades with the primary key could not be found
	 */
	@Override
	public Ciudades getCiudades(long ciudadId) throws PortalException {
		return ciudadesPersistence.findByPrimaryKey(ciudadId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ciudadesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ciudades.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ciudadId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ciudadesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Ciudades.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("ciudadId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ciudadesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ciudades.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ciudadId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ciudadesLocalService.deleteCiudades((Ciudades)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ciudadesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ciudadeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.dbsystem.cotizatuvehiculo.model.impl.CiudadesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ciudadeses
	 * @param end the upper bound of the range of ciudadeses (not inclusive)
	 * @return the range of ciudadeses
	 */
	@Override
	public List<Ciudades> getCiudadeses(int start, int end) {
		return ciudadesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ciudadeses.
	 *
	 * @return the number of ciudadeses
	 */
	@Override
	public int getCiudadesesCount() {
		return ciudadesPersistence.countAll();
	}

	/**
	 * Updates the ciudades in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ciudades the ciudades
	 * @return the ciudades that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ciudades updateCiudades(Ciudades ciudades) {
		return ciudadesPersistence.update(ciudades);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CiudadesLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ciudadesLocalService = (CiudadesLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CiudadesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Ciudades.class;
	}

	protected String getModelClassName() {
		return Ciudades.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ciudadesPersistence.getDataSource();

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

	protected CiudadesLocalService ciudadesLocalService;

	@Reference
	protected CiudadesPersistence ciudadesPersistence;

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