package logic;

import entity.Boss;
import entity.Bullet;
import entity.Elemental;
import entity.Player;
import object.base.GameObject;

public class CalDamage {
	public static void calculateDamage(Bullet b, Player e) {
		double multiply = CalDamage.elementMuliplier(b, e);
		int newHealth = (int) Math.max(e.getHealth() - multiply * b.getDamage(), 0);
		// System.out.println(newHealth);
		e.setHealth(newHealth);
	}

	public static void calculateDamage(Bullet b, Boss e) {
		double multiply = CalDamage.elementMuliplier(b, e);
		int newHealth = (int) Math.max(e.getHealth() - multiply * b.getDamage(), 0);
		// System.out.println(newHealth);
		e.setHealth(newHealth);
	}

	public static double elementMuliplier(Bullet bullet, GameObject object) {
		if (object instanceof Player) {
			Player player = (Player) object;
			Elemental b = player.getElement();
			Elemental a = bullet.getElement();
			if (a.equals(Elemental.DEFAULT)) {
				return 1.0;
			} else if (b.equals(Elemental.DEFAULT)) {
				return 1.0;
			} else if (a.equals(b)) {
				return 1.0;
			} else if ((a.equals(Elemental.FIRE) && b.equals(Elemental.SNOW))
					|| (a.equals(Elemental.SNOW) && b.equals(Elemental.WATER))
					|| (a.equals(Elemental.WATER) && b.equals(Elemental.FIRE))) {
				return 1.5;
			} else if ((a.equals(Elemental.FIRE) && b.equals(Elemental.WATER))
					|| (a.equals(Elemental.WATER) && b.equals(Elemental.SNOW))
					|| (a.equals(Elemental.SNOW) && b.equals(Elemental.FIRE))) {
				return 0.75;
			}
			return 1.0;
		} else {
			Boss boss = (Boss) object;
			Elemental b = boss.getElement();
			Elemental a = bullet.getElement();
			if (a.equals(Elemental.DEFAULT)) {
				return 1.0;
			} else if (b.equals(Elemental.DEFAULT)) {
				return 1.0;
			} else if (a.equals(b)) {
				return 1.0;
			} else if ((a.equals(Elemental.FIRE) && b.equals(Elemental.SNOW))
					|| (a.equals(Elemental.SNOW) && b.equals(Elemental.WATER))
					|| (a.equals(Elemental.WATER) && b.equals(Elemental.FIRE))) {
				// System.out.println("crittttttttt");
				return 1.5;

			} else if ((a.equals(Elemental.FIRE) && b.equals(Elemental.WATER))
					|| (a.equals(Elemental.WATER) && b.equals(Elemental.SNOW))
					|| (a.equals(Elemental.SNOW) && b.equals(Elemental.FIRE))) {
				return 0.75;
			}
			return 1.0;
		}
	}
}
