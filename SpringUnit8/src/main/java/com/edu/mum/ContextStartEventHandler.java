package com.edu.mum;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
	private final static Logger LOGGER = Logger.getLogger(ContextStartedEvent.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		try {
			createTable("IOWA_GROUP", "create table IOWA_GROUP(id bigint PRIMARY"
					+ " key generated always as identity(start with 1, increment by 1), " + " name varchar(100))"

			);

			createTable("IOWA_USER",
					"create table IOWA_USER (username varchar(100) primary key, " + "password varchar(100), "
							+ "email varchar(100), " + "age Integer, " + "groupId bigint, "
							+ "constraint group_fk foreign key(groupId) references IOWA_GROUP(id))");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

	}

	private void createTable(String name, String script) throws SQLException {
		DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
		ResultSet resultSet = dbmd.getTables(null, null, name, null);
		if (resultSet.next()) {
			LOGGER.info("Table " + resultSet.getString("TABLE_NAME") + " already exists!");
			return;
		}
		dataSource.getConnection().createStatement().executeUpdate(script);
	}

}
