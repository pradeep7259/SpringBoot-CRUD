package in.cerpsoft.service;

import java.util.stream.Stream;

import in.cerpsoft.entity.RoomSetupEntity;

public interface HostalService {

	RoomSetupEntity saveRoomSetup(RoomSetupEntity entity);
	
	Stream<RoomSetupEntity> fetchAllRooms();
	
	RoomSetupEntity findById(long id);
	
	RoomSetupEntity updateRoomSet(RoomSetupEntity entity, long id);
	
	void deleteRoomSetup(long id);
}
