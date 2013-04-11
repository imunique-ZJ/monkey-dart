package loopz.monkeydart.service;

import java.util.List;

import loopz.monkeydart.domain.Target;

public interface ITargetService {

	public List<Target> findAllTarget();
	
	public List<Target> findTargetByCat(String category);
	
	public List<String> findAllCategory();
}
