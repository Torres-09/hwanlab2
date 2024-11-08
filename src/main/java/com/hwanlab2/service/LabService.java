package com.hwanlab2.service;

import org.springframework.stereotype.Service;

import com.hwanlab2.repository.LabRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LabService {
	private final LabRepository labRepository;
}
