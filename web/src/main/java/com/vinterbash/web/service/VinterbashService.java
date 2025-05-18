package com.vinterbash.web.service;

import java.util.List;
import java.util.Map;

import com.vinterbash.web.model.Organizer;
import com.vinterbash.web.model.Result;

public interface VinterbashService {
	public int insertOrganizer(Organizer org) throws Exception;
	public int validateOrganizer(Organizer org) throws Exception;
	public int insertResult(Result res) throws Exception;
	public Map<String, List<Map<String, Object>>> getLeaderboard();
}
