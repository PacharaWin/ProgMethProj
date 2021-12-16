package constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import interfaces.Renderable;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<Renderable> entities;
	private Comparator<Renderable> comparator;

	static {
	}

	public RenderableHolder() {
		entities = new ArrayList<Renderable>();
		comparator = (Renderable o1, Renderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}


	public void remove(Renderable entity) {
		entities.remove(entity);
	}

	public void add(Renderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);

	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroy())
				entities.remove(i);
		}
	}

	public List<Renderable> getEntities() {
		return entities;
	}
}