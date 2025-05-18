package com.vinterbash.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinterbash.web.dao.VinterbashDao;
import com.vinterbash.web.model.Organizer;
import com.vinterbash.web.model.Result;
import com.vinterbash.web.service.VinterbashService;
import com.vinterbash.web.utils.AESUtil;

@Service
public class VinterbashServiceImpl implements VinterbashService {
	VinterbashDao vinterbashDao;

	@Autowired
	public VinterbashServiceImpl(VinterbashDao vinterbashDao) {
		this.vinterbashDao = vinterbashDao;
	}

	@Override
	public int insertOrganizer(Organizer org) throws Exception {
		String encryptedPassword = AESUtil.encrypt(org.getPassword());
		org.setPassword(encryptedPassword);
		return vinterbashDao.insertOrganizer(org);
	}

	@Override
	public int validateOrganizer(Organizer org) throws Exception {
		String password = vinterbashDao.validateOrganizer(org);
		String decryptedPassword = AESUtil.decrypt(password);
		if (org.getPassword().equals(decryptedPassword)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int insertResult(Result res) throws Exception {
		return vinterbashDao.insertResult(res);
	}

	public Map<String, List<Map<String, Object>>> getLeaderboard() {
		List<Result> results = vinterbashDao.getLeaderboard();

		Map<String, List<Result>> groupedResults = results.stream()
				.collect(Collectors.groupingBy(Result::getSchoolName));

		Map<String, Integer> totalPointsMap = new HashMap<>();

		Map<String, List<Map<String, Object>>> responseMap = new HashMap<>();

		for (Map.Entry<String, List<Result>> entry : groupedResults.entrySet()) {
			String schoolName = entry.getKey();
			List<Result> schoolResults = entry.getValue();

			List<Map<String, Object>> eventsList = new ArrayList<>();
			int totalPoints = 0;

			for (Result r : schoolResults) {
				Map<String, Object> eventMap = new HashMap<>();
				eventMap.put("eventName", r.getEventName());
				eventMap.put("eventPlace", r.getEventPlace());
				eventMap.put("points", r.getEventPoints());
				eventsList.add(eventMap);

				totalPoints += r.getEventPoints();
			}

			responseMap.put(schoolName, eventsList);
			totalPointsMap.put(schoolName, totalPoints);
		}

		LinkedHashMap<String, List<Map<String, Object>>> sortedMap = new LinkedHashMap<>();

		responseMap.entrySet().stream()
		    .sorted((e1, e2) -> totalPointsMap.get(e2.getKey()) - totalPointsMap.get(e1.getKey()))
		    .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
		
		return sortedMap;
	}
}
