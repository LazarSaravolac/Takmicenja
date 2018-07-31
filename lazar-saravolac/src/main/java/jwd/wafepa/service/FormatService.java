package jwd.wafepa.service;

import jwd.wafepa.model.Format;

public interface FormatService {
	Format save(Format format);
	void delete(Long id);
	
}
