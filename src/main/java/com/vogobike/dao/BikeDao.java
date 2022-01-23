package com.vogobike.dao;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.vogobike.bo.BikeBo;

public class BikeDao {
	private final String SQL_GET_BIKES = "select bike_no, bike_model_nm, manufacturer, rta_registration_no, price from bike order by bike_model_nm";
	private JdbcTemplate jdbcTemplate;

	public BikeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BikeBo> getBikes() {
		return jdbcTemplate.query(SQL_GET_BIKES, (rs, rowNum) -> {
			BikeBo bo = null;
			bo = new BikeBo();

			bo.setBikeNo(rs.getInt(1));
			bo.setBikeModelName(rs.getString(2));
			bo.setManufacturer(rs.getString(3));
			bo.setRtaRegistrationNo(rs.getString(4));
			bo.setPrice(rs.getDouble(5));
			return bo;
		});
	}
}
