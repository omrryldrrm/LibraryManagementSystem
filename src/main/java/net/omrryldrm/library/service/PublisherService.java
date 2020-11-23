package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Publisher;

import java.util.List;


public interface PublisherService {
	List<Publisher> getPublisher();

	void savePublisher(Publisher publisher);

	Publisher getPublisherById(long id);

	void deletePublisherById(long id);

}
