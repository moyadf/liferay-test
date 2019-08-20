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

package com.dbsystem.cotizatuvehiculo.model.impl;

import com.dbsystem.cotizatuvehiculo.model.Vehiculo;
import com.dbsystem.cotizatuvehiculo.model.VehiculoModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Vehiculo service. Represents a row in the &quot;dbsystem_Vehiculo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>VehiculoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VehiculoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VehiculoImpl
 * @generated
 */
@ProviderType
public class VehiculoModelImpl
	extends BaseModelImpl<Vehiculo> implements VehiculoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vehiculo model instance should use the <code>Vehiculo</code> interface instead.
	 */
	public static final String TABLE_NAME = "dbsystem_Vehiculo";

	public static final Object[][] TABLE_COLUMNS = {
		{"vehiculoId", Types.BIGINT}, {"vehiculo", Types.VARCHAR},
		{"estado", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("vehiculoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("vehiculo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("estado", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dbsystem_Vehiculo (vehiculoId LONG not null primary key,vehiculo VARCHAR(75) null,estado BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table dbsystem_Vehiculo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY vehiculo.vehiculoId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dbsystem_Vehiculo.vehiculoId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public VehiculoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _vehiculoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVehiculoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vehiculoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Vehiculo.class;
	}

	@Override
	public String getModelClassName() {
		return Vehiculo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Vehiculo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Vehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vehiculo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Vehiculo)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Vehiculo, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Vehiculo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Vehiculo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Vehiculo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Vehiculo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Vehiculo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Vehiculo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Vehiculo, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Vehiculo, Object>>();
		Map<String, BiConsumer<Vehiculo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Vehiculo, ?>>();

		attributeGetterFunctions.put("vehiculoId", Vehiculo::getVehiculoId);
		attributeSetterBiConsumers.put(
			"vehiculoId", (BiConsumer<Vehiculo, Long>)Vehiculo::setVehiculoId);
		attributeGetterFunctions.put("vehiculo", Vehiculo::getVehiculo);
		attributeSetterBiConsumers.put(
			"vehiculo", (BiConsumer<Vehiculo, String>)Vehiculo::setVehiculo);
		attributeGetterFunctions.put("estado", Vehiculo::getEstado);
		attributeSetterBiConsumers.put(
			"estado", (BiConsumer<Vehiculo, Boolean>)Vehiculo::setEstado);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getVehiculoId() {
		return _vehiculoId;
	}

	@Override
	public void setVehiculoId(long vehiculoId) {
		_vehiculoId = vehiculoId;
	}

	@Override
	public String getVehiculo() {
		if (_vehiculo == null) {
			return "";
		}
		else {
			return _vehiculo;
		}
	}

	@Override
	public void setVehiculo(String vehiculo) {
		_vehiculo = vehiculo;
	}

	@Override
	public boolean getEstado() {
		return _estado;
	}

	@Override
	public boolean isEstado() {
		return _estado;
	}

	@Override
	public void setEstado(boolean estado) {
		_estado = estado;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Vehiculo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Vehiculo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Vehiculo)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VehiculoImpl vehiculoImpl = new VehiculoImpl();

		vehiculoImpl.setVehiculoId(getVehiculoId());
		vehiculoImpl.setVehiculo(getVehiculo());
		vehiculoImpl.setEstado(isEstado());

		vehiculoImpl.resetOriginalValues();

		return vehiculoImpl;
	}

	@Override
	public int compareTo(Vehiculo vehiculo) {
		long primaryKey = vehiculo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Vehiculo)) {
			return false;
		}

		Vehiculo vehiculo = (Vehiculo)obj;

		long primaryKey = vehiculo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Vehiculo> toCacheModel() {
		VehiculoCacheModel vehiculoCacheModel = new VehiculoCacheModel();

		vehiculoCacheModel.vehiculoId = getVehiculoId();

		vehiculoCacheModel.vehiculo = getVehiculo();

		String vehiculo = vehiculoCacheModel.vehiculo;

		if ((vehiculo != null) && (vehiculo.length() == 0)) {
			vehiculoCacheModel.vehiculo = null;
		}

		vehiculoCacheModel.estado = isEstado();

		return vehiculoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Vehiculo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Vehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vehiculo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Vehiculo)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Vehiculo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Vehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vehiculo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Vehiculo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Vehiculo.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Vehiculo.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _vehiculoId;
	private String _vehiculo;
	private boolean _estado;
	private Vehiculo _escapedModel;

}