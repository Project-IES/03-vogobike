package com.vogobike.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.vogobike.bo.BikeBo;
import com.vogobike.dao.BikeDao;
import com.vogobike.dto.BikeDto;

public class ManageBikeService {
	private BikeDao bikeDao;

	public List<BikeDto> getBikes() {
		List<BikeBo> bikeBos = null;
		List<BikeDto> bikeDtos = null;

		bikeBos = bikeDao.getBikes();
		bikeDtos = new ArrayList<>();

		bikeDtos = bikeBos.stream().map((bo) -> {
			BikeDto dto = new BikeDto();
			dto.setBikeModelName(bo.getBikeModelName());
			dto.setManufacturer(bo.getManufacturer());
			dto.setPrice(bo.getPrice());
			return dto;
		}).collect(Collectors.toList());

		return bikeDtos;
	}

	public void setBikeDao(BikeDao bikeDao) {
		this.bikeDao = bikeDao;
	}
}
