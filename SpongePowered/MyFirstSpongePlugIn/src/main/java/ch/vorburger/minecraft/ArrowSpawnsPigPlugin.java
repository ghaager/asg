package ch.vorburger.minecraft;

import java.util.Optional;

import org.spongepowered.api.data.manipulator.mutable.entity.PassengerData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

//@Plugin(id = "ArrowSpawnsPig", name = "Arrow spawns Pig", version = "1.0.0-SNAPSHOT")
public class ArrowSpawnsPigPlugin {

	// private Arrow arrow;
	// private Pig arrowsPig;

	@Listener
	public void onEntitySpawn(SpawnEntityEvent event) {
		Entity spawnedEntity = null; // ? event.getTargetEntity();
		// TODO Xtend case switch
		if (spawnedEntity instanceof Arrow) {
			Arrow arrow = (Arrow) spawnedEntity;
			World world = arrow.getWorld();
			Location location = arrow.getLocation();
			Optional<Entity> optional = world.createEntity(EntityTypes.PIG, location.getPosition());
			if (optional.isPresent()) {
				Pig pig = (Pig) optional.get();
				world.spawnEntity(pig, null /*Cause.empty()*/);
				// arrowsPig = pig;
				// TODO Xtend: pig.setVehicle(arrow)
				setVehicle(pig, arrow);
			}
		}
	}

	// TODO Xtend static extension method
	public void setVehicle(Entity rider, Entity ridden) {
		Optional<PassengerData> passengerData = rider.getOrCreate(PassengerData.class);
		if (!passengerData.isPresent())
			throw new IllegalArgumentException("Cannot be a passenger: " + rider.toString());
		// TODO ?? passengerData.get().set(Keys.PASSENGER, ridden);
	}

	/*	This, as well as using EntityMoveEvent and other EntityDisplaceEvent subclasses, only ever gives PlayerMoveEvent, but never moving arrows or pigs. Why? (How to build custom AI for guys following around?)
	 *
	@Subscribe
	public void onEntityMove(EntityDisplaceEvent event) {
		System.out.println(event.toString());
		if (event.getEntity().equals(arrow)) {
			arrowsPig.setLocation(arrow.getLocation());
			System.out.println("pig followed arrow");
		}
	}
	 */
}
