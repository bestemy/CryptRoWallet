package com.sci.finalproject.myProject.dao;

import java.util.List;
import com.sci.finalproject.myProject.model.DataPointsModel;
import javax.sql.DataSource;

public interface DataPointsDAO 
{
    public List<DataPointsModel> getDataPoints();
    public void setDataSource(DataSource ds);
}