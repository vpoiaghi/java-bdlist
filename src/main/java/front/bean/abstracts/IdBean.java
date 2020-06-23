package front.bean.abstracts;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;

@ApiModel(value="IdBean", description="Bean with id and tsp")
public abstract class IdBean {

	private long id;
	private LocalDateTime tsp;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the tsp
	 */
	public LocalDateTime getTsp() {
		return tsp;
	}

	/**
	 * @param tsp the tsp to set
	 */
	public void setTsp(LocalDateTime tsp) {
		this.tsp = tsp;
	}

}
