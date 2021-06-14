package lombok.test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //파이널 생성자만 받음
public class Desk {
	private final double price;
	private final String model;
	private String name;
}
