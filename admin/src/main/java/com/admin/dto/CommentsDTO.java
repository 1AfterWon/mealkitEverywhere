package com.admin.dto;

import lombok.Data;

@Data
public class CommentsDTO {
	private int commentsKey;
	private int adminKey;
	private int boardKey;
	private String content;
	private String rdate;
}
