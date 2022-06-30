package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KitchenService;
import com.example.demo.vo.Dish;

import reactor.core.publisher.Flux;

@RestController
public class ServerController {
	
	private final KitchenService kitchenService;
	
	public ServerController(KitchenService kitchenService) {
		this.kitchenService = kitchenService;
	}
	
	/**
	 * 서버가 접시를 가져옴
	 * 
	 * @return
	 */
	@GetMapping(value="/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> serveDishes() {
		return this.kitchenService.getDishes();
	}
	
	/**
	 * 배달됨
	 * 
	 * @return
	 */
	@GetMapping(value="/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> deliverDishes() {
		return this.kitchenService.getDishes().map(dish -> Dish.deliver(dish));
	}

}
