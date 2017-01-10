package kr.or.dgit.bigdata.project.hairshop.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;
import kr.or.dgit.bigdata.project.hairshop.dto.HairEvent;
import kr.or.dgit.bigdata.project.hairshop.dto.Hairinfo;

public class HairEventTypeHandler extends BaseTypeHandler<HairEvent> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, HairEvent parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.geteNo());
		
	}

	@Override
	public HairEvent getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new HairEvent(rs.getInt(columnName));
	}

	@Override
	public HairEvent getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new HairEvent(rs.getInt(columnIndex));
	}

	@Override
	public HairEvent getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new HairEvent(cs.getInt(columnIndex));
	}

}
