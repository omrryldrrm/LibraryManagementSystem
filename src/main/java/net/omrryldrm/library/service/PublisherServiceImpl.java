package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Publisher;
import net.omrryldrm.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public List<Publisher> getPublisher() {
		return publisherRepository.findAll();
	}

	@Override
	public void savePublisher(Publisher publisher) {
		this.publisherRepository.save(publisher);

	}

	@Override
	public Publisher getPublisherById(long publisherId) {
		Optional<Publisher> optional = publisherRepository.findById(publisherId);
		Publisher publisher = null;
		if (optional.isPresent()) {
			publisher = optional.get();
		} else {
			throw new RuntimeException(" Publisher not found for id : " + publisherId);
		}
		return publisher;
	}

	@Override
	public void deletePublisherById(long publisherId) {
		this.publisherRepository.deleteById(publisherId);

	}

}
