package com.demo.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostBooks {
	private String userid;
	private List<String> collectionofIsbns;

}
