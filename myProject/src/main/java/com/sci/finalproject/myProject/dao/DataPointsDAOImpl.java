package com.sci.finalproject.myProject.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sci.finalproject.myProject.model.DataPointsModel;
import com.sci.finalproject.myProject.service.DataPointsMapper;

public class DataPointsDAOImpl implements DataPointsDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public List<DataPointsModel> getDataPoints() {
		String SQL = "select * from canvasjs_db.datapoints";
		List<DataPointsModel> dataPoints = jdbcTemplateObject.query(SQL, new DataPointsMapper());
		return dataPoints;
	}
}
