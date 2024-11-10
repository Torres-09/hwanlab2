package com.hwanlab2.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LabRepository {
	public String greeting(String greeting) {
		return greeting;
	}
}
