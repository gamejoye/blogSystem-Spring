package com.gamejoye.util.typeHandlers;

import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.UserInformation;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationHandler extends BaseTypeHandler<UserInformation> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserInformation userInformation, JdbcType jdbcType) throws SQLException {
        String value =  JSON.toJSONString(userInformation);
        ps.setString(i, value);
    }

    @Override
    public UserInformation getNullableResult(ResultSet rs, String s) throws SQLException {
        String res = rs.getString(s);
        if(res == null) {
            return null;
        }
        return JSON.parseObject(res, UserInformation.class);
    }

    @Override
    public UserInformation getNullableResult(ResultSet rs, int i) throws SQLException {
        String res = rs.getString(i);
        if(res == null) {
            return null;
        }
        return JSON.parseObject(res, UserInformation.class);
    }

    @Override
    public UserInformation getNullableResult(CallableStatement cs, int i) throws SQLException {
        String res = cs.getString(i);
        if(res == null) {
            return null;
        }
        return JSON.parseObject(res, UserInformation.class);
    }
}
