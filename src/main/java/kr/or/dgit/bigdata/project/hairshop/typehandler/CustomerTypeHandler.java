package kr.or.dgit.bigdata.project.hairshop.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public class CustomerTypeHandler extends BaseTypeHandler<Customer> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Customer parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getcNo());
		
	}

	@Override
	public Customer getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new Customer(rs.getInt(columnName));
	}

	@Override
	public Customer getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new Customer(rs.getInt(columnIndex));
	}

	@Override
	public Customer getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new Customer(cs.getInt(columnIndex));
	}

}
