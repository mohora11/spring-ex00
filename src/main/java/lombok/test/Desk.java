package lombok.test;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString // tostring~~
@EqualsAndHashCode // equals hashcode ~~
@RequiredArgsConstructor //파이널 생성자만 받음
public class Desk {
	private final double price;
	private final String model;
	private String name;
}
