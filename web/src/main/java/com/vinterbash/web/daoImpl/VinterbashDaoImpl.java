package com.vinterbash.web.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vinterbash.web.dao.VinterbashDao;
import com.vinterbash.web.model.Organizer;
import com.vinterbash.web.model.Result;
import com.vinterbash.web.utils.CommonQueries;

@Repository
public class VinterbashDaoImpl implements VinterbashDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertOrganizer(Organizer org) {
		MapSqlParameterSource params = new MapSqlParameterSource().addValue("organizerId", org.getOrganizerId())
				.addValue("organizerName", org.getOrganizerName()).addValue("password", org.getPassword())
				.addValue("yearOfPassing", org.getYearOfPassing()).addValue("qualification", org.getQualification())
				.addValue("contactNumber", org.getContactNumber());

		return jdbcTemplate.update(CommonQueries.INSERT_ORGANIZER, params);
	}

	@Override
	public String validateOrganizer(Organizer org) {
		String sql = CommonQueries.VALIDATE_ORGANIZER;
		Map<String, Object> params = new HashMap<>();
		params.put("organizerId", org.getOrganizerId());

		try {
			String password = jdbcTemplate.queryForObject(sql, params, String.class);
			return password;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int insertResult(Result res) {
		MapSqlParameterSource params = new MapSqlParameterSource().addValue("schoolName", res.getSchoolName())
				.addValue("eventName", res.getEventName()).addValue("eventPlace", res.getEventPlace())
				.addValue("eventPoints", res.getEventPoints());

		return jdbcTemplate.update(CommonQueries.INSERT_RESULT, params);
	}

	public List<Result> getLeaderboard() {
		String sql = CommonQueries.LEADERBOARD;
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Result.class));
	}

}
