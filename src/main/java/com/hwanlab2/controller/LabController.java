package com.hwanlab2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hwanlab2.service.LabService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LabController {
	private final LabService labService;

	@GetMapping("/bye")
	public ResponseEntity<String> getGreet(@RequestParam String greeting) {
		return ResponseEntity.status(200).body(labService.greeting(greeting));
	}
}
