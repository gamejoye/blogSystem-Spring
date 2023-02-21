package com.gamejoye.util.typeHandlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayTypeHandler extends BaseTypeHandler<JSONArray> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JSONArray parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public JSONArray getNullableResult(ResultSet rs, String s) throws SQLException {
        String json = rs.getString(s);
        if(json == null) {
            return null;
        }
        return JSON.parseArray(json);
    }

    @Override
    public JSONArray getNullableResult(ResultSet rs, int i) throws SQLException {
        String json = rs.getString(i);
        if(json == null) {
            return null;
        }
        return JSON.parseArray(json);
    }

    @Override
    public JSONArray getNullableResult(CallableStatement cs, int i) throws SQLException {
        String json = cs.getString(i);
        if(json == null) {
            return null;
        }
        return JSON.parseArray(json);
    }
}
