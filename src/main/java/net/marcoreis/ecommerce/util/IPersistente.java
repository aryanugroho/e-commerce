package net.marcoreis.ecommerce.util;

import java.io.Serializable;
import java.sql.Timestamp;

public interface IPersistente extends Serializable {
	Long getId();

	void setId(Long id);

}
