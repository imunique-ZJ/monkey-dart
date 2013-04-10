package loopz.monkeydart.dao;

import java.util.List;

public interface IDao<ENTITY, PK> {
	public List<ENTITY> findAll();
	public ENTITY findByPK(PK pk);
	public void insert(ENTITY entity);
	public void update(ENTITY entity);
	public void delete(PK pk);
}
