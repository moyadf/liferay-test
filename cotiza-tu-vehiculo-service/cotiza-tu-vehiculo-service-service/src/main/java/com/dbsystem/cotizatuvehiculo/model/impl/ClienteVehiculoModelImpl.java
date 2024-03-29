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

import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculo;
import com.dbsystem.cotizatuvehiculo.model.ClienteVehiculoModel;

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
 * The base model implementation for the ClienteVehiculo service. Represents a row in the &quot;dbsystem_ClienteVehiculo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ClienteVehiculoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ClienteVehiculoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClienteVehiculoImpl
 * @generated
 */
@ProviderType
public class ClienteVehiculoModelImpl
	extends BaseModelImpl<ClienteVehiculo> implements ClienteVehiculoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cliente vehiculo model instance should use the <code>ClienteVehiculo</code> interface instead.
	 */
	public static final String TABLE_NAME = "dbsystem_ClienteVehiculo";

	public static final Object[][] TABLE_COLUMNS = {
		{"clienteVehiculoId", Types.BIGINT}, {"clienteId", Types.BIGINT},
		{"concesionarioId", Types.BIGINT}, {"vehiculoId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("clienteVehiculoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("clienteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("concesionarioId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("vehiculoId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dbsystem_ClienteVehiculo (clienteVehiculoId LONG not null primary key,clienteId LONG,concesionarioId LONG,vehiculoId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table dbsystem_ClienteVehiculo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY clienteVehiculo.clienteVehiculoId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dbsystem_ClienteVehiculo.clienteVehiculoId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CLIENTEID_COLUMN_BITMASK = 1L;

	public static final long CONCESIONARIOID_COLUMN_BITMASK = 2L;

	public static final long VEHICULOID_COLUMN_BITMASK = 4L;

	public static final long CLIENTEVEHICULOID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public ClienteVehiculoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _clienteVehiculoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClienteVehiculoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clienteVehiculoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ClienteVehiculo.class;
	}

	@Override
	public String getModelClassName() {
		return ClienteVehiculo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ClienteVehiculo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ClienteVehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClienteVehiculo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ClienteVehiculo)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ClienteVehiculo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ClienteVehiculo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ClienteVehiculo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ClienteVehiculo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ClienteVehiculo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ClienteVehiculo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ClienteVehiculo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ClienteVehiculo, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ClienteVehiculo, Object>>();
		Map<String, BiConsumer<ClienteVehiculo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ClienteVehiculo, ?>>();

		attributeGetterFunctions.put(
			"clienteVehiculoId", ClienteVehiculo::getClienteVehiculoId);
		attributeSetterBiConsumers.put(
			"clienteVehiculoId",
			(BiConsumer<ClienteVehiculo, Long>)
				ClienteVehiculo::setClienteVehiculoId);
		attributeGetterFunctions.put(
			"clienteId", ClienteVehiculo::getClienteId);
		attributeSetterBiConsumers.put(
			"clienteId",
			(BiConsumer<ClienteVehiculo, Long>)ClienteVehiculo::setClienteId);
		attributeGetterFunctions.put(
			"concesionarioId", ClienteVehiculo::getConcesionarioId);
		attributeSetterBiConsumers.put(
			"concesionarioId",
			(BiConsumer<ClienteVehiculo, Long>)
				ClienteVehiculo::setConcesionarioId);
		attributeGetterFunctions.put(
			"vehiculoId", ClienteVehiculo::getVehiculoId);
		attributeSetterBiConsumers.put(
			"vehiculoId",
			(BiConsumer<ClienteVehiculo, Long>)ClienteVehiculo::setVehiculoId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getClienteVehiculoId() {
		return _clienteVehiculoId;
	}

	@Override
	public void setClienteVehiculoId(long clienteVehiculoId) {
		_clienteVehiculoId = clienteVehiculoId;
	}

	@Override
	public long getClienteId() {
		return _clienteId;
	}

	@Override
	public void setClienteId(long clienteId) {
		_columnBitmask |= CLIENTEID_COLUMN_BITMASK;

		if (!_setOriginalClienteId) {
			_setOriginalClienteId = true;

			_originalClienteId = _clienteId;
		}

		_clienteId = clienteId;
	}

	public long getOriginalClienteId() {
		return _originalClienteId;
	}

	@Override
	public long getConcesionarioId() {
		return _concesionarioId;
	}

	@Override
	public void setConcesionarioId(long concesionarioId) {
		_columnBitmask |= CONCESIONARIOID_COLUMN_BITMASK;

		if (!_setOriginalConcesionarioId) {
			_setOriginalConcesionarioId = true;

			_originalConcesionarioId = _concesionarioId;
		}

		_concesionarioId = concesionarioId;
	}

	public long getOriginalConcesionarioId() {
		return _originalConcesionarioId;
	}

	@Override
	public long getVehiculoId() {
		return _vehiculoId;
	}

	@Override
	public void setVehiculoId(long vehiculoId) {
		_columnBitmask |= VEHICULOID_COLUMN_BITMASK;

		if (!_setOriginalVehiculoId) {
			_setOriginalVehiculoId = true;

			_originalVehiculoId = _vehiculoId;
		}

		_vehiculoId = vehiculoId;
	}

	public long getOriginalVehiculoId() {
		return _originalVehiculoId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, ClienteVehiculo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ClienteVehiculo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ClienteVehiculo)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ClienteVehiculoImpl clienteVehiculoImpl = new ClienteVehiculoImpl();

		clienteVehiculoImpl.setClienteVehiculoId(getClienteVehiculoId());
		clienteVehiculoImpl.setClienteId(getClienteId());
		clienteVehiculoImpl.setConcesionarioId(getConcesionarioId());
		clienteVehiculoImpl.setVehiculoId(getVehiculoId());

		clienteVehiculoImpl.resetOriginalValues();

		return clienteVehiculoImpl;
	}

	@Override
	public int compareTo(ClienteVehiculo clienteVehiculo) {
		long primaryKey = clienteVehiculo.getPrimaryKey();

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

		if (!(obj instanceof ClienteVehiculo)) {
			return false;
		}

		ClienteVehiculo clienteVehiculo = (ClienteVehiculo)obj;

		long primaryKey = clienteVehiculo.getPrimaryKey();

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
		ClienteVehiculoModelImpl clienteVehiculoModelImpl = this;

		clienteVehiculoModelImpl._originalClienteId =
			clienteVehiculoModelImpl._clienteId;

		clienteVehiculoModelImpl._setOriginalClienteId = false;

		clienteVehiculoModelImpl._originalConcesionarioId =
			clienteVehiculoModelImpl._concesionarioId;

		clienteVehiculoModelImpl._setOriginalConcesionarioId = false;

		clienteVehiculoModelImpl._originalVehiculoId =
			clienteVehiculoModelImpl._vehiculoId;

		clienteVehiculoModelImpl._setOriginalVehiculoId = false;

		clienteVehiculoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ClienteVehiculo> toCacheModel() {
		ClienteVehiculoCacheModel clienteVehiculoCacheModel =
			new ClienteVehiculoCacheModel();

		clienteVehiculoCacheModel.clienteVehiculoId = getClienteVehiculoId();

		clienteVehiculoCacheModel.clienteId = getClienteId();

		clienteVehiculoCacheModel.concesionarioId = getConcesionarioId();

		clienteVehiculoCacheModel.vehiculoId = getVehiculoId();

		return clienteVehiculoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ClienteVehiculo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ClienteVehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClienteVehiculo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ClienteVehiculo)this));
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
		Map<String, Function<ClienteVehiculo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ClienteVehiculo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ClienteVehiculo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ClienteVehiculo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		ClienteVehiculo.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		ClienteVehiculo.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _clienteVehiculoId;
	private long _clienteId;
	private long _originalClienteId;
	private boolean _setOriginalClienteId;
	private long _concesionarioId;
	private long _originalConcesionarioId;
	private boolean _setOriginalConcesionarioId;
	private long _vehiculoId;
	private long _originalVehiculoId;
	private boolean _setOriginalVehiculoId;
	private long _columnBitmask;
	private ClienteVehiculo _escapedModel;

}