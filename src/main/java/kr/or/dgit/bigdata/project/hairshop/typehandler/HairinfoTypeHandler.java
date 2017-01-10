package kr.or.dgit.bigdata.project.hairshop.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;

public class HairinfoTypeHandler extends BaseTypeHandler<Hairinfo> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Hairinfo parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.gethNo());
		
	}

	@Override
	public Hairinfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new Hairinfo(rs.getInt(columnName));
	}

	@Override
	public Hairinfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new Hairinfo(rs.getInt(columnIndex));
	}

	@Override
	public Hairinfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new Hairinfo(cs.getInt(columnIndex));
	}

}
