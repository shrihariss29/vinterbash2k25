package com.vinterbash.web.dao;

import java.util.List;

import com.vinterbash.web.model.Organizer;
import com.vinterbash.web.model.Result;

public interface VinterbashDao {
	public int insertOrganizer(Organizer org);
	public String validateOrganizer(Organizer org);
	public int insertResult(Result res);
	public List<Result> getLeaderboard();
}
