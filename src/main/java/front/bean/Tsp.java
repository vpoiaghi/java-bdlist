package front.bean;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="Tsp", description="A timestamp")
public class Tsp {

	private LocalDateTime tsp;

}
