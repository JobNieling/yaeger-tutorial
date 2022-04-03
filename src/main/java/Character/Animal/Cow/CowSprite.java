package Character.Animal.Cow;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import Character.Animal.AnimalSprite;

public class CowSprite extends AnimalSprite{

	protected CowSprite(Coordinate2D initialLocation) {
		super("sprites/cow_finished.png", initialLocation, new Size(120, 60), 1, 1);
	}

}
